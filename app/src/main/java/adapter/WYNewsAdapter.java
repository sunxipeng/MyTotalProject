package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/1/11.
 */
public class WYNewsAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    private String[] CONTENT;

    public WYNewsAdapter(FragmentManager fm,List list,String[] count) {

        super(fm);

        this.fragments = list;

        this.CONTENT = count;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return CONTENT[position % CONTENT.length].toUpperCase();
    }

    @Override
    public int getCount() {

        return CONTENT.length;
    }
}
