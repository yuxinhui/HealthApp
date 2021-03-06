package com.jinfukeji.health.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.jinfukeji.health.HealthActivity;
import com.jinfukeji.health.R;
import com.jinfukeji.health.been.MyshezhiBeen;

import java.util.Calendar;

/**
 * Created by "于志渊"
 * 时间:"14:59"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:我的设置界面
 */

public class MyshezhiActivity extends AppCompatActivity{
    ImageView fanhui_img;
    Button quxiao_btn,up_btn;
    TextView diqu_tv,xiangxi_tv,myshezhi_shengri_tv;
    LinearLayout diqu_rl,shengri_ll;
    private int requestCode=101,mYear,mMonth,mDay,serialNumber;//请求码
    private final int DATE_DIALOGE=1;
    private EditText name_et,phone_et,qq_et,sex_et;
    private String name,phone,qq,sex,diqu,adress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myshezhi);
        SharedPreferences sp=getSharedPreferences("peizhi_xulie", Context.MODE_PRIVATE);
        serialNumber=sp.getInt("xulie_num",1);
        initView();
        initData();
        initOnclick();
        setDate();//设置日期
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
        shengri_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOGE);
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
                if (TextUtils.isEmpty(phone)){
                    phone_et.requestFocus();
                    phone_et.setError("手机号不能为空");
                    return;
                }
                if (phone.length() != 11 || !phone.startsWith("1")){
                    phone_et.requestFocus();
                    phone_et.setError("请输入以1开头正确11位的手机号");
                    return;
                }
                if (TextUtils.isEmpty(qq)){
                    qq_et.setError("QQ号不能为空");
                    qq_et.requestFocus();
                    return;
                }
                if (!(qq.length()>=5) || !(qq.length()<=10)){
                    qq_et.setError("请输入5-10位的QQ号");
                    qq_et.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(sex)){
                    sex="男";
                    return;
                }
                String url_myshezhi= HealthActivity.getUrlMain()+"user/addUser?name="+name+"&phone="
                        +phone+"&qq="+qq+"&gender="+sex+"&region="+diqu+"&address="+adress+"&serialNumber="+serialNumber;
                Log.e("url_myshezhi",url_myshezhi);
                myshezhi(url_myshezhi);
            }
        });
    }

    //请求提交我的设置
    private void myshezhi(String url_myshezhi) {
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        StringRequest request=new StringRequest(Request.Method.POST, url_myshezhi,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (s != null){
                            Gson gson=new Gson();
                            MyshezhiBeen myshezhiBeen=gson.fromJson(s,MyshezhiBeen.class);
                            if ("ok".equals(myshezhiBeen.getStatus())){
                                finish();
                                Toast.makeText(MyshezhiActivity.this,"设置成功",Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(MyshezhiActivity.this,"设置失败",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MyshezhiActivity.this,"请检查网络连接，提交失败",Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }

    //控件初始化
    private void initView() {
        fanhui_img= (ImageView) this.findViewById(R.id.fanhui_img);
        name_et= (EditText) this.findViewById(R.id.myshezhi_name_et);
        phone_et= (EditText) this.findViewById(R.id.myshezhi_phone_et);
        qq_et= (EditText) this.findViewById(R.id.myshezhi_qq_et);
        sex_et= (EditText) this.findViewById(R.id.myshezhi_sex_et);
        diqu_tv= (TextView) this.findViewById(R.id.myshezhi_quyu_et);
        xiangxi_tv= (TextView) this.findViewById(R.id.myshezhi_address_et);
        diqu_rl= (LinearLayout) this.findViewById(R.id.diqu_rl);
        quxiao_btn= (Button) this.findViewById(R.id.quxiao_btn);
        up_btn= (Button) this.findViewById(R.id.up_btn);
        myshezhi_shengri_tv= (TextView) this.findViewById(R.id.myshezhi_shengri_tv);
        shengri_ll= (LinearLayout) this.findViewById(R.id.myshezhi_shengri_ll);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== 101 && resultCode == 102){
            diqu_tv.setText(data.getStringExtra("address"));
            xiangxi_tv.setText(data.getStringExtra("allAddress"));
        }
    }

    //设置日期
    private void setDate(){
        final Calendar ad=Calendar.getInstance();
        mYear=ad.get(Calendar.YEAR);
        mMonth=ad.get(Calendar.MONTH);
        mDay=ad.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOGE:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mdateListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            mYear=year;
            mMonth=monthOfYear;
            mDay=dayOfMonth;
            display();
        }
    };

    //设置日期 利用StringBuffer追加
    private void display() {
        myshezhi_shengri_tv.setText(new StringBuffer().append(mYear).append("-").append(mMonth+1).append("-")
        .append(mDay).append(" "));
    }
}
