package me.umar.dao;

import me.umar.dao.mappers.ClasseMapper;
import me.umar.models.classes.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClassesDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ClassesDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteClasse(int id){
        jdbcTemplate.update("DELETE FROM classe WHERE id = ?", id);
    }

    public void addClasse(Classe classe){
        jdbcTemplate.update(
                "INSERT INTO classe VALUES (?, ?, ?, ?)",
                classe.getId(),
                classe.getName(),
                classe.getTeacherEmail(),
                classe.getRoomNumber()
        );
    }

    public Classe getClasse(int id){
        return jdbcTemplate.query("SELECT * FROM classe WHERE id = ?", new Object[]{id}, new ClasseMapper())
                .stream().findAny().orElse(null);
    }

    public List<Classe> getClasses(){
        return jdbcTemplate.query("SELECT * FROM classe", new ClasseMapper());
    }
}
