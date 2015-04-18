package com.ab.network.toolbox;

/**
 * Indicates that the error responded with an error response.
 */
@SuppressWarnings("serial")
public class ServerError extends VolleyError {
	public ServerError(NetworkResponse networkResponse) {
		super(networkResponse);
	}

	public ServerError() {
		super();
	}
}
