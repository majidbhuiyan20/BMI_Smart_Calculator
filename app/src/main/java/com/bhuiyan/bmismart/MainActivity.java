package com.bhuiyan.bmismart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edWeight, edInch, edFeet;
    Button button;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edWeight = findViewById(R.id.edWeight);
        edInch = findViewById(R.id.edInch);
        edFeet = findViewById(R.id.edFeet);
        button = findViewById(R.id.button);
        tvDisplay = findViewById(R.id.tvDisplay);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if(edWeight.getText().toString().length()>0 || edInch.getText().toString().length()>0 || edFeet.getText().toString().length()>0)
                {
                    float weight = Float.parseFloat(edWeight.getText().toString());
                    float inch = Float.parseFloat(edInch.getText().toString());
                    float feet = Float.parseFloat(edFeet.getText().toString());

                    float height = (float) (inch*0.0254 + feet*0.3048);

                    float bmi = weight/height/height;



                    if(bmi>24)
                    {
                        tvDisplay.setText("Your BMI is: "+bmi+"\n\nYou are Overweight");
                    }
                    else if(bmi<24 && bmi>=18)
                    {
                        tvDisplay.setText("Your BMI is: "+bmi+"\n\nYou are Perfect Weight");
                    }
                    else
                    {
                        tvDisplay.setText("Your BMI is: "+bmi+"\n\nYou are Underweight");
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Empty EditText", Toast.LENGTH_SHORT).show();
                }

               



            }
        });



    }
}