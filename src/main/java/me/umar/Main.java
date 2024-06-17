package me.umar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String ... args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MusicPlayer mp = context.getBean("musicPlayer", MusicPlayer.class);
        mp.playMusic(MusicType.CLASSIC);
        context.close();
    }
}
