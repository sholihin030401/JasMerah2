package com.project.ichwan.gemastik.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.project.ichwan.gemastik.R;
import com.project.ichwan.gemastik.user.fragment.ChatFragment;
import com.project.ichwan.gemastik.user.fragment.MenuFragment;
import com.project.ichwan.gemastik.user.fragment.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

public class UserActivity extends AppCompatActivity {

    SpaceTabLayout spaceTabLayout;
    private long BackPressed;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ViewPager viewPager = findViewById(R.id.viewpager);
        final CoordinatorLayout coordinatorLayout = findViewById(R.id.activityuser);
        spaceTabLayout = findViewById(R.id.spacetab);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MenuFragment());
        fragmentList.add(new ChatFragment());
        fragmentList.add(new ProfileFragment());
        spaceTabLayout.initialize(viewPager,getSupportFragmentManager(),fragmentList,savedInstanceState);
        spaceTabLayout.setTabOneOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout," ", Snackbar.LENGTH_SHORT);
            }
        });
        spaceTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Welcome in"+spaceTabLayout.getCurrentPosition(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (BackPressed + 3000 > System.currentTimeMillis()){
            toast.cancel();
            super.onBackPressed();
            return;
        } else {
            toast = Toast.makeText(UserActivity.this,"Tekan sekali lagi untuk keluar",Toast.LENGTH_SHORT);
            toast.show();
        }
        BackPressed = System.currentTimeMillis();
    }
}
