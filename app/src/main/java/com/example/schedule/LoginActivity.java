package com.example.schedule;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    Button back ;
    Button sing_in;
    FirebaseAuth auth;
    FirebaseUser user;
    EditText txtMail;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


       auth = FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        back= findViewById(R.id.btnBack);
        sing_in = findViewById(R.id.btnSignIn);
        txtMail= findViewById(R.id.txtMail);
        txtPassword = findViewById(R.id.txtPassword);


        //Back Button//
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

        //Sign in Button
        sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = txtMail.getText().toString();
                txtMail.setText("");
                String pass = txtPassword.getText().toString();
                txtPassword.setText("");
                if (!mail.equals("") && !pass.equals("")){
                    loginAdmin(mail, pass);
                }


            }
        });



    }

    //Switch Function
    private void backToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    //Auth Function
    private  void loginAdmin(String mail,String pass)
    {
        auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Intent intent   = new Intent(LoginActivity.this,AdminActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Admin login not correct",Toast.LENGTH_LONG).show();
                }

            }

        });

    }

}