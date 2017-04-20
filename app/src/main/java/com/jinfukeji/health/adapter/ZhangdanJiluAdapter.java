package com.jinfukeji.health.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jinfukeji.health.been.ZhangdanJiluBeen;

import java.util.ArrayList;

/**
 * Created by "于志渊"
 * 时间:"14:19"
 * 包名:com.jinfukeji.health.adapter
 * 描述:账单充值记录适配器
 */

public class ZhangdanJiluAdapter extends BaseAdapter{
    private ArrayList<ZhangdanJiluBeen.MessageBean> arrayList=new ArrayList<ZhangdanJiluBeen.MessageBean>();
    private Context context;

    public ZhangdanJiluAdapter(ArrayList<ZhangdanJiluBeen.MessageBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (arrayList != null){
            return arrayList.size();
        }
        return 0;
    }

    @Override
    public ZhangdanJiluBeen.MessageBean getItem(int i) {
        if (arrayList != null){
            return arrayList.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
