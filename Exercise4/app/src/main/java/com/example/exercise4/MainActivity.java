package com.example.exercise4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] courses = {"CSTP 2204", "CSTP 2205", "CSTP 2208", "CSTP 2301", "CSTP 2305"};
        CourseAdapter adapter = new CourseAdapter(this, courses);
        recyclerView.setAdapter(adapter); // Set the adapter on the RecyclerView
    }
}

class CourseViewHolder extends RecyclerView.ViewHolder{
    public TextView courseName;

    public CourseViewHolder(View itemView){
        super(itemView);
        courseName = itemView.findViewById(R.id.course);
    }
}

class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {
    private final String[] courseList;
    private final Context context;
    public CourseAdapter(Context context, String[] courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.course, parent, false); // Ensure this layout is correct
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.courseName.setText(courseList[position]);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CourseDetailActivity.class);
            intent.putExtra("courseName", courseList[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return courseList.length; // Ensure the correct item count is returned
    }
}