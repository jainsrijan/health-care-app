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

public class sos
        extends AppCompatActivity implements View.OnClickListener {

    private Button btn_logout,btn_addmem,btn_addrec,btn_view,btn_em,btn_sos;
    private TextView wel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);



        btn_logout = (Button)findViewById(R.id.button);
        btn_addmem = (Button)findViewById(R.id.button2);
        btn_addrec = (Button)findViewById(R.id.button3);




        btn_logout.setOnClickListener(this);
        btn_addmem.setOnClickListener(this);
        btn_addrec.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btn_logout)
        {

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+"108"));
            startActivity(callIntent);
        }
        if(v==btn_addmem)
        {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+"100"));
            startActivity(callIntent);
        }
        if(v==btn_addrec)
        {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+"101"));
            startActivity(callIntent);
        }

    }
}
