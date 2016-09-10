package tech.shutu.fuckgoods.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import tech.shutu.fuckgoods.view.fragment.RecyclerViewFragment;
import tech.shutu.fuckgoods.view.fragment.ScrollFragment;
import tech.shutu.fuckgoods.view.fragment.WebViewFragment;

/**
 * Created by raomengyang on 8/12/16.
 */
public class RVFragmentPagerAdapter extends FragmentStatePagerAdapter {

    public static final String[] CATEGORIES = {"Android", "iOS", "休息视频", "福利", "拓展资源", "前端", "瞎推荐", "App"};

    public enum Categories {
        ANDROID, IOS, VIDEOS, WELFARE, RESOURCE, WEB, RECOMMEND, APP
    }

    public RVFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        int pageIndex = position % 4;
        switch (pageIndex) {
            case 0:
                return RecyclerViewFragment.newInstance();
            case 1:
                return ScrollFragment.newInstance();
            case 2:
                return WebViewFragment.newInstance();
            default:
                return RecyclerViewFragment.newInstance();
        }
    }



    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int pageIndex = position % 4;
        if (pageIndex < 0 || pageIndex >= CATEGORIES.length) return "";
        else return CATEGORIES[pageIndex];
    }
}
