package com.jinfukeji.healthapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jinfukeji.healthapp.R;
import com.jinfukeji.healthapp.activity.ChongzhiActivity;
import com.jinfukeji.healthapp.activity.JiqishezhiActivity;
import com.jinfukeji.healthapp.activity.LvxinActivity;
import com.jinfukeji.healthapp.activity.MyshezhiActivity;
import com.jinfukeji.healthapp.activity.MyzhangdanActivity;

/**
 * Created by "于志渊"
 * 时间:"16:21"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:系统导航
 */

public class BannerActivity extends Fragment{
    //fragment管理对象
    FragmentManager fm;
    FragmentTransaction ft;
    IndexActivity ia=new IndexActivity();

    LinearLayout lvxin_ll,myshezhi_ll,chongzhi_ll,zhangdan_ll,jiqishezhi_ll,fenxiang_ll;
    ImageView fanhui_img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_banner,null);
        initView(view);
        initOnclick();
        return view;
    }

    //点击事件
    private void initOnclick() {
        lvxin_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lvxin=new Intent(getContext(), LvxinActivity.class);
                startActivity(lvxin);
            }
        });
        myshezhi_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myhezhi=new Intent(getContext(), MyshezhiActivity.class);
                startActivity(myhezhi);
            }
        });
        chongzhi_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chongzhi=new Intent(getContext(),ChongzhiActivity.class);
                startActivity(chongzhi);
            }
        });
        zhangdan_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zhangdan=new Intent(getContext(),MyzhangdanActivity.class);
                startActivity(zhangdan);
            }
        });
        jiqishezhi_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jiqishezhi=new Intent(getContext(),JiqishezhiActivity.class);
                startActivity(jiqishezhi);
            }
        });
        fenxiang_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("https://www.baidu.com/"));
                startActivity(Intent.createChooser(intent,"分享"));
            }
        });
    }

    //控件初始化
    private void initView(View view) {
        fanhui_img= (ImageView) view.findViewById(R.id.fanhui_img);
        lvxin_ll= (LinearLayout) view.findViewById(R.id.lvxin_ll);
        myshezhi_ll= (LinearLayout) view.findViewById(R.id.myshezhi_ll);
        chongzhi_ll= (LinearLayout) view.findViewById(R.id.chongzhi_ll);
        zhangdan_ll= (LinearLayout) view.findViewById(R.id.zhangdan_ll);
        jiqishezhi_ll= (LinearLayout) view.findViewById(R.id.jiqishezhi_ll);
        fenxiang_ll= (LinearLayout) view.findViewById(R.id.fenxiang_ll);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 11:
                String s=data.getExtras().getString("banner");
                break;
            case 22:
                String s1=data.getExtras().getString("banner");
                break;
            case 33:
                String s2=data.getExtras().getString("banner");
                break;
            case 44:
                String s3=data.getExtras().getString("banner");
                break;
            case 55:
                String s4=data.getExtras().getString("banner");
                break;
            default:
                break;
        }
    }
}
