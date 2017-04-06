package com.jinfukeji.healthapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jinfukeji.healthapp.R;

/**
 * Created by "于志渊"
 * 时间:"14:59"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:我的设置界面
 */

public class MyshezhiActivity extends AppCompatActivity{
    ImageView fanhui_img;
    Button quxiao_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myshezhi);
        initView();
        initOnclick();
    }

    //点击事件
    private void initOnclick() {
        fanhui_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("banner",2);
                setResult(22,intent);
                finish();
            }
        });
        quxiao_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //控件初始化
    private void initView() {
        fanhui_img= (ImageView) this.findViewById(R.id.fanhui_img);
        quxiao_btn= (Button) this.findViewById(R.id.quxiao_btn);
    }
}
