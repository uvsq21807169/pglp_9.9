package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uvsq.pglp_9_9.formes.Carre;
import uvsq.pglp_9_9.formes.Rectangle;
import uvsq.pglp_9_9.formes.Triangle;

public class RectangleDAO extends DAO<Rectangle>{

	public RectangleDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rectangle create(Rectangle obj) {
		try{
			PreparedStatement prepare = connect.prepareStatement(
				"INSERT INTO rectangle ( name, centre_x, centre_y, largeur, longuer ) VALUES (?, ?, ?, ?, ?)");
			prepare.setString(1, obj.name);
			prepare.setDouble(2, obj.centre_x);
			prepare.setDouble(3, obj.centre_y);
			prepare.setDouble(4, obj.largeur);
			prepare.setDouble(5, obj.longuer);
			int result = prepare.executeUpdate();
			
			new FormeDAO().create(obj);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Rectangle read(String name) {
		try{
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
                    + " FROM rectangle where name = '"+name+"'");
			while (rs.next()) {
				
				return new Rectangle(rs.getString("name"), Double.parseDouble(rs.getString("centre_x")),
						Double.parseDouble(rs.getString("centre_y")), Double.parseDouble(rs.getString("largeur")),
						Double.parseDouble(rs.getString("longuer")));
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Rectangle update(Rectangle obj) {
		PreparedStatement update = null;
		Rectangle nvRectangle = null;
	    try {
	      update = connect.prepareStatement("update triangle set longuer = (?), largeur = (?), "
	      		+ " centre_x = (?), centre_y = (?) where name = (?) ");

	      update.setDouble(1, obj.longuer);
	      update.setDouble(2, obj.largeur);
	      update.setDouble(3, obj.centre_x);
	      update.setDouble(4, obj.centre_y);
	      update.setString(5, obj.name);

	      update.executeUpdate();
	      update.close();
	      
	      nvRectangle = read(obj.name);

	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return nvRectangle;
	}

	@Override
	public void delete(String name) {
		try {
			Statement stmt = connect.createStatement();
			int rs = stmt.executeUpdate("delete from "
	                + " regtangle where name = '"+name+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
