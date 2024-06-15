package me.umar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String ... args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestAnnotationBean tab = context.getBean("testAnnotationBean", TestAnnotationBean.class);
        System.out.println(tab.toString());
        context.close();
    }
}
