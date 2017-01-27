package com.example.adrianmatuszewski.repoproject.View.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author adrian.matuszewski
 */
public class RecyclerViewItemClickListener implements RecyclerView.OnItemTouchListener {

    private final OnItemClickListener mItemClickListener;

    private final GestureDetector mGestureDetector;

    public RecyclerViewItemClickListener (final Context context, final OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
        mGestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(final RecyclerView recyclerView, final MotionEvent e) {
        final View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mItemClickListener != null && mGestureDetector.onTouchEvent(e)) {
            mItemClickListener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView));
        }

        return false;
    }

    @Override
    public void onTouchEvent(final RecyclerView recyclerView, final MotionEvent e) {
    }


    @Override
    public void onRequestDisallowInterceptTouchEvent(final boolean disallowIntercept) {
    }

    /**
     * This is item click listener
     */
    public interface OnItemClickListener {
        boolean onItemClick(final View view, final int position);
    }
}
