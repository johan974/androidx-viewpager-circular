package nl.deholtmans.viewpagerdemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class PagerFragment extends Fragment {
    private static final int SET_ITEM_DELAY = 300;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.pager, container, false);
        final ViewPager pager= result.findViewById(R.id.pager);
        pager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected( final int position) {
                pager.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handleSetCurrentItem(position);
                    }
                }, SET_ITEM_DELAY);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
            private void handleSetCurrentItem(final int position) {
                final int lastPosition = pager.getAdapter().getCount() - 1;
                if (position == 0) {
                    pager.setCurrentItem(lastPosition - 1, false);
                } else if (position == lastPosition) {
                    pager.setCurrentItem(1, false);
                }
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
