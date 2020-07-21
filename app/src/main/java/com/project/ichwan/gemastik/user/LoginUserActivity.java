package com.project.ichwan.gemastik.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.project.ichwan.gemastik.R;

public class LoginUserActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailLogin, pwLogin;
    CardView cvLogin, cvRegist;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        emailLogin = findViewById(R.id.emaillogin);
        pwLogin = findViewById(R.id.pwlogin);

        firebaseAuth = FirebaseAuth.getInstance();
        cvLogin = findViewById(R.id.cvlogin);
        cvRegist = findViewById(R.id.cvregistlogin);

        cvLogin.setOnClickListener(this);
        cvRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cvlogin:
                firebaseAuth.signInWithEmailAndPassword(emailLogin.getText().toString(), pwLogin.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent intents = new Intent(LoginUserActivity.this,UserActivity.class);
                                    startActivity(intents);
                                } else {
                                    Toast.makeText(LoginUserActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;
            case R.id.cvregistlogin:
                Intent intent = new Intent(LoginUserActivity.this,RegistUserActivity.class);
                startActivity(intent);
                break;
        }
    }
}
