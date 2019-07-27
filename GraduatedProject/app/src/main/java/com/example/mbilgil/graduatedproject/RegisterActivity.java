package com.example.mbilgil.graduatedproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText isimEdt;
    private EditText mailEdt;
    private EditText sifreEdt;
    private Button   registerBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        isimEdt=(EditText) findViewById(R.id.editText3);
        mailEdt = (EditText) findViewById(R.id.editText4);
        sifreEdt = (EditText) findViewById(R.id.editText5);

        registerBtn=(Button) findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = isimEdt.getText().toString();
                String mail = mailEdt.getText().toString();
                String sifre = sifreEdt.getText().toString();

                register_user(name,mail,sifre);

            }
        });
    }
    private void register_user(String name,String mail,String sifre) {
        mAuth.createUserWithEmailAndPassword(mail, sifre)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "Kayıt Başarılı", Toast.LENGTH_LONG).show();

                            Intent aIntent = new Intent(RegisterActivity.this, GonulluActivity.class);
                            startActivity(aIntent);
                            finish();

                        } else {
                            Toast.makeText(RegisterActivity.this, "Hata", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }
}
