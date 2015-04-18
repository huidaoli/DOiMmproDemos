package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
	public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
		@SuppressWarnings("unchecked")
		// we use a runtime check to make sure the 'T's equal
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
			return typeToken.getRawType() == Time.class ? (TypeAdapter<T>) new TimeTypeAdapter()
					: null;
		}
	};

	private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

	@Override
	public synchronized Time read(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL) {
			in.nextNull();
			return null;
		}
		try {
			Date date = format.parse(in.nextString());
			return new Time(date.getTime());
		} catch (ParseException e) {
			throw new JsonSyntaxException(e);
		}
	}

	@Override
	public synchronized void write(JsonWriter out, Time value)
			throws IOException {
		out.value(value == null ? null : format.format(value));
	}
}
