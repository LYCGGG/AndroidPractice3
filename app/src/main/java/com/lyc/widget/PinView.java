package com.lyc.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author ：LYC
 * @date ：Created in 2020/9/21
 * @version: 0.1
 * @description： 创建PinView用于设置自定义密码框
 */
public class PinView extends androidx.appcompat.widget.AppCompatEditText {
    public PinView(@NonNull Context context) {
        super(context);
    }

    public PinView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

//    画线
    private Paint linePaint;
//    画圆
    private Paint cirPaint;
//    控件宽度
    private int width;
//    控件高度
    private int height;
//    框内填充色
    private Paint kPaintColor;
//    
}
