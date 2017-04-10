package test.bwie.com.liugang20170410;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
/**
 * @ Description:业务操作类
 * @ Date:2017/4/10
 * @ Author:刘刚
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private List<String>slist=new ArrayList<String>();
    private List<UserFragment>flist=new ArrayList<UserFragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();  //初始化视图
        initData();//初始化数据
    }

    private void initData() {
      initFlist(); //初始化Fragment集合
      initSlist(); //初始化标题集合
        mVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),flist,slist)); //为ViewPager设置适配器
        mTab.setupWithViewPager(mVp); //连接标题与ViewPager
        mTab.setTabTextColors(Color.GRAY,Color.RED);
        mTab.setSelectedTabIndicatorColor(Color.RED);
    }

    private void initSlist() {
        slist.add("头条");  //初始化标题集合数据
        slist.add("社会");
        slist.add("国内");
        slist.add("国际");
        slist.add("娱乐");
        slist.add("体育");
        slist.add("军事");
        slist.add("科技");
        slist.add("财经");
        slist.add("段子");
    }

    private void initFlist() {  //为Fragment集合添加数据
         mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        flist.add(UserFragment.getFragment(UrL.path1));
        flist.add(UserFragment.getFragment(UrL.path2));
        flist.add(UserFragment.getFragment(UrL.path3));
        flist.add(UserFragment.getFragment(UrL.path4));
        flist.add(UserFragment.getFragment(UrL.path5));
        flist.add(UserFragment.getFragment(UrL.path6));
        flist.add(UserFragment.getFragment(UrL.path7));
        flist.add(UserFragment.getFragment(UrL.path8));
        flist.add(UserFragment.getFragment(UrL.path9));
        flist.add(UserFragment.getFragment(UrL.path10));
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);  //根据ID找控件
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
