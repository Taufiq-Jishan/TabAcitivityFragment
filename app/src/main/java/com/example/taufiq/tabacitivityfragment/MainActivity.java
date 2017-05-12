package com.example.taufiq.tabacitivityfragment;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private static final int Request = 99;
   /* private float x1, x2, y1, y2;
    private final Handler handler = new Handler(this);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

   /* @Override
    public boolean onTouchEvent(View v, MotionEvent event) {
        if (v.getId() == R.id.web1 && event.getAction() == MotionEvent.ACTION_DOWN){
            x1 = event.getX();
            y1 = event.getY();
            handler.sendEmptyMessageDelayed(100, 200);
        } else if (v.getId() == R.id.web1 && event.getAction() == MotionEvent.ACTION_UP){
            x2 = event.getX();
            y2 = event.getY();

            handler.sendEmptyMessageDelayed(100, 200);
        }
        return false;
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.what == 100){ //if you clic a link in the webview, thats not a scroll
            handler.removeMessages(100);
            handler.removeMessages(100);
            return true;
        }
        if (msg.what == 100){

            //Toast.makeText(this, "WebView clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (msg.what == 100){
            float deltaX = x2 - x1; //horizontal move distance
            float deltaY = y2 - y1; //vertical move distance
            if ((Math.abs(deltaX) > 150) && (Math.abs(deltaX) > Math.abs(deltaY)))
            {
                // Left to Right swipe action
                if (x2 > x1)
                {
                    //Toast.makeText(this, "Left to Right swipe [Next]", Toast.LENGTH_SHORT).show ();
                }

                // Right to left swipe action
                else
                {
                    //Toast.makeText(this, "Right to Left swipe [Previous]", Toast.LENGTH_SHORT).show ();
                }

            }
            else if ((Math.abs(deltaY) > 150) && (Math.abs(deltaY) > Math.abs(deltaX)))
            {
                // Top to Bottom swipe action -- i SWOW MY ACTIONBAR ON SCROLLDOWN
                if (y2 > y1)
                {
                    getActionBar().show();
                   // Toast.makeText(this, "Top to Bottom swipe [Show Bar]", Toast.LENGTH_SHORT).show ();
                }

                // Bottom to top swipe action -- I HIDE MY ACTIONBAR ON SCROLLUP
                else
                {
                    getActionBar().hide();
                   // Toast.makeText(this, "Bottom to Top swipe [Hide Bar]", Toast.LENGTH_SHORT).show ();
                }
            }
            return true;
        }
        return false;
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
                View rootView = inflater.inflate(R.layout.fragment_page_1, container, false);
                return rootView;
            }
           else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                View rootView = inflater.inflate(R.layout.fragment_page_2, container, false);
                return rootView;
            }
            else {
                View rootView = inflater.inflate(R.layout.fragment_page_3, container, false);
                return rootView;
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Google";
                case 1:
                    return "Apple";
                case 2:
                    return "CNN";
            }
            return null;
        }
    }
}
