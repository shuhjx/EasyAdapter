package com.shuh.easy_adapter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shuh.easy_adapter.R;
import com.shuh.easy_adapter.adapter.EasyAdapter;
import com.shuh.easy_adapter.adapter.EasyHolder;
import com.shuh.easy_adapter.base.BaseFragment;
import com.shuh.easy_adapter.utils.ViewUtils;

import java.util.ArrayList;

/**
 * Created by pc-135 on 2016/9/8.
 */
public class RxAndroidFragment extends BaseFragment {

    private ListView listView;
    private ArrayList<String> list = new ArrayList<>();
    @Override
    protected View findViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rxandroid_fragment, null);
        listView = ViewUtils.findViewById(view, R.id.listview);
        return view;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        for(int i=1;i<=30;i++)
            list.add(""+i);

        listView.setAdapter(new EasyAdapter<String>(getActivity(), list, android.R.layout.simple_list_item_1) {
            @Override
            public void convert(EasyHolder holder, int position, String s) {
                holder.setText(android.R.id.text1, s);
            }
        });
    }
}
