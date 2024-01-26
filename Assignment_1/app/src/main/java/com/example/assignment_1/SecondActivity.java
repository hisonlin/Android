package com.example.assignment_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final EditText nameInput = findViewById(R.id.nameInputBox);
        Button showToastButton = findViewById(R.id.submit_btn);
        final TextView message = findViewById(R.id.messageTextView);

        showToastButton.setOnClickListener(v -> {
            String userName = nameInput.getText().toString().trim();

            if (!userName.isEmpty()){
                message.setText("");
                Toast.makeText(SecondActivity.this, "Hi, " + userName, Toast.LENGTH_SHORT).show();
            }else{
                message.setText(R.string.error_msg);
            }
        });

    }
}
