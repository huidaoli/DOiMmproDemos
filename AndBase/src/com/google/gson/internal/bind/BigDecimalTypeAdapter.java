package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.math.BigDecimal;

public final class BigDecimalTypeAdapter extends TypeAdapter<BigDecimal> {

	@Override
	public BigDecimal read(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL) {
			in.nextNull();
			return null;
		}
		try {
			return new BigDecimal(in.nextString());
		} catch (NumberFormatException e) {
			throw new JsonSyntaxException(e);
		}
	}

	@Override
	public void write(JsonWriter out, BigDecimal value) throws IOException {
		out.value(value);
	}
}
