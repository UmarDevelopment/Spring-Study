package me.umar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String ... args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Music musicBean = context.getBean("musicBean", Music.class);
        MusicPlayer mp = new MusicPlayer(musicBean);
        mp.playMusic();
    }
}
