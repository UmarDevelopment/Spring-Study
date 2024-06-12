package me.umar;

public class MusicPlayer {
    private Music music;

    public MusicPlayer (Music music){
        this.music = music;
    }
    public MusicPlayer(){}

    public void playMusic(){
        music.playSong();
    }

    public void setMusic(Music music){
        this.music = music;
    }
}
