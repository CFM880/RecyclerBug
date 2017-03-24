package com.cfm880.drag.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cfm880.drag.R;

/**
 * Created by chengfangming on 2017/3/17.
 */

public class TopBar extends RelativeLayout {

    private Button btn_left, btn_right;
    private TextView tv_title;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String topTitle;

    // 定义三个布局参数
    private LayoutParams leftParams, rightParams, titleParams;

    // 定义接口
    public interface TopBarClickListener{
        public void leftClick();
        public void rightClick();
    }


    // 创建事件接口
    public TopBarClickListener listener;

    // 设置监听器


    public void setListener(TopBarClickListener listener) {
        this.listener = listener;
    }

    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 获取XML中定义的属性到attrs中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        leftText = ta.getString(R.styleable.TopBar_leftText);


        rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        rightText = ta.getString(R.styleable.TopBar_rightText);

        titleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 0);
        titleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        topTitle = ta.getString(R.styleable.TopBar_topTitle);

        ta.recycle();

        btn_left = new Button(context);
        btn_right = new Button(context);
        tv_title = new TextView(context);
        // 设置值
        btn_left.setTextColor(leftTextColor);
        btn_left.setBackground(leftBackground);
        btn_left.setText(leftText);

        btn_right.setTextColor(rightTextColor);
        btn_right.setBackground(rightBackground);
        btn_right.setText(rightText);

        tv_title.setTextColor(titleTextColor);
        tv_title.setText(topTitle);
        tv_title.setTextSize(titleTextSize);
        tv_title.setGravity(Gravity.CENTER);
        // 设置布局属性宽和高
        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        addView(btn_left, leftParams);

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        addView(btn_right, rightParams);

        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        addView(tv_title, titleParams);
        // 设置监听器
        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                listener.leftClick();
            }
        });

        btn_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                listener.rightClick();
            }
        });

    }
    public void setLeftButtonVisibility(boolean flag){
        if (flag){
            btn_left.setVisibility(View.VISIBLE);
        } else {
            btn_left.setVisibility(View.GONE);
        }
        invalidate();
        requestLayout();
    }

    public void setRightButtonVisibility(boolean flag){
        if (flag){
            btn_right.setVisibility(View.VISIBLE);
        } else {
            btn_right.setVisibility(View.GONE);
        }
        invalidate();
        requestLayout();
    }
}
