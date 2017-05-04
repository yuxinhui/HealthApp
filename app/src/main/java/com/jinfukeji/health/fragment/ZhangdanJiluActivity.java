package com.jinfukeji.health.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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
import com.jinfukeji.health.adapter.ZhangdanJiluAdapter;
import com.jinfukeji.health.been.ZhangdanJiluBeen;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"15:27"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:我的账单充值记录界面
 */

public class ZhangdanJiluActivity extends Fragment{
    int serialNum;
    String url_zdjl;
    ZhangdanJiluAdapter mJiluAdapter;
    private ArrayList<ZhangdanJiluBeen.MessageBean> messageBeen=new ArrayList<ZhangdanJiluBeen.MessageBean>();
    ZhangdanJiluBeen mJiluBeen=new ZhangdanJiluBeen();
    ListView zhangdan_jilu_lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_zhangdan_jilu,null);
        SharedPreferences sp=getActivity().getSharedPreferences("peizhi_xulie", Context.MODE_PRIVATE);
        serialNum=sp.getInt("xulie_num",0);
        url_zdjl= HealthActivity.getUrlMain()+"recharge/query?serialNumber="+serialNum;
        Log.e("url_zdjl",url_zdjl);
        initData();
        initView(view);//初始化控件
        return view;
    }

    //初始化控件
    private void initView(View view) {
        zhangdan_jilu_lv= (ListView) view.findViewById(R.id.zhangdan_jilu_lv);
        mJiluAdapter=new ZhangdanJiluAdapter(messageBeen,getContext());
        zhangdan_jilu_lv.setAdapter(mJiluAdapter);
    }

    private void initData() {
        RequestQueue queue= Volley.newRequestQueue(getContext());
        StringRequest request=new StringRequest(Request.Method.POST, url_zdjl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (s != null){
                            Gson gson=new Gson();
                            mJiluBeen=gson.fromJson(s,ZhangdanJiluBeen.class);
                            ZhangdanJiluBeen.MessageBean messageBeen1=mJiluBeen.getMessage();
                            messageBeen.add(messageBeen1);
                            mJiluAdapter.notifyDataSetChanged();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getContext(),"请检查网络连接",Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
}
