package com.jinfukeji.health.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jinfukeji.health.R;

/**
 * Created by "于志渊"
 * 时间:"10:32"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:冲洗界面
 */

public class ChongxiAcitity extends AppCompatActivity{
    ImageView fanhui_img;
    Button chongxi_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chongxi);
        initView();
        initOnclick();
    }

    //跳转事件
    private void initOnclick() {
        fanhui_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("index",1);
                setResult(00,intent);
                finish();
            }
        });
    }

    //控件初始化
    private void initView() {
        fanhui_img= (ImageView) this.findViewById(R.id.fanhui_img);
        chongxi_btn= (Button) this.findViewById(R.id.chongxi_btn);
    }
}
