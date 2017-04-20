package com.jinfukeji.health.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinfukeji.health.R;

/**
 * Created by "于志渊"
 * 时间:"16:14"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:占位界面
 */

public class NullActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_null,null);
        return view;
    }
}
