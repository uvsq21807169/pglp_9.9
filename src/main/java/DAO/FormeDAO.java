package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uvsq.pglp_9_9.formes.Carre;
import uvsq.pglp_9_9.formes.Cercle;
import uvsq.pglp_9_9.formes.Forme;
import uvsq.pglp_9_9.formes.Rectangle;
import uvsq.pglp_9_9.formes.Triangle;

public class FormeDAO extends DAO<Forme>{

	public FormeDAO() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Forme create(Forme obj) {
		try{
			PreparedStatement prepare = (PreparedStatement) connect.prepareStatement(
				"INSERT INTO forme ( name, type) VALUES (?, ?)");
			prepare.setString(1, obj.name);
			prepare.setString(2, obj.type);

			boolean i = prepare.execute();
			
			prepare.close();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Forme read(String name) {
		
		
		try{
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
                    + " FROM forme where name = '"+name+"'");
			while (rs.next()) {
				
				switch(rs.getString("type")) {
				case "cercle":
					return new CercleDAO().read(name);
				case "carre":
					return new CarreDAO().read(name);
				case "rectangle":
					return new RectangleDAO().read(name);
				case "triangle":
					return new TriangleDAO().read(name);
				case "composite":
					return new CompositeDAO().read(name);
				}
            }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Forme update(Forme obj) {

		return null;
	}

	@Override
	public void delete(String name) {
		try {
			Statement stmt = connect.createStatement();
			int rs = stmt.executeUpdate("delete from "
	                + " forme where name = '"+name+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
