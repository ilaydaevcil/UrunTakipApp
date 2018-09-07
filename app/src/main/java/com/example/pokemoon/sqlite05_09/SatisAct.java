package com.example.pokemoon.sqlite05_09;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SatisAct extends AppCompatActivity {


    private List<UrunBilgiClass> urunlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private UAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satis);

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



    }


    @Override
    protected void onResume() {
        super.onResume();
        prepareData();
    }

    private void prepareData() {
        urunlist.clear();
        DBhandler db = new DBhandler(getApplicationContext());
        //data from database is returned to m
        final List<UrunBilgiClass> m = db.getAll();
        //Log.w("SIZE", "" + m.size());
        db.close();

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



}
