package com.example.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AdminDisplay extends AppCompatActivity {

    ListView list;
    ArrayList<String> lv_arr = new ArrayList<String>();
    ArrayAdapter adapter;
    FirebaseDatabase database;
    myFeed FeedbackData;
    Map<String, Object> myDeptData = new HashMap<String, Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_display);

        list = (ListView) findViewById(R.id.list_display);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lv_arr.clear();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lv_arr);
        list.setAdapter(adapter);
        database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Feedback Data");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = children.iterator();
                while (iterator.hasNext()) {
                    lv_arr.add(iterator.next().getKey());

                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getApplicationContext(), GetFeedbackActivity.class);
                intent.putExtra("Feedback Data", lv_arr.get(position).toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

class myFeed {
    String Name;

    public myFeed() {

    }

    public myFeed(String n) {
        this.Name = n;
    }

    public String getName() {
        return Name;
    }

    public void setValue(String name) {
        Name = name;
    }
}