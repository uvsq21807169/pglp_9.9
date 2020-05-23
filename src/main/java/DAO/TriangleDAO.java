package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uvsq.pglp_9_9.formes.Cercle;
import uvsq.pglp_9_9.formes.Rectangle;
import uvsq.pglp_9_9.formes.Triangle;

public class TriangleDAO extends DAO<Triangle>{

	public TriangleDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Triangle create(Triangle obj) {
		try{
			PreparedStatement prepare = connect.prepareStatement(
				"INSERT INTO triangle ( name, centre_x, centre_y, angle_1, angle_2, angle_3) VALUES (?, ?, ?, ?, ?, ?)");
			prepare.setString(1, obj.name);
			prepare.setDouble(2, obj.centre_x);
			prepare.setDouble(3, obj.centre_y);
			prepare.setDouble(4, obj.angle_1);
			prepare.setDouble(5, obj.angle_2);
			prepare.setDouble(6, obj.angle_3);
			boolean result = prepare.execute();
			
			new FormeDAO().create(obj);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Triangle read(String name) {
		try{
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
                    + " FROM triangle where name = '"+name+"'");
			while (rs.next()) {
				
				return new Triangle(rs.getString("name"), Double.parseDouble(rs.getString("centre_x")),
						Double.parseDouble(rs.getString("centre_y")), Double.parseDouble(rs.getString("angle_1")),
						Double.parseDouble(rs.getString("angle_2")),Double.parseDouble(rs.getString("angle_3")));
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Triangle update(Triangle obj) {
		PreparedStatement update = null;
		Triangle nvTriangle = null;
	    try {
	      update = connect.prepareStatement("update triangle set angle_1 = (?), angle_2 = (?),angle_3 = (?),"
	      		+ " centre_x = (?), centre_y = (?) where name = (?) ");

	      update.setDouble(1, obj.angle_1);
	      update.setDouble(2, obj.angle_2);
	      update.setDouble(3, obj.angle_3);
	      update.setDouble(4, obj.centre_x);
	      update.setDouble(5, obj.centre_y);
	      update.setString(6, obj.name);

	      update.executeUpdate();
	      update.close();
	      
	      nvTriangle = read(obj.name);

	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return nvTriangle;
	}

	@Override
	public void delete(String name) {
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("delete from "
	                + " triangle where name = '"+name+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
