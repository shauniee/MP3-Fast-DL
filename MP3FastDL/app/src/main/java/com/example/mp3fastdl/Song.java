package com.example.mp3fastdl;

public class Song {
    private String id;
    private String title;
    private String artist;
    private String filelink;
    private double songLength;
    private String coverArt;

    public Song(String _id, String _title, String _artist, String _filelink, double _songLength, String _coverArt){
        this.id = _id;
        this.title = _title;
        this.artist = _artist;
        this.filelink = _filelink;
        this.songLength = _songLength;
        this.coverArt = _coverArt;
    }
    //    create get/set methods for variables
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getFilelink(){
        return filelink;
    }
    public double getsongLength(){ return songLength; }
    public String getCoverArt(){
        return coverArt;
    }
    public void setId(String id) {
        this.id = id;
    }


}
