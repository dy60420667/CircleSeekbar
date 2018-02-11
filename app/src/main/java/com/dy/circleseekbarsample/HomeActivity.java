package com.dy.circleseekbarsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Descripty:
 * Auth:  邓渊  dymh21342@163.com
 * Date: 2018/2/11.14:48
 */

public class HomeActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.btn_CircleSeekBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircleSeekBarActivity.gotoActivity(HomeActivity.this);
            }
        });
        findViewById(R.id.btn_CircleLoadBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircleLoadBarActivity.gotoActivity(HomeActivity.this);
            }
        });
    }
}
