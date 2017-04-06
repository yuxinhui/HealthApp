package com.jinfukeji.healthapp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jinfukeji.healthapp.fragment.BannerActivity;
import com.jinfukeji.healthapp.fragment.IndexActivity;
import com.jinfukeji.healthapp.fragment.NullActivity;

import java.util.ArrayList;
import java.util.List;

/**
* 主界面
 * ip地址是192.168.0.110
 * */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup mRadioGroup;
    private RadioButton yi,er;
    private float mCurrentCheckedRadioLeft;//当前被选中的RadioButton距离左侧的距离
    HorizontalScrollView mHorizontalScrollView;//上面的水平滚动控件
    ViewPager mViewPager;//下方的可横向拖动的控件
    ArrayList<Fragment> mViews;//用来存放下方滚动的layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initVariable();
        yi.setChecked(true);
        mViewPager.setCurrentItem(1);
        mCurrentCheckedRadioLeft=getCurrentCheckedRadioLeft();
    }

    //获得当前被选中的RadioButton距离左侧的距离
    private float getCurrentCheckedRadioLeft() {
        if (yi.isChecked()){
            return getResources().getDimension(R.dimen.yi);
        }else if (er.isChecked()){
            return getResources().getDimension(R.dimen.er);
        }
        return 0f;
    }

    private void initVariable() {
        mViews=new ArrayList<Fragment>();
        mViews.add(new NullActivity());
        mViews.add(new IndexActivity());
        mViews.add(new BannerActivity());
        mViews.add(new NullActivity());

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mViews));//设置ViewPager的适配器
    }

    private void initListener() {
        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.setOnPageChangeListener(new MyPagerOnPageChangeListener());
    }

    //控件初始化
    private void initView() {
        mRadioGroup= (RadioGroup) this.findViewById(R.id.radioGroup);
        yi= (RadioButton) this.findViewById(R.id.yi);
        er= (RadioButton) this.findViewById(R.id.er);
        mHorizontalScrollView= (HorizontalScrollView) this.findViewById(R.id.horizontalScrollView);
        mViewPager= (ViewPager) this.findViewById(R.id.viewPager);
    }

    //双击退出程序
    private long ExitTime=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){
            if (System.currentTimeMillis()-ExitTime > 2000){
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                ExitTime=System.currentTimeMillis();
            }else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //RadioGroup点击CheckedChanged监听
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        AnimationSet mAnimationSet=new AnimationSet(true);
        TranslateAnimation mTranslateAnimation;
        if (i == R.id.yi){
            mTranslateAnimation=new TranslateAnimation(mCurrentCheckedRadioLeft,R.dimen.yi,0f,0f);
            mAnimationSet.addAnimation(mTranslateAnimation);
            mAnimationSet.setFillBefore(false);
            mAnimationSet.setFillAfter(true);
            mAnimationSet.setDuration(100);
            mViewPager.setCurrentItem(1);
        }else if (i == R.id.er){
            mTranslateAnimation=new TranslateAnimation(mCurrentCheckedRadioLeft,R.dimen.er,0f,0f);
            mAnimationSet.addAnimation(mTranslateAnimation);
            mAnimationSet.setFillBefore(false);
            mAnimationSet.setFillAfter(true);
            mAnimationSet.setDuration(100);
            mViewPager.setCurrentItem(2);
        }
        mCurrentCheckedRadioLeft=getCurrentCheckedRadioLeft();
        mHorizontalScrollView.smoothScrollTo((int)mCurrentCheckedRadioLeft - (int)getResources().getDimension(R.dimen.er),0);
    }

    //ViewPager的PageChangeListener(页面改变的监听器)
    private class MyPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //滑动ViewPager的时候,让上方的HorizontalScrollView自动切换
        @Override
        public void onPageSelected(int position) {
            if (position == 0){
                mViewPager.setCurrentItem(1);
            }else if (position == 1){
                yi.performClick();
            }else if (position == 2){
                er.performClick();
            }else if (position == 3){
                mViewPager.setCurrentItem(2);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    //ViewPager的适配器
    private class MyPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> listActivity;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> listActivity) {
            super(fm);
            this.listActivity = listActivity;
        }

        @Override
        public Fragment getItem(int position) {
            return listActivity.get(position);
        }

        @Override
        public int getCount() {
            return listActivity.size();
        }
    }
}
