package com.shuh.easy_adapter.model;

import com.google.auto.value.AutoValue;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
@AutoValue
public abstract class User {
    public abstract int id();
    public abstract String name();

//    public static User create(int id, String name){
//        return new AutoValue_User(id,name);
//    }
}
