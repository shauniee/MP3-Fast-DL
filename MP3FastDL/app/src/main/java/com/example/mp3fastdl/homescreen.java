package com.example.mp3fastdl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class homescreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login_page.class));
        finish();
    }
    public void goToSongs(View view){
        Intent intent = new Intent(this, myplaylist.class);
        startActivity(intent);
    }
    public void goToFavourites(View view){
        Intent intent = new Intent(this, FavouriteActivity.class);
        startActivity(intent);
    }
    public void iconsHelp(View view){
        Intent intent = new Intent(this, helpIcon.class);
        startActivity(intent);
    }
    public void downloadSong(View view){
        Intent intent = new Intent(this, Downloads.class);
        startActivity(intent);
    }
    public void topSongs(View view){
        Intent intent = new Intent(this, popular_songs.class);
        startActivity(intent);
    }
    public void enterSetting(View view){
        Intent intent = new Intent(this, app_Settings.class);
        startActivity(intent);
    }
    public void seeRecommended(View view){
        Intent intent = new Intent(this, recommended_songs.class);
        startActivity(intent);
    }
}
