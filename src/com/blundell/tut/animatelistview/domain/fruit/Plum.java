package com.blundell.tut.animatelistview.domain.fruit;

import com.blundell.tut.animatelistview.domain.Color;
import com.blundell.tut.animatelistview.domain.Type;

/**
 *
 * @author paul.blundell
 *
 */
public class Plum extends Fruit {

	public Plum(String name) {
		super(name);
	}

	@Override
	public Type type() {
		return Type.PLUM;
	}

	@Override
	public Color color() {
		return Color.PURPLE;
	}

}
