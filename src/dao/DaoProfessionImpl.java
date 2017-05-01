package dao;
import java.sql.SQLException;
import java.util.List;

import jdbc.Jdbc;
import objects.Profession;

public class DaoProfessionImpl implements DaoProfession{
	public boolean add(Profession profession) throws SQLException{
		Jdbc jdbc = new Jdbc();
		String q = "INSERT INTO Professions VALUES ("
				+ profession.getId() + ", "
				+ "'"+profession.getName()+"'"
				+")";
		//System.out.println(q);
		jdbc.stmt.executeUpdate(q);
		jdbc.conn.close();
		return true;
	}
    
	public boolean remove(Profession profession) throws SQLException{
		Jdbc jdbc = new Jdbc();
		String q = "DELETE FROM Professions WHERE Id = "
				+ profession.getId();
		//System.out.println(q);
		jdbc.stmt.executeUpdate(q);
		jdbc.conn.close();
		return true;
	}
	
	public boolean update(Profession profession) throws SQLException{
		Jdbc jdbc = new Jdbc();
		//UPDATE TEST SET NAME='Hi' WHERE ID=1;
		String q = "UPDATE Professions SET "
			+ "Name ='" + profession.getName()+"' "
			+ "WHERE Id=" + profession.getId();
		//System.out.println(q);
		jdbc.stmt.executeUpdate(q);
		jdbc.conn.close();
		return true;
    }
	
    public List<Profession> findAll(){
    	return null;
    }
    
    public Profession findByName(String name){
    	return null;
    }
}
