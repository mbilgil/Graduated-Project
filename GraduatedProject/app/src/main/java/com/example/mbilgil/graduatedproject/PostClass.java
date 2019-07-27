package com.example.mbilgil.graduatedproject;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by furkan on 4.04.2018.
 */

public class PostClass extends ArrayAdapter<String>{


    private final ArrayList<String> userImage;
    //private final ArrayList<String> userYardim;
    private final Activity context;



    public PostClass(ArrayList<String> userImage, Activity context) {
        super(context, R.layout.custom_view, userImage);


        //this.userYardim = userYardim;
        this.userImage = userImage;

        this.context = context;
    }

    private  static class ViewHolder{
        Button btnYardim;
        ImageView imageView;
        TextView txt;
    }

    public void onClick(View v){
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.btnYardim = (Button)v.findViewById(R.id.btnYardim);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder;

        viewHolder = new ViewHolder();

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);

        viewHolder.txt = (TextView) customView.findViewById(R.id.txtYardim);

        //TextView userYardim = (TextView) customView.findViewById(R.id.txtYardim);
        ImageView imageView = (ImageView) customView.findViewById(R.id.imageView2);
        viewHolder.btnYardim = (Button)customView.findViewById(R.id.btnYardim);


        viewHolder.btnYardim.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updateEditText(position, viewHolder.txt, "lebelübe");

                Intent intent=new Intent(getContext(),gEngelActivity.class);
                context.startActivity(intent);


            }
        });

        //userYardim.setText(userYardim.get(position));
        Picasso.with(context).load(userImage.get(position)).into(imageView);


        return customView;
    }

    private void updateEditText(int position, TextView txt, String value){
        txt.setText(value);
    }



}
