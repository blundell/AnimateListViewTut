package com.blundell.tut.animatelistview.domain;

/**
 *
 * @author paul.blundell
 *
 */
public class Color {

	private final String color;

	private Color(String color){
		this.color = color;
	}

	public static final Color GREEN = new Color("Green");
	public static final Color ORANGE = new Color("Orange");
	public static final Color PURPLE = new Color("Purple");

	@Override
	public String toString() {
		return color;
	}

}
