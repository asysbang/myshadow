package com.asysbang.myshadow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.asysbang.target.TargetActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProxyActivity extends AppCompatActivity {

    private boolean mHaveTarget = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHaveTarget = getIntent().getBooleanExtra("target", false);
        if(mHaveTarget) {
            targetOnCreate();
        } else {
            setContentView(R.layout.activity_proxy);
        }

    }


    private void targetOnCreate() {
        try {

            Class<?> localClass = getClassLoader().loadClass("com.asysbang.target.TargetActivity");
            Constructor<?> localConstructor = localClass.getConstructor(new Class[] {});
            Object instance = localConstructor.newInstance(new Object[] {});
            FakeActivity fakeActivity = (FakeActivity) instance;
            fakeActivity.setProxyActivity(this);
//
//            mPluginActivity = (DLPlugin) instance;
//            ((DLAttachable) mProxyActivity).attach(mPluginActivity, mPluginManager);
//            // attach the proxy activity and plugin package to the mPluginActivity
//            mPluginActivity.attach(mProxyActivity, mPluginPackage);
//
//            public static final String FROM = "extra.from";
//            public static final int FROM_INTERNAL = 0;
//            public static final int FROM_EXTERNAL = 1;
            Bundle bundle = new Bundle();
            bundle.putInt("extra.from", 1);
            fakeActivity.onCreate(bundle);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
