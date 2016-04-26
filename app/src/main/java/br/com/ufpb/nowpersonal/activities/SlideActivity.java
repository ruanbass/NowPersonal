package br.com.ufpb.nowpersonal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;

import br.com.ufpb.nowpersonal.R;
import br.com.ufpb.nowpersonal.fragments.Slide01;
import br.com.ufpb.nowpersonal.fragments.Slide02;
import br.com.ufpb.nowpersonal.fragments.Slide03;

public class SlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        CirclePageIndicator pageIndicator = (CirclePageIndicator) findViewById(R.id.pageIndicator);

        // ViewPager Logic
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, new FadePageTransformer());
        // PageIndicator Logic
        pageIndicator.setViewPager(viewPager);
        pageIndicator.setCurrentItem(viewPager.getCurrentItem());

        View mLoginButton = findViewById(R.id.enter);
        mLoginButton.setOnClickListener(new ButtonClickListener(0));
        View mRegisterButton = findViewById(R.id.register);
        mRegisterButton.setOnClickListener(new ButtonClickListener(1));
    }

    private class ButtonClickListener implements View.OnClickListener{

        private int button;

        public ButtonClickListener(int button) {
            this.button = button;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(SlideActivity.this, LoginRegisterActivity.class);
            intent.putExtra("button", button);
            startActivity(intent);
            finish();
        }
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] titles = {"Slide One", "Slide Two", "Slide Three"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            if(position == 0){
                fragment = new Slide01();
            }else if(position == 1){
                fragment = new Slide02();
            }else if(position == 2){
                fragment = new Slide03();
            }

            Bundle bundle = new Bundle();
            bundle.putInt("idx", position);

            if (fragment != null) {
                fragment.setArguments(bundle);
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }

    private class FadePageTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            view.setTranslationX(view.getWidth() * -position);

            if(position <= -1.0F || position >= 1.0F) {
                view.setAlpha(0.0F);
            } else if( position == 0.0F ) {
                view.setAlpha(1.0F);
            } else {
                // position is between -1.0F & 0.0F OR 0.0F & 1.0F
                view.setAlpha(1.0F - Math.abs(position));
            }
        }
    }
}
