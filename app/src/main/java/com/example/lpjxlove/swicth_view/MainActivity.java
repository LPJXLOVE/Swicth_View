package com.example.lpjxlove.swicth_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SwicthView.ChangeFragmentListener{
    private TextView tv_tip;
    private SwicthView swicthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        tv_tip= (TextView) findViewById(R.id.tv_tip);
        swicthView= (SwicthView) findViewById(R.id.s);
        swicthView.setChangeFragment(this);
        swicthView.setFrist_text("你好");
    }


    @Override
    public void Add_First_Fragment() {
        tv_tip.setText("第一个");

    }

    @Override
    public void Add_Second_Fragment() {
        tv_tip.setText("第二个");

    }
}
