package com.asysbang.target;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.asysbang.myshadow.BaseFakeActivity;
import com.asysbang.myshadow.R;

public class TargetActivity extends BaseFakeActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
    }


}
