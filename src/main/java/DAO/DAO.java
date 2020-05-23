package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public abstract class DAO <T>{
	
	private static String dbURL = "jdbc:derby:jdbcDB;";//create=true";
		
	public static Connection connect = null;
	
	public DAO() {	
	
	}
	
	public static void connect() {
		try {
			
			//Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			connect = DriverManager.getConnection(dbURL);
			
			/*
			try {
				connect.createStatement().executeUpdate("create table  "
						+ "cercle( name varchar(20), centre_x double, centre_y double, rayon double ) ");
				connect.createStatement().executeUpdate("create table  "
						+ "carre( name varchar(20), centre_x double, centre_y double, cote double ) ");
				connect.createStatement().executeUpdate("create table  "
						+ "rectangle( name varchar(20), centre_x double, centre_y double, largeur double,"
						+ " longuer double ) ");
				connect.createStatement().executeUpdate("create table  "
						+ "triangle( name varchar(20), centre_x double, centre_y double, angle_1 double,"
						+ " angle_2 double, angle_3 double ) ");
				connect.createStatement().executeUpdate("create table  "
						+ "forme( name varchar(20), type varchar(20)) ");		
				connect.createStatement().executeUpdate("create table  "
						+ "composite( name varchar(20), centre_x double, centre_y double) ");	
				connect.createStatement().executeUpdate("create table  "
						+ "composition( composite varchar(20), composant varchar(20)) ");	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract T create(T obj);
	public abstract T read(String id);
	public abstract T update(T obj);
	public abstract void delete (String name);
}