package com.jinfukeji.healthapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jinfukeji.healthapp.R;
import com.jinfukeji.healthapp.activity.ChongxiAcitity;

/**
 * Created by "于志渊"
 * 时间:"16:20"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:系统主界面
 */

public class IndexActivity extends Fragment{
    ImageView kaiguan_img,shuaxin_img;
    Button chongxi_btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_index,null);
        initView(view);
        initClick();
        return view;
    }

    //点击事件
    private void initClick() {
        chongxi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_chongxi=new Intent(getContext(),ChongxiAcitity.class);
                startActivity(intent_chongxi);
            }
        });
    }

    //控件初始化
    private void initView(View view) {
        kaiguan_img= (ImageView) view.findViewById(R.id.kaiguan_img);
        shuaxin_img= (ImageView) view.findViewById(R.id.shuaxin_img);
        chongxi_btn= (Button) view.findViewById(R.id.chongxi_btn);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 00:
                String message=data.getExtras().getString("index");
                break;
            default:
                break;
        }
    }
}
