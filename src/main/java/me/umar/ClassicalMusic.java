package me.umar;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music{
    @Override
    public void playSong() {
        System.out.println("Play Hungeruan rapsody");
    }
}
