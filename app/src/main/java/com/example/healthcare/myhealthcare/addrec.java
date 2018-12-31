package com.example.healthcare.myhealthcare;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class addrec extends AppCompatActivity {

    ListView listView ;
    DatabaseReference databaseaddmemclass;
    List<addmemclass> memlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrec);
        databaseaddmemclass =FirebaseDatabase.getInstance().getReference("member" );
        listView =(ListView)findViewById(R.id.ls);
        memlist = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseaddmemclass.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                memlist.clear();
                for(DataSnapshot memsnapshot : dataSnapshot.getChildren()){
                    addmemclass addmemclass =memsnapshot.getValue(addmemclass.class);

                    memlist.add(addmemclass);
                }
                list adapter = new list(addrec.this,memlist);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
