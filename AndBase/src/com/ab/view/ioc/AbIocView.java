package com.ab.view.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface AbIocView.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AbIocView {

	/**
	 * Id.
	 * 
	 * @return the int
	 */
	public int id();

	/**
	 * Click.
	 * 
	 * @return the string
	 */
	public String click() default "";

	/**
	 * Long click.
	 * 
	 * @return the string
	 */
	public String longClick() default "";

	/**
	 * Item click.
	 * 
	 * @return the string
	 */
	public String itemClick() default "";

	/**
	 * Item long click.
	 * 
	 * @return the string
	 */
	public String itemLongClick() default "";

	/**
	 * Select.
	 * 
	 * @return the ab ioc select
	 */
	public AbIocSelect select() default @AbIocSelect(selected = "");
}
