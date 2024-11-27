package me.umar.models.cleintsystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client2")
public class Client {
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", rank=" + rank +
                '}';
    }

    @Id
    public Integer id;
    public String name;
    public String surname;
    public Integer age;
    @Column(name = "`rank`")
    public Integer rank;

    public Client(Integer id, String name, String surname, Integer age, Integer rank) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.rank = rank;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
