package com.example.healthcare.myhealthcare;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.RowId;

public class profile extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private Button btn_logout,btn_addmem,btn_addrec,btn_view,btn_em,btn_sos;
    private TextView wel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();

//        if(firebaseAuth.getCurrentUser()!= null)
//        {
//            finish();
//            startActivity(new Intent(this, login.class));
//        }

        FirebaseUser user = firebaseAuth.getCurrentUser();


        btn_logout = (Button)findViewById(R.id.Logout_btn);
        btn_addmem = (Button)findViewById(R.id.btn_addmem);
        btn_addrec = (Button)findViewById(R.id.btn_addrec);
        btn_view = (Button)findViewById(R.id.not);
        btn_em = (Button)findViewById(R.id.btn_em);
        btn_sos = (Button)findViewById(R.id.btn_sos);


        wel = (TextView)findViewById(R.id.welcome);
        wel.setText("    Welcome  " +user.getEmail());
        btn_logout.setOnClickListener(this);
        btn_addmem.setOnClickListener(this);
        btn_addrec.setOnClickListener(this);
        btn_view.setOnClickListener(this);
        btn_em.setOnClickListener(this);
        btn_sos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_logout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,login.class));
        }
        if(v==btn_addmem)
        {
            finish();
            startActivity(new Intent(this,addMember.class));
        }
        if(v==btn_addrec)
        {
            finish();
            startActivity(new Intent(this,addrec.class));
        }
        if(v==btn_sos)
        {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+"9752369579"));
            startActivity(callIntent);
        }
        if(v==btn_em)
        {
            finish();
            startActivity(new Intent(this,sos.class));
        }
        if(v==btn_view)
        {
            finish();
            startActivity(new Intent(this,notification.class));
        }

    }
}
