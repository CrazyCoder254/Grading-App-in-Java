package com.example.gradingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference UI Elements
        EditText score1 = findViewById(R.id.score1);
        EditText score2 = findViewById(R.id.score2);
        EditText score3 = findViewById(R.id.score3);
        EditText score4 = findViewById(R.id.score4);
        EditText score5 = findViewById(R.id.score5);

        TextView grade1 = findViewById(R.id.grade1);
        TextView grade2 = findViewById(R.id.grade2);
        TextView grade3 = findViewById(R.id.grade3);
        TextView grade4 = findViewById(R.id.grade4);
        TextView grade5 = findViewById(R.id.grade5);

        Button generateGradesButton = findViewById(R.id.generateGradesButton);

        // Set Button OnClickListener
        generateGradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calculate grades
                grade1.setText(calculateGrade(score1));
                grade2.setText(calculateGrade(score2));
                grade3.setText(calculateGrade(score3));
                grade4.setText(calculateGrade(score4));
                grade5.setText(calculateGrade(score5));
            }
        });
    }

    // Method to calculate grade
    private String calculateGrade(EditText scoreField) {
        try {
            int score = Integer.parseInt(scoreField.getText().toString());
            if (score >= 0 && score <= 39) {
                return "F";
            } else if (score >= 40 && score <= 49) {
                return "D";
            } else if (score >= 50 && score <= 59) {
                return "C";
            } else if (score >= 60 && score <= 69) {
                return "B";
            } else if (score >= 70 && score <= 100) {
                return "A";
            } else {
                return "Invalid";
            }
        } catch (NumberFormatException e) {
            return "Invalid";
        }
    }
}
