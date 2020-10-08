package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.example.demo2.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final PagerAdapter adapter = new PagerAdapter(this.getSupportFragmentManager(),this.getLifecycle());
        binding.viewpager.setAdapter(adapter);
        final String[] tabTexts = {"发现", "推荐", "日报"};
        new TabLayoutMediator(binding.tabs, binding.viewpager,
                (tab, position) -> {
                    Log.e("tab", "--attach , pos=" + position + " , " + binding.viewpager.getCurrentItem());
                    tab.setText(tabTexts[position]);
                }
        ).attach();
    }


}