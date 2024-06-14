package me.umar;

public class TestBean {
    String name;
    int someint = 0;

    public void init(){
        System.out.println("Some init");
    }
    public void destroy(){
        System.out.println("Some destroy");
    }

    private TestBean(String name) {
        this.name = name;
    }
    private TestBean(){}

    public static TestBean getTestBean(){
        System.out.println("inside fabric");
        return new TestBean();
    }

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
