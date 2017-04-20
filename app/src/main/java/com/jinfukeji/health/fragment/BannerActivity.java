package com.jinfukeji.health.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jinfukeji.health.R;
import com.jinfukeji.health.activity.ChongzhiActivity;
import com.jinfukeji.health.activity.JiqishezhiActivity;
import com.jinfukeji.health.activity.LvxinActivity;
import com.jinfukeji.health.activity.MyshezhiActivity;
import com.jinfukeji.health.activity.MyzhangdanActivity;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by "于志渊"
 * 时间:"16:21"
 * 包名:com.jinfukeji.healthapp.activity
 * 描述:系统导航
 */

public class BannerActivity extends Fragment{
    LinearLayout lvxin_ll,myshezhi_ll,chongzhi_ll,zhangdan_ll,jiqishezhi_ll,fenxiang_ll;
    ImageView fanhui_img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_banner,null);
        ShareSDK.initSDK(getContext());
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
                showShare();
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

    //分享的share
    private void showShare(){
        ShareSDK.initSDK(getContext());
        OnekeyShare oks=new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("亚合水管家");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        //oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("为了饮水健康,亚合水管家为您保驾护航");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(getContext());
    }
}
