package com.ab.view.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface AbIocSelect.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AbIocSelect {

	/**
	 * Selected.
	 * 
	 * @return the string
	 */
	public String selected();

	/**
	 * No selected.
	 * 
	 * @return the string
	 */
	public String noSelected() default "";

}
