package com.shuh.easy_adapter.adapter.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc-135 on 2016/9/7.
 */
public interface ListHelper<T> {

    ArrayList<T> getList();

    void add(T t);

    void add(int i, T t);

    boolean addAll(List<T> ts);

    T remove(int i);

    boolean remove(T t);

    boolean removeAll(List<T> ts);

    boolean isListEmpty();

    void clear();
}
