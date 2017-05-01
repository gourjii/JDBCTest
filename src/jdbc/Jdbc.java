package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	
	public Connection conn;
	public Statement stmt;
	
	public Jdbc () throws SQLException{
	this.conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	this.stmt = this.conn.createStatement();
	}

	public void select () throws SQLException{
		ResultSet rs = this.stmt.executeQuery("SELECT * FROM Humans");
		while(rs.next()){
			System.out.println(rs.getObject(1) + ": " 
				+ rs.getObject(2) + ": " 
				+ rs.getObject(3));
			}
		rs = this.stmt.executeQuery("SELECT * FROM Professions");
		while(rs.next()){
			System.out.println(rs.getObject(1) + ": " 
				+ rs.getObject(2));
			}
	}
	
	public void recreateTables() throws SQLException{
		this.stmt.executeUpdate("DROP TABLE IF EXISTS Humans");
		this.stmt.executeUpdate("DROP TABLE IF EXISTS Professions");
		this.stmt.executeUpdate("CREATE TABLE Professions "
				+ "(Id INT PRIMARY KEY"
				+ ", Name VARCHAR)");
		this.stmt.executeUpdate("CREATE TABLE Humans "
				+ "(Id INT PRIMARY KEY, "
				+ "Name VARCHAR, "
				+ "ProfessionId INT REFERENCES Professions(ID))");
		//this.stmt.executeUpdate("INSERT INTO professions VALUES (1, 'Java noob')");
		//this.stmt.executeUpdate("INSERT INTO professions VALUES (2, 'Java guru')");
		//this.stmt.executeUpdate("INSERT INTO Humans VALUES (1, 'Roman', 1)");
		//this.stmt.executeUpdate("INSERT INTO Humans VALUES (2, 'John', 2)");
		//this.stmt.executeUpdate("INSERT INTO Humans VALUES (3, 'Ada', 1)");
	}
	
	
}

