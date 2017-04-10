package com.jinfukeji.healthapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jinfukeji.healthapp.R;

/**
 * Created by "于志渊"
 * 时间:"10:58"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:点击配置弹出配置窗口界面
 */

public class PopupWindowActivity extends AppCompatActivity{
    EditText chanpinhao_et,mima_et;
    Button quxiao_btn,baocun_btn;
    LinearLayout popup_jiqipeizhi_ll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);
        initView();
        initOnclick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

    //点击事件
    private void initOnclick() {
        quxiao_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //销毁弹窗
                finish();
            }
        });
    }

    //控件初始化
    private void initView() {
        popup_jiqipeizhi_ll= (LinearLayout) this.findViewById(R.id.popup_jiqipeizhi_ll);
        chanpinhao_et= (EditText)findViewById(R.id.chanpinhao_et);
        mima_et= (EditText) findViewById(R.id.mima_et);
        quxiao_btn= (Button) findViewById(R.id.quxiao_btn);
        baocun_btn= (Button)findViewById(R.id.baocun_btn);
    }
}
