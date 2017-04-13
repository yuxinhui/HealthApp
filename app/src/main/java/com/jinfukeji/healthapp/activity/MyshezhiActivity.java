package com.jinfukeji.healthapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinfukeji.healthapp.R;

/**
 * Created by "于志渊"
 * 时间:"14:59"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:我的设置界面
 */

public class MyshezhiActivity extends AppCompatActivity{
    ImageView fanhui_img;
    Button quxiao_btn,up_btn;
    TextView diqu_tv,xiangxi_tv;
    RelativeLayout diqu_rl;
    private int requestCode=101;//请求码
    private EditText name_et,phone_et,qq_et,sex_et;
    private String name,phone,qq,sex,diqu,adress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myshezhi);
        initView();
        initData();
        initOnclick();
    }

    //获取数据
    private void initData() {
        name=name_et.getText().toString();
        phone=phone_et.getText().toString();
        qq=qq_et.getText().toString();
        sex=sex_et.getText().toString();
        diqu=diqu_tv.getText().toString();
        adress=xiangxi_tv.getText().toString();
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
        diqu_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyshezhiActivity.this,ShowRegionActivity.class);
                intent.putExtra("address","address");
                intent.putExtra("allAddress","addAddress");
                startActivityForResult(intent,requestCode);
            }
        });
        up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
                if (TextUtils.isEmpty(name)){
                    name_et.requestFocus();
                    name_et.setError("姓名不能为空");
                    return;
                }
            }
        });
    }

    //控件初始化
    private void initView() {
        fanhui_img= (ImageView) this.findViewById(R.id.fanhui_img);
        name_et= (EditText) this.findViewById(R.id.name_et);
        phone_et= (EditText) this.findViewById(R.id.phone_et);
        qq_et= (EditText) this.findViewById(R.id.qq_et);
        sex_et= (EditText) this.findViewById(R.id.sex_et);
        diqu_tv= (TextView) this.findViewById(R.id.diqu_tv);
        xiangxi_tv= (TextView) this.findViewById(R.id.xiangxi_tv);
        diqu_rl= (RelativeLayout) this.findViewById(R.id.diqu_rl);
        quxiao_btn= (Button) this.findViewById(R.id.quxiao_btn);
        up_btn= (Button) this.findViewById(R.id.up_btn);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== 101 && resultCode == 102){
            diqu_tv.setText(data.getStringExtra("address"));
            xiangxi_tv.setText(data.getStringExtra("allAddress"));
        }
    }
}
