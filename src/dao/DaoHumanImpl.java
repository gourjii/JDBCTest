package dao;
import java.sql.SQLException;

import jdbc.Jdbc;
import objects.Human;


public class DaoHumanImpl implements DaoHuman {
	
	public boolean add(Human human) throws SQLException{
		Jdbc jdbc = new Jdbc();
		String q = "INSERT INTO Humans VALUES ("
				+ human.getId() + ", "
				+ "'"+human.getName()+"'" + ", "
				+ human.getProfession().getId()
				+")";
		//System.out.println(q);
		jdbc.stmt.executeUpdate(q);
		jdbc.conn.close();
		return true;
	}
    
	public boolean remove(Human human) throws SQLException{
		Jdbc jdbc = new Jdbc();
		String q = "DELETE FROM Humans WHERE Id = "
				+ human.getId();
		//System.out.println(q);
		jdbc.stmt.executeUpdate(q);
		jdbc.conn.close();
		return true;
	}
	
	public boolean update(Human human) throws SQLException{
		Jdbc jdbc = new Jdbc();
		//UPDATE TEST SET NAME='Hi' WHERE ID=1;
		String q = "UPDATE Humans SET "
			+ "Name ='" + human.getName()+"', "
			+ "ProfessionID ='" + human.getProfession().getId()+"' "
			+ "WHERE Id=" + human.getId();
		//System.out.println(q);
		jdbc.stmt.executeUpdate(q);
		jdbc.conn.close();
		return true;
    }
    
}
