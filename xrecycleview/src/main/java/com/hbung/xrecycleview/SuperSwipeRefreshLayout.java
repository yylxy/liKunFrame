package com.hbung.xrecycleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * 作者　　: 李坤
 * 创建时间: 12:49 Administrator
 * 邮箱　　：496546144@qq.com
 * <p>
 * 功能介绍：
 */


public class SuperSwipeRefreshLayout extends SwipeRefreshLayout {

    OnRefreshListener mListener;
    View view = null;
    boolean isMOVE = false;

    public SuperSwipeRefreshLayout(Context context) {
        this(context,null);
    }

    public SuperSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.getTheme().obtainStyledAttributes(new int[]{R.attr.SwipeRefreshLayout_Color1, R.attr.SwipeRefreshLayout_Color2, R.attr.SwipeRefreshLayout_Color3, R.attr.SwipeRefreshLayout_Color4});
        setColorSchemeColors(array.getColor(0, 0xff0000), array.getColor(1, 0xff0000), array.getColor(2, 0xff0000), array.getColor(3, 0xff0000));
        array.recycle();
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if (isMOVE) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setViewPager(View view) {
        this.view = view;
        view.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        isMOVE = true;
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        isMOVE = false;
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void setRefreshing(final boolean refreshing) {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                SuperSwipeRefreshLayout.super.setRefreshing(refreshing);
                if (refreshing) {
                    mListener.onRefresh();
                }
            }
        }, 400);

    }

    @Override
    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mListener = listener;
        super.setOnRefreshListener(listener);
    }
}
