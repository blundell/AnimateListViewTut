package com.blundell.tut.animatelistview.ui.adapter;

import java.util.ArrayList;

import com.blundell.tut.animatelistview.R;
import com.blundell.tut.animatelistview.domain.fruit.Fruit;
import com.blundell.tut.animatelistview.util.AnimationHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * This is a custom adapter for our Fruit, these are held in an Array. It uses a ViewHolder for recycling views.
 * It also uses a secondary array, this is a list of items that the user has pressed on to delete. A list is used
 * so that we can animate multiple user interactions. An animation is set on the row the user clicks on, when this animation
 * ends that is when the actual data is deleted.
 *
 * @author paul.blundell
 *
 */
public class FruitAdapter extends BaseAdapter {

	private final ArrayList<Fruit> fruits;
	private final LayoutInflater inflater;
	private final ArrayList<Fruit> deleteableItems;

	public FruitAdapter(ArrayList<Fruit> fruits, LayoutInflater inflater) {
		this.fruits = fruits;
		this.inflater = inflater;
		deleteableItems = new ArrayList<Fruit>();
	}

	@Override
	public int getCount() {
		return fruits.size();
	}

	@Override
	public Object getItem(int position) {
		return fruits.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void delete(int position) {
		deleteableItems.add(fruits.get(position));
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		// View holder for view recycling
		ViewHolder holder;
		if(view == null){
			view = inflater.inflate(R.layout.list_item_fruit, null);
			TextView type = (TextView) view.findViewById(R.id.textView1);
			TextView name = (TextView) view.findViewById(R.id.textView2);
			TextView color = (TextView) view.findViewById(R.id.textView3);

			holder = new ViewHolder();
			holder.type = type;
			holder.name = name;
			holder.color = color;

			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Get the fruit we want for this row
		Fruit item = fruits.get(position);
		// Populate the row
		holder.type.setText(item.type().toString());
		holder.name.setText(item.name());
		holder.color.setText(item.color().toString());
		// Now we check if this row has been 'long pressed' by the user
		// this is our queue to start the animation then delete the row
		checkIfItemHasBeenMarkedAsDeleted(view, item);

		return view;
	}

	// Loop around the list of deleted items
	private void checkIfItemHasBeenMarkedAsDeleted(View view, Fruit item) {
		for (Fruit deletable : deleteableItems) {
			deleteItemIfMarkedAsDeletable(view, item, deletable);
		}
	}

	// Check if this row item has been marked to be deleted
	// if it has we create a new animation
	// attach a listener for when that animation ends
	// then start the animation on our row
	private void deleteItemIfMarkedAsDeletable(View view, Fruit item, Fruit deletable) {
		if(itemIsDeletable(item, deletable)){
			Animation fadeout = AnimationHelper.createFadeoutAnimation();
			deleteOnAnimationComplete(fadeout, item);
			animate(view, fadeout);
		}
	}

	// The item is deletable if the ID for the fruit of this row matches
	// the id of any fruit in our list of deleteable fruits
	private static boolean itemIsDeletable(Fruit item, Fruit deletable) {
		return item.id() == deletable.id();
	}

	// This is our listener for when the delete animate completes
	// We then update our data set (removing the fruit)
	private void deleteOnAnimationComplete(Animation fadeout, final Fruit item) {
		fadeout.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) { }
			@Override
			public void onAnimationRepeat(Animation animation) { }

			@Override
			public void onAnimationEnd(Animation animation) {
				fruits.remove(item);
				deleteableItems.remove(item);
				notifyDataSetChanged();
			}
		});
	}

	// actually do the animate on our row
	private static void animate(View view, Animation animation) {
		view.startAnimation(animation);
	}

	private class ViewHolder {
		TextView type;
		TextView name;
		TextView color;
	}
}