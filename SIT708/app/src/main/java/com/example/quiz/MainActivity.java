package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private Button startQuizButton, calculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        usernameEditText = findViewById(R.id.userNameEditText);
        startQuizButton = findViewById(R.id.startQuizButton);
        calculatorButton = findViewById(R.id.calculatorButton);

        // Set OnClickListener for the "Start Quiz" button
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered username
                String username = usernameEditText.getText().toString().trim();

                if (!TextUtils.isEmpty(username)) {
                    // Save the username in SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("USERNAME", username);
                    editor.apply();

                    // Start the QuizQuestions activity
                    Intent intent = new Intent(MainActivity.this, QuizQuestions.class);
                    startActivity(intent);
                } else {
                    // Display a toast message if username is empty
                    Toast.makeText(MainActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set OnClickListener for the "Calculator" button
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Calculator activity
                Intent intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        });
    }
}
