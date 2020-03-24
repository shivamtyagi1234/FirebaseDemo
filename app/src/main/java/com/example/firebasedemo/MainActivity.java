package com.example.firebasedemo;

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

public class MainActivity extends AppCompatActivity {
    EditText name,email,pass,confirm_pass,phone;
    Button reg_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        confirm_pass=findViewById(R.id.confirm_pass);
        phone=findViewById(R.id.phone);
        reg_btn=findViewById(R.id.register_btn);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email=email.getText().toString();
                String user_pass=pass.getText().toString();
                Toast.makeText(MainActivity.this, "Login Initiated !", Toast.LENGTH_SHORT).show();
                mAuth.createUserWithEmailAndPassword(user_email, user_pass)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Intent intent=new Intent(MainActivity.this,MyActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Error in login", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

    }
}
