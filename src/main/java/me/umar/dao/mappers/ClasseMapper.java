package me.umar.dao.mappers;

import me.umar.models.classes.Classe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasseMapper implements RowMapper<Classe> {
    @Override
    public Classe mapRow(ResultSet resultSet, int i) throws SQLException {
        Classe classe = new Classe();
        classe.setId(resultSet.getInt(1));
        classe.setName(resultSet.getString(2));
        classe.setTeacherEmail(resultSet.getString(3));
        classe.setRoomNumber(resultSet.getInt(4));
        return classe;
    }
}
