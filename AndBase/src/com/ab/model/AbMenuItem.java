package com.ab.model;

public class AbMenuItem {

	/** 菜单的id. */
	private int id;

	/** 菜单的图标id. */
	private int iconId;

	/** 菜单的文本. */
	private String text;

	/** 菜单的描述. */
	private String mark;

	/**
	 * Instantiates a new ab menu item.
	 * 
	 * @param id
	 *            the id
	 * @param text
	 *            the text
	 */
	public AbMenuItem(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	/**
	 * Instantiates a new ab menu item.
	 * 
	 * @param text
	 *            the text
	 */
	public AbMenuItem(String text) {
		super();
		this.text = text;
	}

	/**
	 * Instantiates a new ab menu item.
	 * 
	 */
	public AbMenuItem() {
		super();
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the icon id.
	 * 
	 * @return the icon id
	 */
	public int getIconId() {
		return iconId;
	}

	/**
	 * Sets the icon id.
	 * 
	 * @param iconId
	 *            the new icon id
	 */
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the mark.
	 * 
	 * @return the mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * Sets the mark.
	 * 
	 * @param mark
	 *            the new mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

}
