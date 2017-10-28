package com.levent_j.learndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * @auther : levent_j on 2017/10/25.
 * @desc :
 */

public class BaseActivity extends AppCompatActivity {
    public static final String TAG = "测试";
    public <T extends View> T $(int viewId) {
        return (T) findViewById(viewId);
    }
}
