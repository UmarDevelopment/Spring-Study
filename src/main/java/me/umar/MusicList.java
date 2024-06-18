package me.umar;

import java.util.ArrayList;
import java.util.Random;

public class MusicList {
    ArrayList<Music> musics;

    public MusicList(){
        musics = new ArrayList<>();
    }

    public MusicList addMusic(Music music){
        musics.add(music);
        return this;
    }

    public Music randomMusic(){
        return musics.get(new Random().nextInt(musics.size()));
    }
}
