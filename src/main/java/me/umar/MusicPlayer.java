package me.umar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private Music classic;
    private Music rock;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music1, @Qualifier("rockMusic")Music music2) {
        this.classic = music1;
        this.rock = music2;
    }


    public void playMusic(MusicType type) {
        if (type==MusicType.CLASSIC){
            classic.playSong();
        }else if (type==MusicType.ROCK){
            rock.playSong();
        }
    }
}

