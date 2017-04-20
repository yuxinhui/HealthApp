package com.jinfukeji.health.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jinfukeji.health.R;
import com.jinfukeji.health.activity.ChongzhiActivity;

/**
 * Created by "于志渊"
 * 时间:"15:30"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:我的账单余额界面
 */

public class ZhangdanYueActivity extends Fragment{
    private LinearLayout yue_chongzhi_ll;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_zhangdan_yue,null);
        initView(view);
        initOnclick();
        return view;
    }

    private void initOnclick() {
        yue_chongzhi_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ChongzhiActivity.class));
                getActivity().finish();
            }
        });
    }

    //初始化控件
    private void initView(View view) {
        yue_chongzhi_ll= (LinearLayout) view.findViewById(R.id.yue_chongzhi_ll);
    }
}
