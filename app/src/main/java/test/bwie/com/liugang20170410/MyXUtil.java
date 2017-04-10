package test.bwie.com.liugang20170410;

import android.content.Context;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * @ Description:
 * @ Date:2017/4/10
 * @ Author:刘刚
 */

public class MyXUtil {

    private ListView mLv;
    private Context mContext;

    public MyXUtil(Context context, ListView lv) {
        mContext = context;
        mLv = lv;
    }

    public  void getXutil(String uri){
        RequestParams params = new RequestParams(uri);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result
                if (result!=null){             //Gson解析网络数据
                    Gson gson = new Gson();
                    GsonBean gsonBean = gson.fromJson(result, GsonBean.class);
                    if (gsonBean!=null){
                        List<GsonBean.NewslistBean> list = gsonBean.getNewslist();
                        if (list.size()!=0){
                            mLv.setAdapter(new MyAdapter(list,mContext));
                        }
                    }
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }
}
