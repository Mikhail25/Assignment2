package com.example.assignment2;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private Context context;

    SongPojo dataSet;
    public CustomAdapter(SongPojo dataSet, Context context){
        this.dataSet = dataSet;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
   return new CustomViewHolder(LayoutInflater.from
                (viewGroup.getContext()).inflate
                (R.layout.item_song, viewGroup,false));

    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int position) {
        customViewHolder.songName.setText(dataSet.results.get(position).getCollectionName());
        customViewHolder.artistName.setText(dataSet.results.get(position).getArtistName());
        customViewHolder.priceView.setText(dataSet.results.get(position).getTrackPrice());

        Picasso.get().load(dataSet.results.get(position).getArtworkUrl60()).into(customViewHolder.imageView);
    }

    @Override
    public int getItemCount() {

        return dataSet.results.size() > 0 ? dataSet.results.size(): 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView songName;
        TextView artistName;
        TextView priceView;
        //MediaPlayer mediaPlayer;
        public final CardView songItemView;


        public CustomViewHolder(View itemView) {
            super(itemView);
            songItemView = itemView.findViewById(R.id.cv_song_info);
            imageView = itemView.findViewById(R.id.iv_song);
            songName = itemView.findViewById(R.id.tv_song_name);
            artistName = itemView.findViewById(R.id.tv_artist_name);
            priceView = itemView.findViewById(R.id.txt_view_price);
            //mediaPlayer = new MediaPlayer();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            //
            String musicLocation = dataSet.results.get(mPosition).getPreviewUrl();
            Uri uriMusic = Uri.parse(musicLocation);
            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setData(uriMusic);
            context.startActivity(intent);
/*
            try {
                mediaPlayer.setDataSource(musicLocation);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
                mediaPlayer.start();
                //Toast.makeText(context,"Stopped playing music~!", Toast.LENGTH_SHORT).show();*/
        }
    }

}
