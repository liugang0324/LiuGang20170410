package test.bwie.com.liugang20170410;

import android.app.Application;

import org.xutils.x;

/**
 * @ Description:
 * @ Date:2017/4/10
 * @ Author:刘刚
 */

public class MyXutils extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

        x.Ext.setDebug(false);
    }
}
