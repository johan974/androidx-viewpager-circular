package nl.deholtmans.viewpagerdemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class PagerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.pager, container, false);
        final ViewPager pager=(ViewPager)result.findViewById(R.id.pager);
        pager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                UserFeedback.showShort("onPageSelected() :: " + "position: " + position);
                // skip fake page (first), go to last page
                if (position == 0) {
                    UserFeedback.showShort("onPageSelected() :: " + "position: 0 becomes the last 8 " + position);
                    ((ViewPager) pager).setCurrentItem(8, false);
                }
                // skip fake page (last), go to first page
                if (position == 9) { // not 10, because that's the max getCount()
                    UserFeedback.showShort("onPageSelected() :: " + "position: 9 becomes the first 1 " + position);
                    ((ViewPager) pager).setCurrentItem(1, false); //notice how this jumps to position 1, and not position 0. Position 0 is the fake page!
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        pager.setAdapter(buildAdapter());
        pager.setCurrentItem(1); // not 0 !!!
        return(result);
    }
    private PagerAdapter buildAdapter() {
        return(new SampleAdapter(getActivity(), getChildFragmentManager()));
    }
}
