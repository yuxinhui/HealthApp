package com.jinfukeji.healthapp.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
    Dialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog=new Dialog(this,R.style.PeizhiPopupWindow);
        dialog.setContentView(R.layout.popup_window);
        dialog.show();
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.quxiao_btn:
                        //取消
                        finish();
                        break;
                }
                dialog.dismiss();
            }
        };
        initView(listener);
        Window window=dialog.getWindow();
        window.getDecorView().setPadding(0,0,0,0);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.BOTTOM;
        window.setAttributes(params);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

    //控件初始化
    private void initView(View.OnClickListener listener) {
        popup_jiqipeizhi_ll= (LinearLayout) dialog.findViewById(R.id.popup_jiqipeizhi_ll);
        chanpinhao_et= (EditText)dialog.findViewById(R.id.chanpinhao_et);
        mima_et= (EditText) dialog.findViewById(R.id.mima_et);
        quxiao_btn= (Button) dialog.findViewById(R.id.quxiao_btn);
        baocun_btn= (Button)dialog.findViewById(R.id.baocun_btn);

        quxiao_btn.setOnClickListener(listener);
    }
}
