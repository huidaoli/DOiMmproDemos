package com.ab.db.orm.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.FIELD })
public @interface Column {

	/**
	 * 列名.
	 * 
	 * @return the string
	 */
	public abstract String name();

	/**
	 * 列类型.
	 * 
	 * @return the string
	 */
	public abstract String type() default "";

	/**
	 * 长度.
	 * 
	 * @return the int
	 */
	public abstract int length() default 0;

}
