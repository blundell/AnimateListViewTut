package com.blundell.tut.animatelistview.ui.widget;

import java.util.ArrayList;

import com.blundell.tut.animatelistview.domain.fruit.Fruit;
import com.blundell.tut.animatelistview.ui.adapter.FruitAdapter;
import com.blundell.tut.animatelistview.util.AnimationHelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Our listview for showing fruit. You can call addFruit to populate the list.
 * We have also added an Animation so the list is populated nicely from top to bottom
 * @author paul.blundell
 *
 */
public class FruitListView extends ListView implements android.widget.AdapterView.OnItemLongClickListener {

	private FruitAdapter fruitAdapter;

	public FruitListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public FruitListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public FruitListView(Context context) {
		super(context);
		init();
	}

	// Populate our list view
	// we pass the layout inflater to the adapter for efficiency
	// also allows us to keep a reference to the adapter
	public void addFruit(ArrayList<Fruit> fruits) {
		fruitAdapter = new FruitAdapter(fruits, LayoutInflater.from(getContext()));
		setAdapter(fruitAdapter);
	}

	private void init() {
		setPopulationAnimation();
		setOnItemLongClickListener(this);
	}

	// Add a new animation for when the view is layed out
	// this will add our items to the list in a nice controlled fashion top to bottom
	private void setPopulationAnimation() {
		AnimationSet set = new AnimationSet(true);

		Animation animation = AnimationHelper.createFadeInAnimation();
		set.addAnimation(animation);

		LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);
		setLayoutAnimation(controller);
	}

	// Add a listener so we know when the user is long pressing on one of our rows
	// we then pass this interaction to the adapter
	@Override
	public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
		fruitAdapter.delete(position);
		return true;
	}
}
