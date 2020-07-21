package com.project.ichwan.gemastik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.ichwan.gemastik.admin.LoginAdminActivity;
import com.project.ichwan.gemastik.user.LoginUserActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cvuser = findViewById(R.id.cvuser);
        CardView cvadmin = findViewById(R.id.cvadmin);

        cvuser.setOnClickListener(this);
        cvadmin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cvuser:
                Intent user = new Intent(this, LoginUserActivity.class);
                startActivity(user);
                break;
            case R.id.cvadmin:
                Intent admin = new Intent(this, LoginAdminActivity.class);
                startActivity(admin);
                break;
        }
    }
}
