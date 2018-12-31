package com.example.healthcare.myhealthcare;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class list extends ArrayAdapter<addmemclass> {

    private Activity context;
    private List<addmemclass>memlist;

    public list(Activity context, List<addmemclass>memlist){
        super(context, R.layout.list_layout,memlist);
        this.context=context;
        this.memlist=memlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textView =(TextView)listItem.findViewById(R.id.mename);
        TextView textViewps =(TextView)listItem.findViewById(R.id.ps);
        addmemclass mem = memlist.get(position);
        textView.setText(mem.getMemname());
        textViewps.setText(mem.getMempres());
        return listItem;
    }
}
