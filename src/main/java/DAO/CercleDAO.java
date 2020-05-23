package DAO;

import java.sql.*;

import Commandes.CreerForme;
import uvsq.pglp_9_9.formes.Carre;
import uvsq.pglp_9_9.formes.Cercle;
import uvsq.pglp_9_9.formes.Forme;

public class CercleDAO extends DAO<Cercle>{

	public CercleDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cercle create(Cercle obj) {
		try{
			PreparedStatement prepare = (PreparedStatement) connect.prepareStatement(
				"INSERT INTO cercle ( name, centre_x, centre_y, rayon) VALUES (?, ?, ?, ?)");
			prepare.setString(1, obj.name);
			prepare.setDouble(2, obj.centre_x);
			prepare.setDouble(3, obj.centre_y);
			prepare.setDouble(4, obj.rayon);

			boolean i = prepare.execute();
			
			new FormeDAO().create(obj);
			
			prepare.close();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Cercle read(String name) {
		
		
		try{
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
                    + " FROM cercle where name = '"+name+"'");
			while (rs.next()) {
				return new Cercle(rs.getString("name"), Double.parseDouble(rs.getString("centre_x")),
						Double.parseDouble(rs.getString("centre_y")), Double.parseDouble(rs.getString("rayon")));
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cercle update(Cercle obj) {
		
		PreparedStatement update = null;
		Cercle nvCercle = null;
	    try {
	      update = connect.prepareStatement("update cercle set rayon = (?), centre_x = (?), centre_y = (?) where name = (?) ");

	      update.setDouble(1, obj.rayon);
	      update.setDouble(2, obj.centre_x);
	      update.setDouble(3, obj.centre_y);
	      update.setString(4, obj.name);

	      update.executeUpdate();
	      update.close();
	      
	      nvCercle = read(obj.name);

	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return nvCercle;
	}

	@Override
	public void delete(String name) {
		try {
			Statement stmt = connect.createStatement();
			int rs = stmt.executeUpdate("delete from "
	                + " cercle where name = '"+name+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
