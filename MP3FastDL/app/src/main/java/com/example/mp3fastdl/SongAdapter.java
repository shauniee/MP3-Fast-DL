package com.example.mp3fastdl;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3fastdl.Util.AppUtil;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<MyView> implements Filterable {

    private List<Song> mContacts;
    private List<Song> mContactsFiltered;
    Context context;
    public SongAdapter(List<Song> mContacts) {
        this.mContacts = mContacts;
        this.mContactsFiltered = mContacts;
    }
    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_song,parent,false);
        MyView viewHolder = new MyView(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, final int position) {
        Song contact =mContactsFiltered.get(position);
        TextView artist = holder.textView10;
        artist.setText(contact.getArtist());
        TextView title = holder.title;
        title.setText(contact.getTitle());
        int imageId = AppUtil.getImageIdFromDrawable(context, contact.getCoverArt());
        holder.image.setImageResource(imageId);
        holder.imageView13.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myplaylist.favlist.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContactsFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    mContactsFiltered = mContacts;
                } else {
                    List<Song> filteredList = new ArrayList<Song>();
                    for (int i = 0; i < mContacts.size(); i++) {
                        if (mContacts.get(i).getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(mContacts.get(i));
                        }

                    }
                    mContactsFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mContactsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mContactsFiltered = (List<Song>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
