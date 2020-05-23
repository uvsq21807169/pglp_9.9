package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uvsq.pglp_9_9.formes.Cercle;
import uvsq.pglp_9_9.formes.CompositeForme;
import uvsq.pglp_9_9.formes.Forme;

public class CompositeDAO extends DAO<CompositeForme>{

	public CompositeDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CompositeForme create(CompositeForme obj) {
		try{
			PreparedStatement prepare = (PreparedStatement) connect.prepareStatement(
				"INSERT INTO composite ( name, centre_x, centre_y) VALUES (?, ?, ?)");
			prepare.setString(1, obj.name);
			prepare.setDouble(2, obj.centre_x);
			prepare.setDouble(3, obj.centre_y);
			boolean i = prepare.execute();
			
			for(Forme forme : obj.childForme) {
				
				prepare = (PreparedStatement) connect.prepareStatement(
						"INSERT INTO composition ( composite, composant) VALUES (?, ?)");
				prepare.setString(1, obj.name);
				prepare.setString(2, forme.name);
				 
				prepare.execute();
				
				new FormeDAO().create(obj);

			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public CompositeForme read(String name) {
		
		
		try{
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
                    + " FROM composite where name = '"+name+"'");
			while (rs.next()) {
				Statement stmt2 = connect.createStatement();
				ResultSet rs2 = stmt2.executeQuery("SELECT *"
	                    + " FROM composition where composite = '"+name+"'");
				ArrayList<String> composant = new ArrayList<>();
				while (rs2.next()) {
					composant.add(rs2.getString("composant"));
				}
				
				CompositeForme composite = new CompositeForme(rs.getString("name"), 
						Double.parseDouble(rs.getString("centre_x")),
						Double.parseDouble(rs.getString("centre_y")));
				
				for(String formeName : composant) {
					Forme forme = new FormeDAO().read(formeName);
					
					composite.add(forme);
				}
				
				return composite;
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CompositeForme update(CompositeForme obj) {

		PreparedStatement update = null;
		CompositeForme nvComposite = null;
	    try {
	      update = connect.prepareStatement("update composite set centre_x = (?), centre_y = (?) where name = (?) ");

	      update.setDouble(1, obj.centre_x);
	      update.setDouble(2, obj.centre_y);
	      update.setString(3, obj.name);

	      update.executeUpdate();
	      update.close();
	      
	      nvComposite = read(obj.name);

	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return nvComposite;
	}

	@Override
	public void delete(String name) {
		try {
			Statement stmt = connect.createStatement();
			int rs = stmt.executeUpdate("delete from "
	                + " composite where name = '"+name+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
