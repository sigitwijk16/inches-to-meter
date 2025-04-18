package com.gitz.inchesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInches;
    private Button calculateButton;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        setUpCalculateButtonListener();
    }

    private void setUpCalculateButtonListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesText = editTextInches.getText().toString();

                if (inchesText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill the field", Toast.LENGTH_LONG).show();
                } else{
                    calculateMeter(inchesText);
                }
            }
        });
    }

    private void calculateMeter(String inchesText) {
            int inches = Integer.parseInt(inchesText);
            double meterResult = inches * 0.0254;

            displayResult(meterResult);
    }

    private void displayResult(double meterResult) {
        DecimalFormat newDecimalFormatter = new DecimalFormat("0.00");
        String formattedResult = newDecimalFormatter.format(meterResult);

        String fullResult = "The result is " + formattedResult + " m";
        textViewResult.setText(fullResult);
    }
    private void findViews() {
        editTextInches = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        textViewResult = findViewById(R.id.text_view_result);
    }

}