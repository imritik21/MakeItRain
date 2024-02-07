package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
//    private Button showInfo;
    private TextView moneyValue;
//    private TextView richNess;
    private int moneyCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeItRain=findViewById(R.id.buttonMakeitRain);
        moneyValue=findViewById(R.id.moneyValue);
//        moneyValue.setTextColor(getResources().getColor(R.color.orange));


        makeItRain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberFormat numberFormat= null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    numberFormat = NumberFormat.getCurrencyInstance();
                }
                moneyCounter+=1000;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter))); // as it receives string
                }
//                if(moneyCounter>5000){
//                    moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.orange));
//                }
                // instead we will use switch case
                switch(moneyCounter){
                    case 5000:
                        moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.orange));
                        break;
                    case 10000:
                        moneyValue.setTextColor(Color.MAGENTA);
                        break;
                    case 15000:
                        moneyValue.setTextColor(Color.RED);
                        break;
                    default:
                        moneyValue.setTextColor(Color.WHITE);
                }
                Log.d("MainActivity", "onClick: Make it Rain "+moneyCounter);
            }
        });
    }
}