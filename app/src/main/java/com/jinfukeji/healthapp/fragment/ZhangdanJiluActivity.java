package com.jinfukeji.healthapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinfukeji.healthapp.R;

/**
 * Created by "于志渊"
 * 时间:"15:27"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:我的账单充值记录界面
 */

public class ZhangdanJiluActivity extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_zhangdan_jilu,null);
        return view;
    }
}
