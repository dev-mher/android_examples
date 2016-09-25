package example.com.movieplaylist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mher on 9/25/16.
 */
public class MyFragPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> pages = new ArrayList<>();

    public MyFragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    public void addPage(Fragment frag){
        pages.add(frag);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pages.get(position).toString();
    }
}
