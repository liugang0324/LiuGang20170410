package test.bwie.com.liugang20170410;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * @ Description:图片异步加载工具类
 * @ Date:2017/4/10
 * @ Author:刘刚
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate(); //自定义ImageLoader的初始化方法
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480, 800).build();
        ImageLoader.getInstance().init(configuration);
    }
}
