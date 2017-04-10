package test.bwie.com.liugang20170410;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @ Description:ViewPager适配器类
 * @ Date:2017/4/10
 * @ Author:刘刚
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private List<UserFragment>flist;
    private List<String>slist;

    public MyFragmentAdapter(FragmentManager fm, List<UserFragment> flist, List<String> slist) {
        super(fm);
        this.flist = flist;
        this.slist = slist;
    }

    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position%slist.size());
    }
}
