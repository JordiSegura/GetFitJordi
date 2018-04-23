package vidal.sergi.getfit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import vidal.sergi.getfit.Tabs_ViewPager.Tab1;
import vidal.sergi.getfit.Tabs_ViewPager.Tab2;
import vidal.sergi.getfit.Tabs_ViewPager.Tab3;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNofTabs;
    public  PagerAdapter (FragmentManager fm,int NumberOfTabs){
        super(fm);
        this.mNofTabs = NumberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();return tab2;
            case 2:
                Tab3 tab3 = new Tab3();return tab3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNofTabs;
    }
}
