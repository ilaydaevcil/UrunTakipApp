package com.example.pokemoon.sqlite05_09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityEkle extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        e1=findViewById(R.id.txturunadi);
        e2=findViewById(R.id.txturunadeti);
        e3=findViewById(R.id.txturunfiyati);
        b1=findViewById(R.id.btnekle);




            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(e1.getText().toString().equals("") || e2.getText().toString().equals("") || e3.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "o boşluklar doldurulacakk", Toast.LENGTH_SHORT).show();
                }
                else    {
                        UrunBilgiClass u = new UrunBilgiClass(e1.getText().toString(), Integer.parseInt(e2.getText().toString()), Integer.parseInt(e3.getText().toString()));
                        DBhandler db = new DBhandler(getApplicationContext());
                        //call method to add data to db
                        db.addUrun(u);
                        db.close();
                        Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT).show();
                        finish();

                    }

                }
            });






    }
}
