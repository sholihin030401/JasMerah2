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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.project.ichwan.gemastik.R;

public class RegistUserActivity extends AppCompatActivity {

    EditText username, email, pw, cpw;
    CardView btnSignin;

    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_user);

        username = findViewById(R.id.usernameregist);
        email = findViewById(R.id.emailregist);
        pw = findViewById(R.id.pwregist);
        cpw = findViewById(R.id.pwcregist);

        fAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);


        btnSignin = findViewById(R.id.cvsignin);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fAuth.createUserWithEmailAndPassword(email.getText().toString(),pw.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful() && pw == cpw && username != null){
                                    Toast.makeText(RegistUserActivity.this,"Registrasi Berhasil",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegistUserActivity.this, LoginUserActivity.class);
                                    startActivity(intent);
                                } else {
                                    if (pw != cpw){
                                        Toast.makeText(RegistUserActivity.this,"Password tidak sama!",Toast.LENGTH_SHORT).show();
                                    }
                                    if (username == null){
                                        Toast.makeText(RegistUserActivity.this,"Username tidak boleh kosong!",Toast.LENGTH_SHORT).show();
                                    }
                                    Toast.makeText(RegistUserActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
