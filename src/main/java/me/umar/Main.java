package me.umar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String ... args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MusicPlayer mp1 = context.getBean("musicPlayer", MusicPlayer.class);
        TestBean testBean1 = context.getBean("testBean", TestBean.class);
        System.out.println(testBean1.getName());
        context.close();
    }
}
