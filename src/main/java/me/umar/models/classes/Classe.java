package me.umar.models.classes;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Classe {
    int id;
    @NotEmpty(message = "EMPTY")
    @Size(min = 2, max = 20, message = "size error")
    String name;
    @NotEmpty(message = "EMPTY")
    @Email(message = "not valid email")
    String teacherEmail;
    @Min(value = 1, message = "min value should be 1")
    int roomNumber;

    public Classe(int id, String name, String teacherEmail, int roomNumber) {
        this.id = id;
        this.name = name;
        this.teacherEmail = teacherEmail;
        this.roomNumber = roomNumber;
    }

    public Classe() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
