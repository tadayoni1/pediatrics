package net.tirgan.pediatrics.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import net.tirgan.pediatrics.R;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private HeadCircumferenceFragment mHeadCircumferenceFragment;
    private HeightAndWeightFragment mHeightAndWeightFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_head_circumference:
                    mFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, mHeadCircumferenceFragment)
                            .commit();
                    return true;
                case R.id.navigation_wnh:
                    mFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, mHeightAndWeightFragment)
                            .commit();
                    return true;
                case R.id.navigation_bp:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        mHeadCircumferenceFragment = new HeadCircumferenceFragment();
        mHeightAndWeightFragment = new HeightAndWeightFragment();

        mFragmentManager.beginTransaction()
                .add(R.id.fragment_container, mHeadCircumferenceFragment)
                .commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
