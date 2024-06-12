package me.umar;

public class TestBean {
    String name;
    int someint = 0;

    public TestBean(String name) {
        this.name = name;
    }
    public TestBean(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSomeint(int val){
        this.someint = val;
    }

    public int getSomeint(){
        return someint;
    }
}
