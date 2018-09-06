package com.example.pokemoon.sqlite05_09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editact extends AppCompatActivity {
    Button b1;
    EditText adi, adeti, fiyati;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editact);
        adi =findViewById(R.id.txturunadi);
        adeti =findViewById(R.id.txturunadeti);
        fiyati =findViewById(R.id.txturunfiyati);
        b1=findViewById(R.id.btnedit);

        //get data from intent using  getStringExtra
        String adi = getIntent().getStringExtra("urunadi");
        int adet = getIntent().getIntExtra("adet",0);
        int fiyat = getIntent().getIntExtra("fiyat", 0);
        final int key = getIntent().getIntExtra("key", 0);

        this.adi.setText(adi);
        this.adeti.setText(String.valueOf(adet));
        this.fiyati.setText(fiyat);

        //on click of EDIT button

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new object to add to database
                UrunBilgiClass u = new UrunBilgiClass(Editact.this.adi.getText().toString(), Integer.parseInt(adeti.getText().toString()), Integer.parseInt(fiyati.getText().toString()));
                DBhandler db = new DBhandler(getApplicationContext());
                //call method to edit row in table
                db.edit(u, key);
                db.close();
                Toast.makeText(getApplicationContext(), "Changed", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}
