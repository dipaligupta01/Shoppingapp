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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText editPassword, editConfirm, editEmail;
    Button buttonSubmit;
    FirebaseAuth auth;
    String email;
    String password;
    String confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Personal Store");


        editPassword = findViewById(R.id.edit_text_password);
        editConfirm = findViewById(R.id.edit_text_password_confirm);
        editEmail = findViewById(R.id.edit_text_email);
        auth = FirebaseAuth.getInstance();


        buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();


            }
        });

    }


    public boolean validate() {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Enter your E-mail", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(confirm)) {
            Toast.makeText(this, "Enter your confirm Password", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (confirm.equals(password)) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void register() {
        email = editEmail.getText().toString();
        password = editPassword.getText().toString();
        confirm = editConfirm.getText().toString();
       // if (validate()) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(RegisterActivity.this, "Oops !! Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
       // } else {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        //}

    }
}