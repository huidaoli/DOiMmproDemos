package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/**
 * Internal-only APIs of Gson available only to other classes in Gson.
 */
public abstract class GsonInternalAccess {
	public static GsonInternalAccess INSTANCE;

	/**
	 * Returns a type adapter for {@code} type that isn't {@code skipPast}. This
	 * can be used for type adapters to compose other, simpler type adapters.
	 * 
	 * @throws IllegalArgumentException
	 *             if this GSON cannot serialize and deserialize {@code type}.
	 */
	public abstract <T> TypeAdapter<T> getNextAdapter(Gson gson,
			TypeAdapterFactory skipPast, TypeToken<T> type);
}
