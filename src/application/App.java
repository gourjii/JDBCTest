package application;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import org.h2.jdbcx.JdbcConnectionPool;
import java.sql.SQLException;
import jdbc.Jdbc;
//import java.sql.Statement;

import dao.DaoHumanImpl;
import dao.DaoProfessionImpl;
import objects.Human;
import objects.Profession;

/*�������� �������:
������� �������� � ��������������(����� ������������ �� ������� �� jdbc). �������� ������ � �������������(���, �������, �������, ���-�� ��� �� �������).
 ������� ��� ��������� ��� ������ �� ��������. ��� �������: localhost:8080/user?lastname=TestLastname ����� ������������ � �������� TestLastname � ����������� ���������� � �� � ��������. ���� ������ ������������ ���, ������� ��������������� ���������.
�� ������:
�������� ����������� ���������/������������� ������������� ����� ��� ���������
*/

public class App {
	public static void main (String args[]) throws SQLException{
		
		Jdbc jdbc = new Jdbc();
		jdbc.recreateTables();
		
		DaoProfessionImpl dp = new DaoProfessionImpl();
		DaoHumanImpl dh = new DaoHumanImpl();
		
		Profession p1 = new Profession(1, "Java noob");
		Profession p2 = new Profession(2, "Java guru");
		dp.add(p1);
		dp.add(p2);
		dh.add(new Human(1,"Roman", p1));
		dh.add(new Human(2,"Dick", p2));
		dh.add(new Human(3,"Mick", p2));
		
		jdbc.selectAll();
		jdbc.conn.close();
		
		System.out.println("------Find all/by name:------");
		dp.findAll().forEach(s -> System.out.println(s.getName()));
		System.out.println(dp.findByName("Java guru").getId());
	}
}
