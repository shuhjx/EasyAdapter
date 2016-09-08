package com.shuh.easy_adapter.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shuh.easy_adapter.adapter.helper.ViewHelper;

/**
 * Created by pc-135 on 2016/9/7.
 */
public class EasyHolder implements ViewHelper.AbsListView {

    protected SparseArray<View> views = new SparseArray<>();
    protected View convertView;
    protected Context context;

    public EasyHolder(){}

    public EasyHolder(Context context, View view, ViewGroup viewGroup, @LayoutRes int layoutId){
        convertView = view;
        this.context = context;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layoutId, viewGroup, false);
            convertView.setTag(this);
        }
    }

    public <E extends EasyHolder> E get(Context context, View view, ViewGroup viewGroup, @LayoutRes int layoutId){
        if(view == null){
            return (E) new EasyHolder(context, view, viewGroup, layoutId);
        }
        EasyHolder holder = (EasyHolder) view.getTag();

        return (E) holder;
    }

    public View getConvertView(){
        return convertView;
    }

    public <V extends View> V getView(@IdRes int id){
        View v = views.get(id);
        if(v == null){
            v = convertView.findViewById(id);
            views.put(id, v);
        }
        return (V) v;
    }

    @Override
    public EasyHolder setText(@IdRes int id, String value){
        ((TextView) getView(id)).setText(value);
        return this;
    }

    @Override
    public EasyHolder setText(@IdRes int id, @StringRes int value){
        ((TextView) getView(id)).setText(value);
        return this;
    }

    @Override
    public EasyHolder setTextColor(@IdRes int id, int color){
        ((TextView) getView(id)).setTextColor(color);
        return this;
    }

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    public EasyHolder setTextColorRes(@IdRes int id, @ColorRes int color){
        ((TextView) getView(id)).setTextColor(context.getResources().getColor(color, null));
        return this;
    }

    @Override
    public EasyHolder setOnClickListener(@IdRes int id, View.OnClickListener listener){
        getView(id).setOnClickListener(listener);
        return this;
    }

    @Override
    public EasyHolder setBackgroundColor(@IdRes int id, int color){
        getView(id).setBackgroundColor(color);
        return this;
    }

    @Override
    public EasyHolder setBackgroundResource(@IdRes int id, int color){
        getView(id).setBackgroundResource(color);
        return this;
    }

    @Override
    public EasyHolder setVisible(@IdRes int id, int visibility){
        getView(id).setVisibility(visibility);
        return this;
    }

    @Override
    public EasyHolder setTag(@IdRes int id, Object tag){
        getView(id).setTag(tag);
        return this;
    }

    @Override
    public EasyHolder setTag(@IdRes int id, int key, Object tag) {
        getView(id).setTag(key, tag);
        return this;
    }


}
