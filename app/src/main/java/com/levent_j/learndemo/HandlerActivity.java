package com.levent_j.learndemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * @auther : levent_j on 2017/10/25.
 * @desc :
 */

public class HandlerActivity extends BaseActivity{

    private TextView test;
    private int num=10;
    private Handler handler = new MyHandler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            doSomething(message.what+"handler自带的handler");
            return true;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handelr);

        test = $(R.id.tv_test);

        $(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.setText("当前number"+num);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int cnt = 3;
                        while (cnt>0){
                            Log.d(TAG,"cnt " + cnt--);
                            try {
                                Thread.sleep(1000l);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        num--;
                        Message msg = new Message();
                        handler.sendMessage(msg);
                    }
                }).start();
            }
        });
    }

    public void doSomething(String s){
        test.setText(s);
    }

    class MyHandler extends Handler{

        public MyHandler(Callback callback) {
            super(callback);
        }

        @Override
        public void handleMessage(Message msg) {
            doSomething(msg.what+"handler的handlermessage方法");
        }
    }
}
