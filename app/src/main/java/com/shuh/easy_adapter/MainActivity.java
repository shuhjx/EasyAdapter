package com.shuh.easy_adapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.ListView;

import com.shuh.easy_adapter.adapter.EasyAdapter;
import com.shuh.easy_adapter.adapter.EasyHolder;
import com.shuh.easy_adapter.base.BaseActivity;
import com.shuh.easy_adapter.utils.ViewUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
//    private RecyclerView recyclerView;
    private ListView listView;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void findViews() {
        setContentView(R.layout.activity_main);
        tabLayout = ViewUtils.findViewById(this, R.id.tablelayout);
        toolbar = ViewUtils.findViewById(this, R.id.toolbar);
//        recyclerView = ViewUtils.findViewById(this, R.id.recyclerview);
        listView = ViewUtils.findViewById(this, R.id.listview);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        String[] titles = {"11", "22", "33"};
        tabLayout.setTabTextColors(Color.WHITE, Color.GRAY);
        tabLayout.addTab(tabLayout.newTab(), true);
        tabLayout.addTab(tabLayout.newTab(), false);
        tabLayout.addTab(tabLayout.newTab(), false);

        for(int i=0;i<30;i++)
            list.add(""+i);

        listView.setAdapter(new EasyAdapter<String>(this, list, android.R.layout.simple_list_item_1) {
            @Override
            public void convert(EasyHolder holder, int position, String s) {
                holder.setText(android.R.id.text1, s);
            }
        });

    }


}
