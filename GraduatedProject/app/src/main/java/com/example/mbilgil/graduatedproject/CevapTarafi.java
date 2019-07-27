package com.example.mbilgil.graduatedproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class CevapTarafi extends AppCompatActivity {


    ArrayList<String> userImageFromFB;
    //ArrayList<String> userYardimFromFB;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    PostClass adapter;
    ListView listView;

    Button btnYardim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cevap_tarafi);

        //userEmailFromFB = new ArrayList<String>();
        //userYardimFromFB = new ArrayList<String>();
        userImageFromFB = new ArrayList<String>();

        btnYardim = (Button) findViewById(R.id.btnYardim);

        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef=firebaseDatabase.getReference();

        adapter = new PostClass(userImageFromFB, this);

        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);

        getDataFromFirebase();



    }

    protected void getDataFromFirebase(){

        DatabaseReference newReferance = firebaseDatabase.getReference("Yardım Talepleri");
        newReferance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot ds: dataSnapshot.getChildren()){

                    HashMap<String, String> hashMap = (HashMap<String, String>) ds.getValue();
                    userImageFromFB.add(hashMap.get("downloadurl"));
                    //userYardimFromFB.add(hashMap.get("userID"));
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
