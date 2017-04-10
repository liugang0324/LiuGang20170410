package test.bwie.com.liugang20170410;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @ Description:业务操作类
 * @ Date:2017/4/10
 * @ Author:刘刚
 */

public class UserFragment extends Fragment {

    private View mView;
    private ListView mLv;
//自定义静态方法添加Fragment
    public  static UserFragment getFragment(String uri){
        UserFragment userFragment = new UserFragment();
        Bundle bundle = new Bundle();
        bundle.putString("uri",uri);    //利用Bundle传值
        userFragment.setArguments(bundle);
        return  userFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.lv, null);
        initView();  //初始化视图
        return mView;
    }

    private void initView() {
        mLv = (ListView) mView.findViewById(R.id.lv);//根据ID找控件

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        String uri = bundle.getString("uri");

       /* MyAsyncTask myAsyncTask = new MyAsyncTask(mLv, getActivity()); //异步加载网络数据
        myAsyncTask.execute(uri);*/
        MyXUtil myXUtil = new MyXUtil(getActivity(), mLv);
        myXUtil.getXutil(uri);
    }
}
