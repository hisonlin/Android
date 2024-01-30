package com.example.exercise4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        // Get the TextView where you want to display the course detail
        TextView courseID = findViewById(R.id.courseID);
        TextView detail = findViewById(R.id.detail);

        // Retrieve the course name passed from MainActivity
        String courseName = getIntent().getStringExtra("courseName");

        // Set the course name on the TextView to display it
        courseID.setText(courseName);

        switch (courseName) {
            case "CSTP 2204":
                detail.setText("IT Development Project");
                break;
            case "CSTP 2205":
                detail.setText("Android Mobile App Programming");
                break;
            case "CSTP 2208":
                detail.setText("Career Path Search");
                break;
            case "CSTP 2301":
                detail.setText("Emerging Technologies");
                break;
            case "CSTP 2305":
                detail.setText("IOS Mobile App Programming");
                break;
            default:
                detail.setText("Course not found");
                break;
        }

    }

}
