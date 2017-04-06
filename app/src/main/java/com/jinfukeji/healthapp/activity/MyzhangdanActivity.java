package com.jinfukeji.healthapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jinfukeji.healthapp.R;

/**
 * Created by "于志渊"
 * 时间:"16:33"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:我的账单界面
 */

public class MyzhangdanActivity extends AppCompatActivity{
    ImageView fanhui_img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myzhangdan);
        initView();
        initOncliak();
    }
    //点击事件
    private void initOncliak() {
        fanhui_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("banner",4);
                setResult(44,intent);
                finish();
            }
        });
    }

    //控件初始化
    private void initView() {
        fanhui_img= (ImageView) this.findViewById(R.id.fanhui_img);
    }
}
