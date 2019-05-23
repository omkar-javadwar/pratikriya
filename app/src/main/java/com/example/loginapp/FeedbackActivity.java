package com.example.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
	private FirebaseDatabase db;
	private DatabaseReference myRef;
	
	private Button btn;
	private EditText suggest;
	private Spinner dept, sub, staff, rating;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayShowHomeEnabled(true);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}

        mAuth = FirebaseAuth.getInstance();
		db = FirebaseDatabase.getInstance();
		
		btn = findViewById(R.id.ButtonSendFeedback);
		suggest = findViewById(R.id.EditTextFeedbackBody);
		dept = findViewById(R.id.spinnerDepartments);
		sub = findViewById(R.id.spinnerSubjects);
		staff = findViewById(R.id.spinnerTeachers);
		rating = findViewById(R.id.spinnerFeed);

		Intent intent = getIntent();
		final String uid = intent.getStringExtra("phonenumber");
		
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final String feedbackDepartment = dept.getSelectedItem().toString();
				final String feedbackSubject = sub.getSelectedItem().toString();
				final String feedbackStaff = staff.getSelectedItem().toString();
				final String feedbackRating = rating.getSelectedItem().toString();
				final String feedbackSuggestion = suggest.getText().toString().trim();
				
				if (TextUtils.isEmpty(feedbackDepartment) || TextUtils.isEmpty(feedbackSubject) || TextUtils.isEmpty(feedbackStaff) || TextUtils.isEmpty(feedbackRating) || TextUtils.isEmpty(feedbackSuggestion)) {
					Toast toast = Toast.makeText(getApplicationContext(), "All Fields Required!", Toast.LENGTH_LONG);
					toast.show();
				} else {
					myRef = db.getReference();
					ManagerData dat = new ManagerData(feedbackDepartment, feedbackSubject, feedbackStaff, feedbackRating, feedbackSuggestion);
					myRef.child("Feedback Data").child(feedbackSubject).child(mAuth.getUid()).setValue(dat);
					
					Toast toast = Toast.makeText(getApplicationContext(), "Feedback Submitted Successfully", Toast.LENGTH_LONG);
					toast.show();

					Intent intent1 = new Intent(FeedbackActivity.this,DashboardActivity.class);
					startActivity(intent1);
				}
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
