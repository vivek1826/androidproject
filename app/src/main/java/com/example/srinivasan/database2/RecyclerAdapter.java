package com.example.srinivasan.database2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SRINIVASAN on 4/20/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private String[] titles = {"Chapter One",
            "Chapter Two",
            "Chapter Three",
            "Chapter Four",
            "Chapter Five",
            "Chapter Six",
            "Chapter Seven",
            "Chapter Eight"};

    private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details"};

    private int[] images = { R.drawable.babysmile,
            R.drawable.bmwz,
            R.drawable.calvin,
            R.drawable.clean,
            R.drawable.cutebunny,
            R.drawable.doggy
             };
    private Context mContext;
    DatabaseHelperTwo db2;
    ArrayList<Bitmap> bitmapArray = new ArrayList<Bitmap>();
    // Constructor
String[] a,b,c;
    public RecyclerAdapter(Context context) {
        mContext = context;
        db2=new DatabaseHelperTwo(mContext);
        bitmapArray=db2.searchpass();
        a=db2.dat();
        b=db2.tim();
        c=db2.com();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;
        public TextView date;
        Context context;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
            date=(TextView)itemView.findViewById(R.id.textView6);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    //Snackbar.make(v, "Click detected on item " + position,
                    //        Snackbar.LENGTH_LONG)
                    //.setAction("Action", null).show();
                    Intent i = new Intent(mContext ,SingleView.class);
                    i.putExtra("i",position);
                    mContext.startActivity(i);
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.content_navmenu, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }



    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(a[i]);
        viewHolder.date.setText(b[i]);
        viewHolder.itemDetail.setText(c[i]);
        try {
            viewHolder.itemImage.setImageBitmap(bitmapArray.get(i));
        }catch (IndexOutOfBoundsException e){

        }
    }


    @Override
    public int getItemCount() {
        return a.length;
    }
}
