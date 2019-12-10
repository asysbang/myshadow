package com.asysbang.myshadow;

import android.content.Context;
import android.content.Intent;

import com.asysbang.target.TargetActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProxyHelper {

    private ProxyHelper(){

    }

    public static ProxyHelper getInstance() {
     return Holder.sInt;
    }

    private static class Holder {
        private static ProxyHelper sInt = new ProxyHelper();
    }

    public void startActivity(Context context, Class<?> clazz) {
        Intent intent = new Intent(context, ProxyActivity.class);
        intent.putExtra("target",true);//目前bool代替 ，实际应该传入clazz
        context.startActivity(intent);
    }
}
