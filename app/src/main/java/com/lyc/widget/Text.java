package com.lyc.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.lyc.pinpractice.R;

/**
 * @author ：LYC
 * @date ：Created in 2020/10/21
 * @version:
 * @description：
 */
public class Text extends androidx.appcompat.widget.AppCompatTextView {
    private Context context;

    public Text(Context context) {
        super(context);
        this.context = context;
        inti();
    }

    private void inti() {
        Drawable drawable = ContextCompat.getDrawable(context,R.drawable.ic_test);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        setCompoundDrawables(null,null,drawable,null);
        setGravity(Gravity.BOTTOM);
    }

    public Text(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        inti();
    }
    
    public Text(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        inti();
    }


}
