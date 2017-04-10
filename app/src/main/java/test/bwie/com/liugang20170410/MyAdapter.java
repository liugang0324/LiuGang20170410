package test.bwie.com.liugang20170410;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.List;

/**
 * @ Description:ListView适配器类
 * @ Date:2017/4/10
 * @ Author:刘刚
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private List<GsonBean.NewslistBean>list;

    public MyAdapter(List<GsonBean.NewslistBean> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView==null){   //优化View视图
            convertView=View.inflate(mContext,R.layout.item,null);
            holder=new ViewHolder();  //根据ID找控件
            holder.image= (ImageView) convertView.findViewById(R.id.image);
            holder.text1= (TextView) convertView.findViewById(R.id.textView);
            holder.text2= (TextView) convertView.findViewById(R.id.textView2);
          convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text1.setText(list.get(position).getTitle()+"");
        holder.text2.setText(list.get(position).getDescription()+"");
        //ImageLoader.getInstance().displayImage(list.get(position).getPicUrl()+"",holder.image,ImageEmpty.imageOptions(R.mipmap.ic_launcher));
        x.image().loadDrawable(list.get(position).getPicUrl(), ImageEmpty.imageUtils(), new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {
                holder.image.setImageDrawable(result);
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
        return convertView;
    }

    class  ViewHolder{
        TextView text1;
        TextView text2;
        ImageView image;


    }
}
