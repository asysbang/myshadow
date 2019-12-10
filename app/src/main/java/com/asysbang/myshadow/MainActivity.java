package com.asysbang.myshadow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.asysbang.target.TargetActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNoProxy(View v) {
        Intent intent = new Intent(this, ProxyActivity.class);
        startActivity(intent);
    }

    public void startWithProxy(View v) {
        ProxyHelper.getInstance().startActivity(this, TargetActivity.class);
    }
}
