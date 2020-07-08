package com.example.juvenalsalas.comunicadorplantas;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager viewpager;
    private AdapterPager adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabs = findViewById(R.id.tabs);
        viewpager = findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);
        setTitle("ComunicadorPlantas");
        getSupportActionBar().setSubtitle("Lirios para todos");


        adapter = new AdapterPager(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);

        tabs.getTabAt(0).setIcon(R.drawable.ic_1);
        tabs.getTabAt(1).setIcon(R.drawable.ic_3);
        tabs.getTabAt(2).setIcon(R.drawable.ic_2);

    }



    public class AdapterPager extends FragmentPagerAdapter{



        public AdapterPager(FragmentManager fm){
            super(fm);
        }

        @Override
        public int getCount(){
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch(position){
                case 0:
                    return "Planta";
                case 1:
                    return "Temp";
                case 2:
                    return "Humedad";
            }

            return null;
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    Tab1 t1 = new Tab1();

                    return t1;
                case 1:
                    Tab3 t3 = new Tab3();

                    return t3;
                case 2:
                    Tab2 t2 = new Tab2();

                    return t2;
            }
            return null;
        }
    }

}
