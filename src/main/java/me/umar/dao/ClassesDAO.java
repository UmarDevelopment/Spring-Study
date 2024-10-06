package me.umar.dao;

import me.umar.models.classes.Classe;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClassesDAO {
    Connection con;

    ClassesDAO(){

        String url = "jdbc:mysql://localhost:3306/spring";
        String user = System.getenv("mysql_user");
        String pass = System.getenv("mysql_pass");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("wtf");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("wtf 2");
            throw new RuntimeException(e);
        }
    }

    public void deleteClasse(int id){
        String sql = "DELETE FROM classe WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addClasse(Classe classe){
        String sql = "INSERT INTO classe VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, classe.getId());
            ps.setString(2, classe.getName());
            ps.setString(3, classe.getTeacherEmail());
            ps.setInt(4, classe.getRoomNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Classe getClasse(int id){
        Classe resClasse = null;
        try {
            String sql = "SELECT * FROM classe WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                Classe classe = new Classe();
                classe.setId(res.getInt(1));
                classe.setName(res.getString(2));
                classe.setTeacherEmail(res.getString(3));
                classe.setRoomNumber(res.getInt(4));
                resClasse = classe;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resClasse;
    }

    public List<Classe> getClasses(){
        List<Classe> classes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM classe";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                Classe classe = new Classe();
                classe.setId(res.getInt(1));
                classe.setName(res.getString(2));
                classe.setTeacherEmail(res.getString(3));
                classe.setRoomNumber(res.getInt(4));
                classes.add(classe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classes;
    }
}
