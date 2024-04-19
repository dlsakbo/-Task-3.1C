package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    // Declare UI components
    private EditText firstNumberEditText, secondNumberEditText;
    private TextView additionResultTextView, subtractionResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Initialize UI components by finding their respective views
        firstNumberEditText = findViewById(R.id.num1EditText);
        secondNumberEditText = findViewById(R.id.num2EditText);
        Button additionButton = findViewById(R.id.additionBtn);
        Button subtractionButton = findViewById(R.id.subtractBtn);
        additionResultTextView = findViewById(R.id.result1);
        subtractionResultTextView = findViewById(R.id.result2);

        // Set OnClickListener for the addition button
        additionButton.setOnClickListener(v -> {
            // Get input values from EditText fields
            String strFirstNumber = firstNumberEditText.getText().toString().trim();
            String strSecondNumber = secondNumberEditText.getText().toString().trim();

            // Check if input fields are empty
            if (strFirstNumber.isEmpty() || strSecondNumber.isEmpty()) {
                Toast.makeText(Calculator.this, "Please provide input/s", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                // Parse input values to float
                float firstNumberValue = Float.parseFloat(strFirstNumber);
                float secondNumberValue = Float.parseFloat(strSecondNumber);

                // Perform addition and display result
                additionResultTextView.setText(firstNumberValue + " + " + secondNumberValue + " = " + (firstNumberValue + secondNumberValue));
            } catch (NumberFormatException e) {
                // Handle invalid input
                Toast.makeText(Calculator.this, "Invalid input. Please provide valid numbers", Toast.LENGTH_SHORT).show();
            }
        });

        // Set OnClickListener for the subtraction button
        subtractionButton.setOnClickListener(v -> {
            // Get input values from EditText fields
            String strFirstNumber = firstNumberEditText.getText().toString().trim();
            String strSecondNumber = secondNumberEditText.getText().toString().trim();

            // Check if input fields are empty
            if (strFirstNumber.isEmpty() || strSecondNumber.isEmpty()) {
                Toast.makeText(Calculator.this, "Please provide input/s", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                // Parse input values to float
                float firstNumberValue = Float.parseFloat(strFirstNumber);
                float secondNumberValue = Float.parseFloat(strSecondNumber);

                // Perform subtraction and display results (two ways)
                subtractionResultTextView.setText(secondNumberValue + " - " + firstNumberValue + " = " + (secondNumberValue - firstNumberValue));

            } catch (NumberFormatException e) {
                // Handle invalid input
                Toast.makeText(Calculator.this, "Invalid input. Please provide valid numbers", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
