package Commandes;

import java.util.ArrayList;

import DAO.CarreDAO;
import DAO.CercleDAO;
import DAO.RectangleDAO;
import DAO.TriangleDAO;
import uvsq.pglp_9_9.formes.Carre;
import uvsq.pglp_9_9.formes.Cercle;
import uvsq.pglp_9_9.formes.CompositeForme;
import uvsq.pglp_9_9.formes.Rectangle;
import uvsq.pglp_9_9.formes.Triangle;

public class CreerForme implements Commande{
	String forme;
	String name;
	double x;
	double y;
	ArrayList<Double> params;

	public CreerForme(String forme, String name, double x, double y, ArrayList<Double> params ) {
		this.forme = forme;
		this.name = name;
		this.x = x;
		this.y = y;
		this.params = params;
	}


	public void execute() {
		
		switch(forme) {
			case "cercle":
				Cercle cercle = new Cercle(name, x, y, params.get(0));
				new CercleDAO().create(cercle);
				break;
			case "carre":
				Carre carre = new Carre(name, x, y, params.get(0));
				new CarreDAO().create(carre);
				break;
			case "rectangle":
				Rectangle rectangle = new Rectangle(name, params.get(0), params.get(1), x, y);
				new RectangleDAO().create(rectangle);
				break;
			case "triangle":
				Triangle triangle = new Triangle(name, params.get(0), params.get(1), params.get(2), x, y);
				new TriangleDAO().create(triangle);
				break;
			
		}
		
	}
	
	public void undo() {
		
	}

}
