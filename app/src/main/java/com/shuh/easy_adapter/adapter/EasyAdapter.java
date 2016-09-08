package com.shuh.easy_adapter.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.shuh.easy_adapter.adapter.helper.ListHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc-135 on 2016/9/7.
 */
public abstract class EasyAdapter<T> extends BaseAdapter implements ListHelper<T>{

    protected ArrayList<T> list;
    protected Context context;
    protected EasyHolder holder = new EasyHolder();
    protected @LayoutRes int layoutId;


    public EasyAdapter(Context context, ArrayList<T> list, @LayoutRes int layoutId){
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
        if(list == null)
            list = new ArrayList<>();

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        holder = holder.get(context, view, viewGroup, layoutId);
        convert(holder, i, getItem(i));
        return holder.getConvertView();
    }

    public abstract void convert(EasyHolder holder, int position, T t);

    @Override
    public ArrayList<T> getList(){
        return list;
    }

    @Override
    public void add(T t){
        list.add(t);
    }

    @Override
    public void add(int i, T t){
        list.add(i, t);
    }

    @Override
    public boolean addAll(List<T> ts){
        if(list.addAll(ts)){
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    @Override
    public T remove(int i){
        return list.remove(i);
    }

    @Override
    public boolean remove(T t){
        return list.remove(t);
    }

    @Override
    public boolean removeAll(List<T> ts){
        if(list.removeAll(ts)){
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    @Override
    public boolean isListEmpty(){
       return list.isEmpty();
    }

    @Override
    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }


}
