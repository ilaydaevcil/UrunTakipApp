package com.example.pokemoon.sqlite05_09;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonlistele;
    Button buttonsat;
    Button buttonsatilmislar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      buttonlistele=findViewById(R.id.listelekismi);
        buttonsat=findViewById(R.id.satiskismi);
        buttonsatilmislar=findViewById(R.id.satilmislarkismi);

        buttonlistele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent insert= new Intent(MainActivity.this, Buton1.class);
                startActivity(insert);

            }
        });
        buttonsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent insert= new Intent(MainActivity.this, SatisAct.class);
               // startActivity(insert);
            }
        });

    }
}
