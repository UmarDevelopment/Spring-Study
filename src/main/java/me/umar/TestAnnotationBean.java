package me.umar;

import org.springframework.stereotype.Component;

@Component
public class TestAnnotationBean {
    int someval;
    String someString;

    public TestAnnotationBean(){
        System.out.println("Ob created");
    }

    public int getSomeval() {
        return someval;
    }

    public void setSomeval(int someval) {
        this.someval = someval;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    @Override
    public String toString(){
        return (someval+":"+someString);
    }
}
