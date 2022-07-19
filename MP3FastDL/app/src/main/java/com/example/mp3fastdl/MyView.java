package com.example.mp3fastdl;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyView extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView textView10;
    public ImageView image;
    public ImageView imageView13;

    public MyView(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        textView10 = itemView.findViewById(R.id.textView10);
        image = itemView.findViewById(R.id.image);
        imageView13 = itemView.findViewById(R.id.imageView13);
    }
}
