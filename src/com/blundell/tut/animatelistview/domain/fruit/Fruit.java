package com.blundell.tut.animatelistview.domain.fruit;

import com.blundell.tut.animatelistview.domain.Color;
import com.blundell.tut.animatelistview.domain.Type;

/**
 *
 * @author paul.blundell
 *
 */
public abstract class Fruit {

	private final String name;
	private final int id;

	/**
	 * Create a new fruit with the given name, each fruit is given a unique ID
	 * @param name
	 */
	public Fruit(String name) {
		id = getNewId();
		this.name = name;
	}

	public abstract Type type();
	public abstract Color color();

	public int id(){
		return id;
	}

	public String name(){
		return name;
	}

	// Unique ID is generated using a static count, you probably would
	// want something a bit more robust in production
	private static int i = 0;
	private static int getNewId(){
		return i++;
	}
}
