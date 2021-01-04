package com.example.myapplicationslider;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder>  {
    private Context mContext ;
    private List<SongLists> mData ;

    public SongAdapter(Context mContext, List<SongLists> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.song_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SongAdapter.MyViewHolder holder, final int position) {

        holder.ivSongImage.setImageResource(mData.get(position).getSongImage());
        holder.tvSongName.setText(mData.get(position).getSongName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvSongName;
        ImageView ivSongImage;
        MyViewHolder(View itemView) {
            super(itemView);
            tvSongName=itemView.findViewById(R.id.tv_song_name);
            ivSongImage=itemView.findViewById(R.id.imageview_song_image);
        }
    }
}
