package com.example.mp3fastdl;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Downloads extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);



    }

    public static final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private static final int REQUEST_PERMISSIONS = 12345;
    private static final int PERMISSIONS_COUNT = 1;

    private boolean arePermissionsDenied(){
        for (int i = 0; i < PERMISSIONS_COUNT; i++){
            if (checkSelfPermission(PERMISSIONS[i]) != PackageManager.PERMISSION_GRANTED){
                return true;
            }
        }
        return false;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (arePermissionsDenied()){
            ((ActivityManager) (this.getSystemService(ACTIVITY_SERVICE))).clearApplicationUserData();
            recreate();
        }else{
            onResume();
        }
    }

    private boolean isMusicPlayerInit;

    private List<String> musicFilesList;
    private void addMusicFilesFrom(String dirPath){
        final File musicDir = new File(dirPath);
        if (!musicDir.exists()){
            musicDir.mkdir();
            return;
        }
        final File[] files = musicDir.listFiles();
        for (File file : files){
            final String path = file.getAbsolutePath();
            if(path.endsWith(".mp3")){
                musicFilesList.add(path);
            }
        }
    }
    private void fillMusicList(){
        musicFilesList.clear();
        addMusicFilesFrom(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)));
        addMusicFilesFrom(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)));
    }
    private MediaPlayer mp = null;

    private int playMusicFile(String path){
        mp = new MediaPlayer();
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
        } catch (Exception e){
            e.printStackTrace();
        }
        return mp.getDuration();
    }
    private int songPosition;
    private volatile boolean isSongPlaying;
    private int mPosition;
    Handler handler = new Handler();

    Runnable p_bar = new Runnable() {
        @Override
        public void run() {
            if (mp != null && mp.isPlaying()) {
                seekBar.setProgress(mp.getCurrentPosition());
            }
            handler.postDelayed(this, 1000);
        }
    };

    private void preparemp() {
        mp = new MediaPlayer();
        try {
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playSong(){
        final String musicFilePath = musicFilesList.get(mPosition);
        final int songDuration = playMusicFile(musicFilePath)/1000;
        seekBar.setMax(songDuration);
        seekBar.setVisibility(View.VISIBLE);
        playBackControls.setVisibility(View.VISIBLE);


               if (mp == null){
                   preparemp();
               }
                    if (mp.isPlaying()) {
                        mp.start();
                        seekBar.setMax(mp.getDuration());
                        handler.removeCallbacks(p_bar);
                        handler.postDelayed(p_bar, 1000);
                        songPosition++;
                                seekBar.setProgress(songPosition);

                    }else {
                        mp.pause();
                        pauseButton.setText("play");
                        seekBar.setProgress(songPosition);
                    }
    }

    private SeekBar seekBar;
    private View playBackControls;
    private Button pauseButton;


    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && arePermissionsDenied()) {
            requestPermissions(PERMISSIONS, REQUEST_PERMISSIONS);
            return;
        }
        if (!isMusicPlayerInit){
            final ListView listView = findViewById(R.id.listView);
            final TextAdapter textAdapter = new TextAdapter();
            musicFilesList = new ArrayList<>();
            fillMusicList();
            textAdapter.setData(musicFilesList);
            listView.setAdapter(textAdapter);
            seekBar = findViewById(R.id.seekBar);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                int songProgress;

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    songProgress = progress;
                    mp.getCurrentPosition();

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    if (mp != null && mp.isPlaying()) {
                        mp.seekTo(seekBar.getProgress());
                    }

                }
            });


            pauseButton = findViewById(R.id.pauseButton);
            playBackControls = findViewById(R.id.playBackButtons);
            pauseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isSongPlaying) {
                        mp.pause();
                        pauseButton.setText("play");
                    } else {
                        if (songPosition == 0){
                            playSong();
                        }else {
                            mp.start();
                        }
                        pauseButton.setText("pause");
                    }
                    isSongPlaying = !isSongPlaying;
                }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mPosition = position;
                    playSong();
                }
            });
            isMusicPlayerInit =true;
        }
    }
    class TextAdapter extends BaseAdapter{
        private List<String> data = new ArrayList<>();
        void setData(List<String> mData){
            data.clear();
            data.addAll(mData);
            notifyDataSetChanged();
        }
        @Override
        public int getCount(){
            return data.size();
        }
        @Override
        public String getItem(int position){
            return null;
        }
        @Override
        public long getItemId(int position){
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null);{
//                used to create a new View (or Layout) object from one of your xml layouts.
                convertView = LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.item, parent, false);
                convertView.setTag(new ViewHolder((TextView) convertView.findViewById(R.id.myItem)));
            }
//            used to speed up rendering of your ListView - actually to make it work smoothly
            ViewHolder holder = (ViewHolder) convertView.getTag();
            final String item = data.get(position);
            holder.info.setText(item.substring(item.lastIndexOf('/')+1));
            return convertView;
        }
        class ViewHolder{
            TextView info;

            ViewHolder(TextView mInfo){
                info = mInfo;
            }
        }
    }
}