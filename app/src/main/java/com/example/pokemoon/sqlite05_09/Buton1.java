package com.example.pokemoon.sqlite05_09;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Buton1 extends AppCompatActivity {

    private List<UrunBilgiClass> urunlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private UAdapter mAdapter;
    DBhandler dBhandler;
    public Context mContext;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buton1);




        //initialise recyclerview
        recyclerView = findViewById(R.id.recycler_view);
        //initialise adapter class
        mAdapter = new UAdapter(getApplicationContext(), urunlist);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //set adapter to recyclerview
        recyclerView.setAdapter(mAdapter);
        //call method to fetch data from db and add to recyclerview
        prepareData();
        //swipe tatavası

        new SwipeHelper(this, recyclerView) {
            @Override
            public void instantiateUnderlayButton(final RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Delete",
                        R.drawable.ic_add,
                        ContextCompat.getColor(getApplicationContext(), R.color.red),
                        new UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                dBhandler.delete(urunlist.get(viewHolder.getAdapterPosition()).getKey());
                                urunlist.remove(pos);
                                mAdapter.notifyDataSetChanged();

                            }
                        }
                ));
            }
        };


    }


    @Override
    protected void onResume() {
        super.onResume();
        prepareData();
    }

    private void prepareData() {
        urunlist.clear();
        dBhandler  = new DBhandler(getApplicationContext());
        //data from database is returned to m
        final List<UrunBilgiClass> m = dBhandler.getAll();
        //Log.w("SIZE", "" + m.size());

        //if m contains data
        if (m.size() > 0) {
            //loop through contents
            for (int i = 0; i < m.size(); i++) {
                //Log.w("NAME", m.get(i).getUrunadi());
                //add data to list used in adapter
                urunlist.add(m.get(i));
                //notify data change
                mAdapter.notifyDataSetChanged();
                //refresh
            }
        }
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent insert= new Intent(Buton1.this, ActivityEkle.class);
        startActivity(insert);
        return super.onOptionsItemSelected(item);
    }


}
