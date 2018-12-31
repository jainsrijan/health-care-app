package com.example.healthcare.myhealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addMember extends AppCompatActivity {

    private TextView fname,frelation,fage,fgender,fblood,fnum,fpre;
    private Button faddmembers;
    DatabaseReference databaseaddmemclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        databaseaddmemclass =FirebaseDatabase.getInstance().getReference("member" );

        fname =(TextView)findViewById(R.id.name) ;
        frelation=(TextView)findViewById(R.id.relation) ;
        fage=(TextView)findViewById(R.id.age) ;
        fgender=(TextView)findViewById(R.id.gender) ;

        fblood=(TextView)findViewById(R.id.blood) ;
        fnum=(TextView)findViewById(R.id.num) ;
        fpre=(TextView)findViewById(R.id.pre);
        faddmembers=(Button)findViewById(R.id.submit);


        faddmembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMember();
                finish();
                startActivity(new Intent(addMember.this, profile.class));
            }
        });
    }

    private void addMember(){
        String name =fname.getText().toString().trim();
        String relation =frelation.getText().toString().trim();
        String age =fage.getText().toString().trim();
        String gender =fgender.getText().toString().trim();
        String blood =fblood.getText().toString().trim();
        String number =fnum.getText().toString().trim();
        String pres =fpre.getText().toString().trim();

        String id=databaseaddmemclass.push().getKey();

        addmemclass addd = new addmemclass(id,name,relation,age,gender,blood,number,pres);

        databaseaddmemclass.child(id).setValue(addd);

        Toast.makeText(this,"Member added",Toast.LENGTH_SHORT).show();

    }
}
