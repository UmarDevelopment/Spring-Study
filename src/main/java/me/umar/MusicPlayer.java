package me.umar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

public class MusicPlayer {
    private MusicList musicList;

    public MusicPlayer(MusicList musicList) {
        this.musicList = musicList;
    }


    public void playMusic(MusicType type) {
        musicList.randomMusic().playSong();
    }
}

