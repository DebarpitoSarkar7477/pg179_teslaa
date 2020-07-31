package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class welcomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private int[] layouts={R.layout.slide_1,R.layout.slide_2,R.layout.slide_3};
    private Mypageadapter mypageadapter;
    private LinearLayout Dots_layout;
    private ImageView [] dots;
    private Button btnskp,btnnxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        if(new PreferenceManager(this).checkPreference())
        {
            Intent intent=new Intent(welcomeActivity.this,MainActivity2.class);
            startActivity(intent);
            finish();

        }
        viewPager=(ViewPager)findViewById(R.id.pager);
        mypageadapter=new Mypageadapter(layouts,this);
        viewPager.setAdapter(mypageadapter);
        Dots_layout=(LinearLayout)findViewById(R.id.dotlayout);
        btnskp=findViewById(R.id.skp);
        btnnxt=findViewById(R.id.nxt);
        btnskp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PreferenceManager(welcomeActivity.this).writePreference();
                Intent intent=new Intent(welcomeActivity.this,MainActivity2.class);
                startActivity(intent);
                finish();

            }
        });
        btnnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int next_slide=viewPager.getCurrentItem()+1;
                if(next_slide<layouts.length)
                {
                    viewPager.setCurrentItem(next_slide);
                }
                else
                {
                    new PreferenceManager(welcomeActivity.this).writePreference();
                    Intent intent=new Intent(welcomeActivity.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        createDots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
                if(position==layouts.length-1)
                {
                    btnnxt.setText("Start");
                    btnskp.setVisibility(View.INVISIBLE);
                }
                else
                {
                    btnnxt.setText("Next");
                    btnskp.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void createDots(int current_position)
    {
        if(Dots_layout!=null)
        {
            Dots_layout.removeAllViews();
        }
        dots=new ImageView[layouts.length];
        for(int i=0;i<layouts.length;i++)
        {
            dots[i]=new ImageView(this);
            if(i==current_position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
            params.setMargins(4,0,4,0);
            Dots_layout.addView(dots[i],params);
        }
    }
}
