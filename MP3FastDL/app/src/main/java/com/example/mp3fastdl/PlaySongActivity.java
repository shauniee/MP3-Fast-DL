package com.example.mp3fastdl;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mp3fastdl.Util.AppUtil;
import com.example.mp3fastdl.Util.AppUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlaySongActivity<shuffleFlag> extends AppCompatActivity {

    private String songID;
    private String title;
    private String artist;
    private String fileLink;
    private String coverArt;
    private String url;
    private ImageView repeatBtn = null;
    private ImageView shuffleBtn = null;
    Boolean repeatFlag = false;
    Boolean shuffleFlag = false;
    SeekBar seekBar;
    Handler handler = new Handler();


    private String BASE_URL = "https://p.scdn.co/mp3-preview/";
    private MediaPlayer player = null;
    ImageView playAndPauseImage;


    List<Song> shuffleList = Arrays.asList(songCollection.songs);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        retrieveData();
        displaySong(title, artist, coverArt);
        repeatBtn = findViewById(R.id.repeatBtn);
        shuffleBtn = findViewById(R.id.shuffleBtn);
        playAndPauseImage = findViewById(R.id.playViewBtn);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (player != null && player.isPlaying()) {
                    player.seekTo(seekBar.getProgress());
                }
            }
        });
    }

    Runnable p_bar = new Runnable() {
        @Override
        public void run() {
            if (player != null && player.isPlaying()) {
                seekBar.setProgress(player.getCurrentPosition());
            }
                handler.postDelayed(this, 1000);
        }
    };


    private void displaySong(String title, String artist, String coverArt) {
//here we find txt view using id
        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);
        TextView txtArtist = findViewById(R.id.txtArtist);
        txtArtist.setText(artist);
        ImageView iCoverArt = findViewById(R.id.imgCoverArt);
        int imageID = AppUtil.getImageIdFromDrawable(this, coverArt);
        iCoverArt.setImageResource(imageID);
    }


    private void retrieveData() {
        Bundle songData = this.getIntent().getExtras();
        Log.d("music123", songData.getString("id"));
        Log.d("music123", songData.getString("title"));
        Log.d("music123", songData.getString("artist"));
        Log.d("music123", songData.getString("FileLink"));
        Log.d("music123", songData.getString("CoverArt"));
        songID = songData.getString("id");
        title = songData.getString("title");
        artist = songData.getString("artist");
        fileLink = songData.getString("FileLink");
        coverArt = songData.getString("CoverArt");
        url = BASE_URL + fileLink;
        Log.d("music123", url);

    }

    private void preparePlayer() {
        player = new MediaPlayer();
        try {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(url);
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playOrPauseMusic(View view) {
        if (player == null) {
            preparePlayer();
        }
        //if player is NOT playing
        if (!player.isPlaying()) {
//            play music here
            player.start();
            seekBar.setMax(player.getDuration());
            handler.removeCallbacks(p_bar);
            handler.postDelayed(p_bar, 1000);
            gracefullyStopsWhenMusicEnds();
            setTitle("Now Playing: " + title + " - " + artist);
            int imageID = AppUtil.getImageIdFromDrawable(this, "ic_pause_black_24dp");
            playAndPauseImage.setImageResource(imageID);
        } else {
//            pause music here
            pauseMusic();
            setTitle("Song Paused");
        }
    }

    private void pauseMusic() {
        player.pause();
        int imageID = AppUtil.getImageIdFromDrawable(this, "ic_play_arrow_black_24dp");
        playAndPauseImage.setImageResource(imageID);

    }

    private void gracefullyStopsWhenMusicEnds() {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (repeatFlag) {
                    playOrPauseMusic(null);
                } else {
                    setTitle("");
                    ImageView imgPlayPause = findViewById(R.id.playViewBtn);
                    imgPlayPause.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (player != null) {
            handler.removeCallbacks(p_bar);
            player.stop();
            player.release();
            player = null;
        }
    }

    public void playNext(View view) {

        Song nextSong = songCollection.getNextSong(songID);
        if (nextSong != null) {
            songID = nextSong.getId();
            title = nextSong.getTitle();
            artist = nextSong.getArtist();
            fileLink = nextSong.getFilelink();
            coverArt = nextSong.getCoverArt();
            url = BASE_URL + fileLink;
            displaySong(title, artist, coverArt);
            stopActivities();
        }else {
            Toast.makeText(this, "End Of Playlist", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopActivities() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
        playOrPauseMusic(null);
    }

    public void playPrevious(View view) {
        Song nextSong = songCollection.getPrevSong(songID);
        if (nextSong != null) {
            songID = nextSong.getId();
            title = nextSong.getTitle();
            artist = nextSong.getArtist();
            fileLink = nextSong.getFilelink();
            coverArt = nextSong.getCoverArt();
            url = BASE_URL + fileLink;
            displaySong(title, artist, coverArt);
            stopActivity();
        }else {
            Toast.makeText(this, "End Of Playlist", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopActivity() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
        playOrPauseMusic(null);
    }

    public void repeatSong(View view) {
        if (repeatFlag) {
            repeatBtn.setImageResource(R.drawable.ic_repeat_black_off_24dp);
        } else {
            repeatBtn.setImageResource(R.drawable.ic_repeat_black_24dp);
        }
        repeatFlag = !repeatFlag;
    }

    public void shuffleSong(View view) {
        if (shuffleFlag) {
            shuffleBtn.setImageResource(R.drawable.ic_shuffle_black_off_24dp);
        } else {
            shuffleBtn.setImageResource(R.drawable.ic_shuffle_black_24dp);
            Collections.shuffle(shuffleList);
            shuffleList.toArray(songCollection.songs);
        }
        shuffleFlag = !shuffleFlag;
    }


}
