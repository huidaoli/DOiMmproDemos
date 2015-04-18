package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {

	/**
	 * Parses the specified JSON string into a parse tree
	 * 
	 * @param json
	 *            JSON text
	 * @return a parse tree of {@link JsonElement}s corresponding to the
	 *         specified JSON
	 * @throws JsonParseException
	 *             if the specified text is not valid JSON
	 * @since 1.3
	 */
	public JsonElement parse(String json) throws JsonSyntaxException {
		return parse(new StringReader(json));
	}

	/**
	 * Parses the specified JSON string into a parse tree
	 * 
	 * @param json
	 *            JSON text
	 * @return a parse tree of {@link JsonElement}s corresponding to the
	 *         specified JSON
	 * @throws JsonParseException
	 *             if the specified text is not valid JSON
	 * @since 1.3
	 */
	public JsonElement parse(Reader json) throws JsonIOException,
			JsonSyntaxException {
		try {
			JsonReader jsonReader = new JsonReader(json);
			JsonElement element = parse(jsonReader);
			if (!element.isJsonNull()
					&& jsonReader.peek() != JsonToken.END_DOCUMENT) {
				throw new JsonSyntaxException(
						"Did not consume the entire document.");
			}
			return element;
		} catch (MalformedJsonException e) {
			throw new JsonSyntaxException(e);
		} catch (IOException e) {
			throw new JsonIOException(e);
		} catch (NumberFormatException e) {
			throw new JsonSyntaxException(e);
		}
	}

	/**
	 * Returns the next value from the JSON stream as a parse tree.
	 * 
	 * @throws JsonParseException
	 *             if there is an IOException or if the specified text is not
	 *             valid JSON
	 * @since 1.6
	 */
	public JsonElement parse(JsonReader json) throws JsonIOException,
			JsonSyntaxException {
		boolean lenient = json.isLenient();
		json.setLenient(true);
		try {
			return Streams.parse(json);
		} catch (StackOverflowError e) {
			throw new JsonParseException("Failed parsing JSON source: " + json
					+ " to Json", e);
		} catch (OutOfMemoryError e) {
			throw new JsonParseException("Failed parsing JSON source: " + json
					+ " to Json", e);
		} catch (JsonParseException e) {
			if (e.getCause() instanceof EOFException) {
				return JsonNull.INSTANCE;
			}
			throw e;
		} finally {
			json.setLenient(lenient);
		}
	}
}
