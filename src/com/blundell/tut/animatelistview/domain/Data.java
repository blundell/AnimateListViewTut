package com.blundell.tut.animatelistview.domain;

import java.util.ArrayList;

import com.blundell.tut.animatelistview.domain.fruit.Apple;
import com.blundell.tut.animatelistview.domain.fruit.Fruit;
import com.blundell.tut.animatelistview.domain.fruit.Orange;
import com.blundell.tut.animatelistview.domain.fruit.Plum;

/**
 *
 * @author paul.blundell
 *
 */
public class Data {

	/**
	 * Static fruit data to populate our list, who knew there where 'Navel' oranges !?
	 */
	public static ArrayList<Fruit> FRUITS = new ArrayList<Fruit>();
	static{
		FRUITS.add(new Apple("Granny Smith"));
		FRUITS.add(new Plum("Italian"));
		FRUITS.add(new Orange("Navel"));
		FRUITS.add(new Apple("Granny Smith"));
		FRUITS.add(new Plum("Black"));
		FRUITS.add(new Apple("Crab"));
		FRUITS.add(new Orange("Florida"));
		FRUITS.add(new Plum("Cherry"));
		FRUITS.add(new Orange("Florida"));
		FRUITS.add(new Orange("Navel"));
		FRUITS.add(new Apple("Cooking"));
		FRUITS.add(new Orange("Blood"));
		FRUITS.add(new Plum("Cherry"));
		FRUITS.add(new Plum("Cherry"));
		FRUITS.add(new Orange("Blood"));
		FRUITS.add(new Plum("Black"));
		FRUITS.add(new Apple("Granny Smith"));
		FRUITS.add(new Plum("Italian"));
		FRUITS.add(new Orange("Florida"));
	}

}
