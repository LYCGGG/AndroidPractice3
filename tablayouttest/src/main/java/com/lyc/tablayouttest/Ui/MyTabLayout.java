package com.lyc.tablayouttest.Ui;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

/**
 * @author ：LYC
 * @date ：Created in 2020/10/9
 * @version:
 * @description：
 */
public class MyTabLayout extends TabLayout {
    public MyTabLayout(@NonNull Context context) {
        super(context);
    }

    public MyTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
