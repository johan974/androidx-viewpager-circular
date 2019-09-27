package nl.deholtmans.viewpagerdemo;


import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


//public class SampleAdapter extends FragmentPagerAdapter {
public class SampleAdapter extends FragmentStatePagerAdapter {
    Context ctxt = null;
    public SampleAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
        this.ctxt = ctxt;
    }
    @Override
    public int getCount() {
        return (10);
    }
    @Override
    public Fragment getItem(int position) {
        return (EditorFragment.newInstance(position));
    }
    @Override
    public String getPageTitle(int position) {
        return (EditorFragment.getTitle(ctxt, position));
    }
}