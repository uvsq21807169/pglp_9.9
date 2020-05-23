package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uvsq.pglp_9_9.formes.Carre;
import uvsq.pglp_9_9.formes.Cercle;

public class CarreDAO extends DAO<Carre>{

	public CarreDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Carre create(Carre obj) {
		try{
			PreparedStatement prepare = connect.prepareStatement(
				"INSERT INTO carre ( name, centre_x, centre_y, cote) VALUES (?, ?, ?, ?)");
			prepare.setString(1, obj.name);
			prepare.setDouble(2, obj.centre_x);
			prepare.setDouble(3, obj.centre_y);
			prepare.setDouble(4, obj.cote);
			int result = prepare.executeUpdate();
			
			new FormeDAO().create(obj);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Carre read(String name) {
		
		try{
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
                    + " FROM carre where name = '"+name+"'");
			while (rs.next()) {
				
				return new Carre(rs.getString("name"), Double.parseDouble(rs.getString("centre_x")),
						Double.parseDouble(rs.getString("centre_y")), Double.parseDouble(rs.getString("cote")));
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Carre update(Carre obj) {
		PreparedStatement update = null;
		Carre nvCarre = null;
	    try {
	      update = connect.prepareStatement("update carre set cote = (?), centre_x = (?), centre_y = (?) where name = (?) ");

	      update.setDouble(1, obj.cote);
	      update.setDouble(2, obj.centre_x);
	      update.setDouble(3, obj.centre_y);
	      update.setString(4, obj.name);

	      update.executeUpdate();
	      update.close();
	      
	      nvCarre = read(obj.name);

	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return nvCarre;
	}

	@Override
	public void delete(String name) {
		try {
			Statement stmt = connect.createStatement();
			int rs = stmt.executeUpdate("delete from "
	                + " carre where name = '"+name+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
