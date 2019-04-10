package com.example.assignment2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

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

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_rock_grey);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_classic_grey);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_pop_grey);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
