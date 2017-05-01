package dao;
import java.util.List;

import objects.Profession;

public interface DaoProfession extends DaoObj<Profession>{
    List<Profession> findAll();
    Profession findByName(String name);
}
