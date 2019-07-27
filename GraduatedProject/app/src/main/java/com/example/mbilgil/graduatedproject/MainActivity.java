package com.example.mbilgil.graduatedproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     private Button gormeBtn;
     private Button gonulluBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        gormeBtn = (Button) findViewById(R.id.gormeBtn);
        gonulluBtn = (Button)  findViewById(R.id.gonulluBtn);
        gormeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEngelActivity();
            }
        });

        gonulluBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGonulluActivity();
            }
        });
    }


    public void openEngelActivity(){

        Intent intent =  new Intent(this,gEngelActivity.class);
        startActivity(intent);



    }


    public void openGonulluActivity(){

        Intent intent = new Intent(this,GonulluActivity.class);
        startActivity(intent);
    }

}
