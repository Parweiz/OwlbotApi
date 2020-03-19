package com.example.ownbotapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ownbotapi.model.Word;

import java.util.ArrayList;
import java.util.List;

public class OwlBotAdapter extends RecyclerView.Adapter<OwlBotAdapter.ViewHolder> {
    private ArrayList<Word> words;

    public static final String TAG = "main";

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtWordName;
        public TextView txtPronounciation;
        public TextView txtRating;
        //public NetworkImageView imgCharacter;
        public ImageView imgWord;


        //constructor gets reference to the view
        public ViewHolder(View v) {
            super(v);
            imgWord = v.findViewById(R.id.imgCharacter);
            txtWordName = v.findViewById(R.id.txtNameOfTheWord);
            txtPronounciation = v.findViewById(R.id.txtPronoucing);
            txtRating = v.findViewById(R.id.txtListRating);
        }

    }

    public OwlBotAdapter(ArrayList<Word> wordList, Context c) {
        words = wordList;
    }

    @Override
    public OwlBotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(holder.imgWord.getContext()).load(
                words.get(position)
                        .getDefinitions()
                        .get(0)
                        .getImageUrl())
                .into(holder.imgWord);

        holder.txtWordName.setText(words.get(position).getWord());
        holder.txtPronounciation.setText(words.get(position).getPronunciation());

        Log.d(TAG, "onBindViewHolder: " + words.get(position).getPronunciation());

        holder.txtRating.setText("0.0");
    }

    @Override
    public int getItemCount() {
        return words.size();
    }
}
