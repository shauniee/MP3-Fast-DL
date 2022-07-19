package com.example.mp3fastdl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3fastdl.Util.AppUtil;


public class FavouriteActivity extends AppCompatActivity {
    RecyclerView favlist;
    SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        favlist = findViewById(R.id.recycleView);

        songAdapter = new SongAdapter(myplaylist.favlist);
        favlist.setAdapter(songAdapter);
        favlist.setLayoutManager(new LinearLayoutManager(this));
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                songAdapter.getFilter().filter(newText);
                return false;
            }
        });

//        for (int i = 0; i < MainActivity.favlist.size(); i++) {
//            Log.d("temasek", MainActivity.favlist.get(i).getTitle());
        }
    public void removeAll(View view) {
        myplaylist.favlist.clear();
        songAdapter.notifyDataSetChanged();
        SharedPreferences sharedPreferences = getSharedPreferences("playList", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("list", "");
        editor.apply();
    }
}