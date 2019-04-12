package com.example.assignment2.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.assignment2.R;
import com.example.assignment2.model.SongPojo;

public class MainActivity extends AppCompatActivity{

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new RockFragment(),"Rock");
        adapter.addFragment(new ClassicFragment(),"Classic");
        adapter.addFragment(new PopFragment(), "Pop");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_rock_blue);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_classic_grey);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_pop_grey);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //todo change to selected icon
                switch(tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_rock_blue);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_classic_blue);
                        break;
                    case 2:
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_pop_blue);
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //todo change to unselected icon
                switch(tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_rock_grey);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_classic_grey);
                        break;
                    case 2:
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_pop_grey);
                        break;
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

}
