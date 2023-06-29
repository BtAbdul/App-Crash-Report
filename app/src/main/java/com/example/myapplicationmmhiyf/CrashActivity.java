package com.btabdul.crash;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class CrashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_crash);

        // Retrieve the crash details from the intent
        String crashDetails = getIntent().getStringExtra("crashDetails");

        // Display the crash details in a TextView or any other UI component
        TextView crashTextView = findViewById(R.id.crashTextView);
        crashTextView.setText(crashDetails);
    }
}
