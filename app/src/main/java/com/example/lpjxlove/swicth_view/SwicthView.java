package com.example.lpjxlove.swicth_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by LPJXLOVE on 2016/5/14.
 */
public class SwicthView extends FrameLayout implements View.OnClickListener {
    private TextView tv_first,tv_second;
    private Context context;
    private String frist_text;
    private String second_text;
    private int text_press_color;
    private int text_normal_color;
    private int press_background;
    private int normal_background;
    private ChangeFragmentListener changeFragment;

    public SwicthView(Context context) {
        this(context,null);
    }

    public SwicthView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwicthView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.SwicthView,defStyleAttr,0);
        frist_text=a.getString(R.styleable.SwicthView_first_text);
        second_text=a.getString(R.styleable.SwicthView_second_text);
        InitData();
    }

    private void InitData() {
        View view= LayoutInflater.from(context).inflate(R.layout.swicth_view_layout,this);
        tv_first= (TextView) view.findViewById(R.id.tv_first);
        tv_second= (TextView) view.findViewById(R.id.tv_second);
        tv_first.setOnClickListener(this);
        tv_second.setOnClickListener(this);
        text_press_color = Color.WHITE;
        text_normal_color =Color.DKGRAY;
        press_background=R.color.colorPrimary;
    }

    public void setSecond_text(String second_text) {
        this.second_text = second_text;
        postInvalidate();
    }

    public void setFrist_text(String frist_text) {
        this.frist_text = frist_text;
        postInvalidate();
    }

    public void setText_press_color(int text_press_color) {
        this.text_press_color = text_press_color;
        postInvalidate();
    }

    public void setText_normal_color(int text_normal_color) {
        this.text_normal_color = text_normal_color;
        postInvalidate();
    }

    public void setPress_background(int press_background) {
        this.press_background = press_background;
        postInvalidate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_first:
                ChangeFirst();
                changeFragment.Add_First_Fragment();
                break;
            case R.id.tv_second:
                ChangeSecond();
                changeFragment.Add_Second_Fragment();
                break;
        }

    }

    public void ChangeFirst(){
        tv_first.setText(frist_text);
        tv_first.setTextColor(text_press_color);
        tv_first.setBackgroundResource(press_background);
        tv_second.setTextColor(text_normal_color);
        tv_second.setText(second_text);
        tv_second.setBackgroundResource(normal_background);
    }
    public void ChangeSecond(){
        tv_second.setText(second_text);
        tv_second.setTextColor(text_press_color);
        tv_second.setBackgroundResource(press_background);
        tv_first.setText(frist_text);
        tv_first.setTextColor(text_normal_color);
        tv_first.setBackgroundResource(normal_background);
    }










    public TextView getTv_first() {
        return tv_first;
    }

    public TextView getTv_second() {
        return tv_second;
    }

    public String getFrist_text() {
        return frist_text;
    }

    public String getSecond_text() {
        return second_text;
    }

    public int getText_press_color() {
        return text_press_color;
    }

    public int getText_normal_color() {
        return text_normal_color;
    }

    public int getPress_background() {
        return press_background;
    }

    public int getNormal_background() {
        return normal_background;
    }

    public ChangeFragmentListener getChangeFragment() {
        return changeFragment;
    }

    public void setChangeFragment(ChangeFragmentListener changeFragment) {

        this.changeFragment = changeFragment;
    }

    public interface ChangeFragmentListener{
        void Add_First_Fragment();
        void Add_Second_Fragment();
    }


}
