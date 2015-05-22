package com.marshong.martin16_250_hw3.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.marshong.martin16_250_hw3.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


/*
Create the circle
1. We need to create a custom view java class. instead of using TextView, ImageView, etc,
   we define a new java class called CustomShapeView
2. Inside the layout xml, we can reference to this custom view, by using the
   fully qualified name (package + class name). **It is the layout file that points to the
   java class file. Not the other way around.
3. We can set properties in the values xml file so nothing is hard coded
4. You can use the automatic CustomShape Android generator to create the layout,
   java class, and attrs* values xml file automatically or do it by hand.
5. You'll need a java class that extends View and implements a constructor (see GOTCHA),
   an attributes.xml file in the values res, and a layout for the custom view that
   the fragment manager can inflate.
6. In the draw method, here is where we draw the shape we want with the parameters specified.
7. Create an init method for readability. In here we can get the attributes that
   were defined in the custom shape layout file.
8. To handle the touchEvent, override method onTouchEvent. The method comments should be
   descriptive.
9. To convert 50dp to an integer value:
   mRadius = context.getResources().getDimensionPixelSize(R.dimen.custom_shape_size);

*/
