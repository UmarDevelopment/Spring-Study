package me.umar.models.library;

public class Person {
    private boolean isExists = true;
    private int id;
    private String fio;

    public boolean isExists() {
        return isExists;
    }

    public void setExists(boolean exists) {
        isExists = exists;
    }

    private int birthYear;

    public Person(int id, String fio, int birthYear) {
        this.id = id;
        this.fio = fio;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
