package com.example.exercise4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CourseDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        // Get the TextView where you want to display the course detail
        TextView courseID = findViewById(R.id.courseID);
        TextView detail = findViewById(R.id.detail);
        ImageView homeBtn = findViewById(R.id.homeBtn);

        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CourseDetailActivity.this, MainActivity.class);
            startActivity(intent);

        });

        // Retrieve the course name passed from MainActivity
        String courseName = getIntent().getStringExtra("courseName");

        // Set the course name on the TextView to display it
        courseID.setText(courseName);

        switch (Objects.requireNonNull(courseName)) {
            case "CSTP 2204":
                detail.setText(R.string.project);
                break;
            case "CSTP 2205":
                detail.setText(R.string.android);
                break;
            case "CSTP 2208":
                detail.setText(R.string.career);
                break;
            case "CSTP 2301":
                detail.setText(R.string.emerging);
                break;
            case "CSTP 2305":
                detail.setText(R.string.ios);
                break;
            default:
                detail.setText(R.string.notFound);
                break;
        }

    }

}
