package com.asysbang.myshadow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class BaseFakeActivity  extends AppCompatActivity implements FakeActivity {


    private Activity mProxyActivity;

    @Override
    public void setProxyActivity(Activity proxyActivity) {
        mProxyActivity = proxyActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (mProxyActivity ==null) {
            super.onCreate(savedInstanceState);
        }
    }


    @Override
    public void setContentView(int layoutResID) {
        if (mProxyActivity ==null) {
            super.setContentView(layoutResID);
        }else {
            mProxyActivity.setContentView(layoutResID);
        }

    }

    @Override
    public void onStart() {
    super.onStart();
    }

    @Override
    public void onRestart() {
super.onRestart();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onResume() {
super.onResume();
    }

    @Override
    public void onPause() {
super.onPause();
    }

    @Override
    public void onStop() {
super.onStop();
    }

    @Override
    public void onDestroy() {
super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
super.onSaveInstanceState(outState);
    }

    @Override
    public void onNewIntent(Intent intent) {
super.onNewIntent(intent);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
super.onRestoreInstanceState(savedInstanceState);
    }
}
