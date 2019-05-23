package com.example.loginapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GetFeedbackActivity extends AppCompatActivity {

    ListView lv;
    DatabaseReference ref;
    String dept;
    ArrayList<String> data;
    Zero zero=new Zero();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_feedback);

        savedInstanceState=getIntent().getExtras();
        if(savedInstanceState!=null){dept=savedInstanceState.getString("data");}
        ref= FirebaseDatabase.getInstance().getReference("data").child(dept);

        lv=(ListView)findViewById(R.id.get_data);

        data = new ArrayList<String>();
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    getChild(snapshot.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void getChild(String i)
    {
        DatabaseReference mdata=FirebaseDatabase.getInstance().getReference("dept").child(dept).child(i);
        mdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                zero=dataSnapshot.getValue(Zero.class);
                data.add("Dept :"+zero.getDept()+"\nSubject: "+zero.getSub()+"\nTeacher: "+zero.getStaff()+"\nRating: "+zero.getRating()+"\nSuggestion: "+zero.getSuggest());
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
