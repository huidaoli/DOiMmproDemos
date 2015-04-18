package com.ab.network;

import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONException;

import com.ab.network.toolbox.HttpHeaderParser;
import com.ab.network.toolbox.NetworkResponse;
import com.ab.network.toolbox.ParseError;
import com.ab.network.toolbox.Response;
import com.ab.network.toolbox.Response.ErrorListener;
import com.ab.network.toolbox.Response.Listener;

/**
 * A request for retrieving a {@link JSONArray} response body at a given URL.
 */
public class JsonArrayRequest extends JsonRequest<JSONArray> {

	/**
	 * Creates a new request.
	 * 
	 * @param url
	 *            URL to fetch the JSON from
	 * @param listener
	 *            Listener to receive the JSON response
	 * @param errorListener
	 *            Error listener, or null to ignore errors.
	 */
	public JsonArrayRequest(String url, Listener<JSONArray> listener,
			ErrorListener errorListener) {
		super(Method.GET, url, null, listener, errorListener);
	}

	@Override
	protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			return Response.success(new JSONArray(jsonString),
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JSONException je) {
			return Response.error(new ParseError(je));
		}
	}
}
