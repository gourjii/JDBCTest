package dao;
import java.sql.SQLException;
import java.util.List;

import objects.Profession;

public interface DaoProfession extends DaoObj<Profession>{
    List<Profession> findAll() throws SQLException;
    Profession findByName(String name) throws SQLException;
}
