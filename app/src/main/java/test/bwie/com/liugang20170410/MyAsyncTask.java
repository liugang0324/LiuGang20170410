package test.bwie.com.liugang20170410;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @ Description:业务操作类
 * @ Date:2017/4/10
 * @ Author:刘刚
 */

public class MyAsyncTask extends AsyncTask<String,Integer,List<GsonBean.NewslistBean>> {
    private ListView lv;
    private Context mContext;

    public MyAsyncTask(ListView lv, Context context) {
        this.lv = lv;
        mContext = context;
    }

    @Override
    protected void onPostExecute(List<GsonBean.NewslistBean> resultBeen) {
        super.onPostExecute(resultBeen);  //更新UI设置ListView适配器
        if (resultBeen != null) {
            lv.setAdapter(new MyAdapter(resultBeen, mContext));
        }
    }

    @Override
    protected List<GsonBean.NewslistBean> doInBackground(String... params) {
        String s = doGet(params[0]);
        if (s!=null){             //Gson解析网络数据
            Gson gson = new Gson();
            GsonBean gsonBean = gson.fromJson(s, GsonBean.class);
            if (gsonBean!=null){
                List<GsonBean.NewslistBean> result = gsonBean.getNewslist();
                if (result.size()!=0){
                    return result;
                }
            }
        }
        return null;
    }

    private String doGet(String uri){
        try {
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            if (con.getResponseCode()==200){
                InputStream ins = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(ins, "utf-8"));
                StringBuilder sb = new StringBuilder();
                String line="";
                while((line=br.readLine())!=null){
                    sb.append(line);
                }
                return sb.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
