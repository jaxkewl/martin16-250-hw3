package com.marshong.martin16_250_hw3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.marshong.martin16_250_hw3.R;

/**
 * Created by martin on 5/22/2015.
 */
public class CustomShapeView2 extends View implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    private final static String TAG = CustomShapeView2.class.getSimpleName();

    private int mCircleColor;
    private Paint mCirclePaint;
    private Point mCenter;
    private float mRadius = 50.0f;

    private Point mHomePoint;    //home point will be designated in the upper left corner

    //use the gesture detector to capture double tap events.
    //GOTCHA: implement the OnGestureListener
    private GestureDetector mGestureDetector;

    //GOTCHA: This constructor used when creating the view in code
    public CustomShapeView2(Context context) {
        super(context);
    }

    //GOTCHA: This constructor used when inflating the view from XML
    public CustomShapeView2(Context context, AttributeSet attrs) {
        super(context, attrs);

        //use this conversion to convert, 50dp to an integer value
        mRadius = context.getResources().getDimensionPixelSize(R.dimen.custom_shape_size);
        init(attrs, 0);
    }

    public CustomShapeView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //create a separate method for readability
    private void init(AttributeSet attrs, int defStyle) {
        //this method will initialize the views and the attributes

        //instantiate the GestureDetector.
        mGestureDetector = new GestureDetector(getContext(), this);

        //initialize circle attributes
        mCirclePaint = new Paint();
        mCirclePaint.setStyle(Paint.Style.FILL);

        //just set home to be the radius of the circle so the entire circle shows on the screen.
        mHomePoint = new Point((int) mRadius, (int) mRadius);

        //set the center of the circle to the home point
        mCenter = mHomePoint;

        //this is how to retrieve all the attributes that was set in XML
        if (null != attrs) {
            /*final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomShapeView, defStyle, 0);*/
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomShapeView2, 0, 0);
            mCircleColor = a.getInteger(R.styleable.CustomShapeView2_exampleColor, defStyle);
            //mRadius = a.getInteger(R.styleable.CustomShapeView2_exampleSize, defStyle);
            a.recycle();    //prepare the typed array ready for GC
        }

        mCirclePaint.setColor(mCircleColor);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        // Draw a circle at the center of the view
        canvas.drawCircle(mCenter.x,                // X-coordinate of circle center
                mCenter.y,              // Y-coordinate of circle center
                mRadius,                // Circle radius
                mCirclePaint);          // Circle Paint
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        //call the gesture detector touch event first
        mGestureDetector.onTouchEvent(event);

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                mCenter = new Point(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }

        invalidate();   //force redraw by invalidating the canvas
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTap...");
        //Toast.makeText(getContext(), "onDoubleTap...", Toast.LENGTH_SHORT).show();
        //mCenter = mHomePoint;
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTapEvent...");
        //Toast.makeText(getContext(), "onDoubleTapEvent...", Toast.LENGTH_SHORT).show();
        mCenter = mHomePoint;
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}

