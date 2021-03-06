package com.example.pokemoon.sqlite05_09;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UAdapter extends RecyclerView.Adapter<UAdapter.MyVievHolder> {

    private List<UrunBilgiClass> urunBilgiClassList;
    public Context mContext;

    public class MyVievHolder extends RecyclerView.ViewHolder {
        Button b2, b3,b4;
        TextView u1, u2, u3;
        //todo üstten public sildik


        public MyVievHolder(View itemView) {
            super(itemView);
            u1 =  itemView.findViewById(R.id.urunadiitem);
            u2 = itemView.findViewById(R.id.urunadetiitem);
            u3 = itemView.findViewById(R.id.urunfiyatiitem);
            b2 = itemView.findViewById(R.id.btnedit);



        }

    }

    public UAdapter(Context context,List<UrunBilgiClass> urunBilgiClassList){
        this.urunBilgiClassList=urunBilgiClassList;
        this.mContext=context;
    }

    @Override
    public MyVievHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //set item layout using layout inflater
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_view_item, parent, false);
        return new MyVievHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyVievHolder holder, final int position) {
        final UrunBilgiClass urunBilgiClass = urunBilgiClassList.get(position);

        holder.u1.setText(urunBilgiClassList.get(position).getUrunadi());
        holder.u2.setText(String.valueOf(urunBilgiClassList.get(position).getAdet()));
        holder.u3.setText(String.valueOf(urunBilgiClassList.get(position).getFiyat()));
               //Onclick EDIT Button
        holder.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, Editact.class);
                //pass details to to be edited to next class using putExtra
                i.putExtra("urunadi", urunBilgiClass.getUrunadi());
                i.putExtra("fiyat", urunBilgiClass.getFiyat());
                i.putExtra("adet", urunBilgiClass.getAdet());
                i.putExtra("key", urunBilgiClass.getKey());
               i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return urunBilgiClassList.size();
    }


}
