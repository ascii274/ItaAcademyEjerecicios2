package com.ascii274.practica.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.ascii274.practica.bean.Empleat;



public class BaseDatosJDBC {
	
	private Connection connection;
	
	public BaseDatosJDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conex = "jdbc:mysql://localhost:3306/empleats_database";
			this.connection = DriverManager.getConnection(conex,"root","@MysDol10");
			
		} catch (Exception e) {
			System.out.println("Error al conectar" + e.getMessage());

		}
	}
	

	
	public void borrar(int id) {
		String sql = "DELETE from empleats where id=" + id;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			System.out.println("Se ha borrado el empleado.\n" + preparedStatement.toString());
		} catch (Exception e) {
			System.out.println("Error al borrar el empleado con el id: " + id);
		}
	}
	
	public void modificar(Empleat empleat) {
		String sql = "UPDATE empleats set id=?, nom=?, faena=? where id=?";
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,empleat.getId());
			preparedStatement.setString(2,empleat.getNom());
			preparedStatement.setString(3,empleat.getFaena());	
			preparedStatement.setInt(4, empleat.getId());
			System.out.println("Se ha modificado el empleado.\n" + preparedStatement.toString());
			preparedStatement.executeUpdate();			
		} catch (Exception e) {
			System.out.println("Error al modificar: " + e.getMessage() );
		}
	}
	
	public void insertar(Empleat empleat) {
		//String sql ="INSERT INTO empleats ( id, nom, faena) VALUES (?,?,?)";
		String sql ="INSERT INTO empleats (nom, faena) VALUES (?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, empleat.getId());
			preparedStatement.setString(1, empleat.getNom());
			preparedStatement.setString(2, empleat.getFaena());
			System.out.println("Empleado insertado.\n" + preparedStatement.toString());	
			preparedStatement.executeUpdate();
				
			
		} catch (Exception e) {
			System.out.println("Error al donar d'alta un empleat " + e.getMessage());
			System.out.println(sql);

		}
	}
	
	public Empleat getEmpleat(int id) {
		Empleat empleat=null;
		String sql="SELECT * FROM empleats WHERE id=" + id;
		
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			ResultSet rSet = statement.getResultSet();
			rSet.next();
			empleat = new Empleat(rSet.getInt(1), rSet.getString(2),rSet.getString(3));						
		} catch (Exception e) {
			System.out.println("Error al escoger el empleado " + e.getMessage());
		}
		return empleat;
	}
	
	public ArrayList<Empleat> getEmpleats(){
		ArrayList<Empleat> empleats = new ArrayList<Empleat>();
		String sql = "SELECT * From empleats";
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			ResultSet rSet = statement.getResultSet();
			while(rSet.next()) {
				Empleat empleat = new Empleat(rSet.getInt(1),rSet.getString(2),rSet.getString(3));
				empleats.add(empleat);
			}
			
		} catch (Exception e) {
			System.out.println("Error en llegir la Base de Dddes:" + e.getMessage());

		}
		return empleats;
	}
	
//	public int getIdMax() {
//		int idMax=0;
//		String sql = "SELECT count(id) from empleats"; 
//		Statement statement = connection.createStatement();
//		statement.execute(sql);
//		ResultSet rSet = statement.getResultSet();
//		idMax= rSet.next();
//		
//		return idMax;
//	}
	

}


























