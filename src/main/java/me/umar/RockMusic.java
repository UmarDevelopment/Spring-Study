package me.umar;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music{
    @Override
    public void playSong() {
        System.out.println("Play Rock n Roll");
    }
}
