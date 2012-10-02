package com.blundell.tut.animatelistview.ui;

import com.blundell.tut.animatelistview.R;
import com.blundell.tut.animatelistview.domain.Data;
import com.blundell.tut.animatelistview.ui.widget.FruitListView;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * @author paul.blundell
 *
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FruitListView list = (FruitListView) findViewById(R.id.listView_fruits);
        list.addFruit(Data.FRUITS);
    }

}