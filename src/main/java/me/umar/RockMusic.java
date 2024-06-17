package me.umar;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RockMusic implements Music{

    List<String> songs;

    public RockMusic(){
        songs = new ArrayList<>();
        songs.add("ROCK 1");
        songs.add("ROCK 2");
        songs.add("ROCK 3");
    }
    @Override
    public void playSong() {
        System.out.println(songs.get(new Random().nextInt(songs.size())));
    }
}
