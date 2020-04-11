package com.example.exempleviewpagerlegacy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.exempleviewpagerlegacy.fragments.Fragment1;
import com.example.exempleviewpagerlegacy.fragments.Fragment2;
import com.example.exempleviewpagerlegacy.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        mainFragment = new MainFragment();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        ViewPager viewPager = findViewById(R.id.vpPager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(fragmentManager);
        viewPager.setAdapter(myPagerAdapter);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return mainFragment;
                case 1:
                    return fragment1;
                case 2:
                    return fragment2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            String title = "";

            switch (position) {
                case 0:
                    title = "Pourquoi";
                    break;
                case 1:
                    title = "Avantages";
                    break;
                case 2:
                    title = "le chat";
                    break;
            }
            return title;
        }
    }
}
