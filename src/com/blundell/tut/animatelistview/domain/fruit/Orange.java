package com.blundell.tut.animatelistview.domain.fruit;

import com.blundell.tut.animatelistview.domain.Color;
import com.blundell.tut.animatelistview.domain.Type;

/**
 *
 * @author paul.blundell
 *
 */
public class Orange extends Fruit {

	public Orange(String name) {
		super(name);
	}

	@Override
	public Type type() {
		return Type.ORANGE;
	}

	@Override
	public Color color() {
		return Color.ORANGE;
	}

}
