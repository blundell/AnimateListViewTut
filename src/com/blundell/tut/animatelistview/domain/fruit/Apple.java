package com.blundell.tut.animatelistview.domain.fruit;

import com.blundell.tut.animatelistview.domain.Color;
import com.blundell.tut.animatelistview.domain.Type;

/**
 *
 * @author paul.blundell
 *
 */
public class Apple extends Fruit {

	public Apple(String name) {
		super(name);
	}

	@Override
	public Type type() {
		return Type.APPLE;
	}

	@Override
	public Color color() {
		return Color.GREEN;
	}

}
