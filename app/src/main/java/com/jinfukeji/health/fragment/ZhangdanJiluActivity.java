package com.jinfukeji.health.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinfukeji.health.HealthActivity;
import com.jinfukeji.health.R;

/**
 * Created by "于志渊"
 * 时间:"15:27"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:我的账单充值记录界面
 */

public class ZhangdanJiluActivity extends Fragment{
    //int serialNum;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_zhangdan_jilu,null);
        /*SharedPreferences sp=getActivity().getSharedPreferences("peizhi_xulie", Context.MODE_PRIVATE);
        serialNum=sp.getInt("xulie_num",0);*/
        String url_zdjl= HealthActivity.getUrlMain()+"recharge/query?serialNumber=123";
        Log.e("url_zdjl",url_zdjl);
        return view;
    }
}
