package com.example.ataglieri.cookieclicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ImageButton bakeRate;
    TextView rate;

    Button bake;
    TextView cookiesScore;

    int currentRate = 1;
    int currentCost = 4;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bakeRate = findViewById(R.id.bakeRate);
        rate = findViewById(R.id.Rate1);
        bakeRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(score > currentCost) {
                    currentRate++;
                    score = score - currentCost;
                    cookiesScore.setText(Integer.toString(score));
                    currentCost = currentCost * 2;
                }
                rate.setText("Current Rate: " + Integer.toString((currentRate)));
                updateButtonEnabledState();
            }

        });

        cookiesScore = findViewById(R.id.valCookies);
        bake = findViewById(R.id.Bake);
        bake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score += currentRate;
                cookiesScore.setText(Integer.toString(score));
                updateButtonEnabledState();
            }
        });
    }


    void updateButtonEnabledState(){
        if(score > currentCost){
            bakeRate.setEnabled(true);
            bakeRate.setBackgroundColor(Color.BLUE);
        }
        else{
            bakeRate.setEnabled(false);
            bakeRate.setBackgroundColor(Color.RED);
        }
    }

}
