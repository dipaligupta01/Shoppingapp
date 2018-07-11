package com.example.user.project_test2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editEmail, editPassword;
    TextView textNewuser;
    Button buttonLogin;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Personal Store");

        editEmail = findViewById(R.id.edit_text_email);
        editPassword = findViewById(R.id.edit_text_password);
        textNewuser = findViewById(R.id.text_view_new);
        buttonLogin = findViewById(R.id.button_login);

        auth=FirebaseAuth.getInstance();

        buttonLogin.setOnClickListener(this);

        textNewuser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_view_new:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;

            case R.id.button_login:
                login();

                break;

        }

    }
    private void login()
    {
        String email=editEmail.getText().toString();
        String password=editPassword.getText().toString();

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Enter your E-mail", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show();
            return;
        }


        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Successful!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomepageActivity.class));
                }else
                {
                    Toast.makeText(LoginActivity.this, "Oops !! Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
