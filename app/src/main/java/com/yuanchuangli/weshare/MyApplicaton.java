package com.yuanchuangli.weshare;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Blank on 2016/10/25 14:14
 */

public class MyApplicaton extends Application {
    public static final String APPID = "160c4bb8e1550f40878547e60e899175";

    @Override
    public void onCreate() {
        Bmob.initialize(this, APPID);
    }
}
