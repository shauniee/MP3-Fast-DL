package com.example.mp3fastdl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mp3fastdl.Util.AppUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class myplaylist extends Activity {
    songCollection songCollection = new songCollection();
    static ArrayList<Song> favlist = new ArrayList<>();
    SharedPreferences sharedPreferences;
    Boolean toggleFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplaylist);
        sharedPreferences = getSharedPreferences("playList", MODE_PRIVATE);
        String albumns = sharedPreferences.getString("list", "");
        if (!albumns.equals("")){
            TypeToken<ArrayList<Song>> token = new TypeToken<ArrayList<Song>>(){};
            Gson gson = new Gson();
            favlist = gson.fromJson(albumns, token.getType());
        }
    }

    public void handleSelection(View view) {
//        Toast.makeText(this, "image button clicked", Toast.LENGTH_SHORT).show();
        String resourceID = AppUtil.getResourceId(this, view);
        Song selectedSong = songCollection.searchByID(resourceID);
        Log.d("music123", selectedSong.getArtist());
        sendDataToActivity(selectedSong);
    }

    private void sendDataToActivity(Song selectedSong) {

        Intent intent = new Intent(this, PlaySongActivity.class);
        intent.putExtra("id", selectedSong.getId());
        intent.putExtra("title", selectedSong.getTitle());
        intent.putExtra("artist", selectedSong.getArtist());
        intent.putExtra("FileLink", selectedSong.getFilelink());
        intent.putExtra("CoverArt", selectedSong.getCoverArt());
        startActivity(intent);
    }
    public void repeatSong(View view) {
        if (toggleFlag) {
            Log.d("toggle", "" + toggleFlag);
        } else {
            Log.d("toggle", "" + toggleFlag);
        }
        toggleFlag = !toggleFlag;
    }

    public void shuffleSong(View view) {
        if (toggleFlag) {
            Log.d("toggle", "" + toggleFlag);
        } else {
            Log.d("toggle", "" + toggleFlag);
        }
        toggleFlag = !toggleFlag;
    }

    public void addToFavourite(View view) {
        String songID = view.getContentDescription().toString();
        Song song = songCollection.searchByID(songID);
        favlist.add(song);
//        gson to convert objects to json
        Gson gson = new Gson();
//        json stores and transmit data
        String json = gson.toJson(favlist);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("list", json);
        editor.apply();
        Log.d("gson", json);
        for (int i = 0; i < favlist.size(); i++) {
        Toast.makeText(this, "Song Added", Toast.LENGTH_SHORT).show();
        }
    }
}
