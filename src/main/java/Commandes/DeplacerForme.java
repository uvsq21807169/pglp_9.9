package Commandes;

import java.awt.Composite;

import DAO.CarreDAO;
import DAO.CercleDAO;
import DAO.CompositeDAO;
import DAO.RectangleDAO;
import DAO.TriangleDAO;
import uvsq.pglp_9_9.formes.Carre;
import uvsq.pglp_9_9.formes.Cercle;
import uvsq.pglp_9_9.formes.CompositeForme;
import uvsq.pglp_9_9.formes.Forme;
import uvsq.pglp_9_9.formes.Rectangle;
import uvsq.pglp_9_9.formes.Triangle;

public class DeplacerForme implements Commande{
	
	String type;
	String name;
	double x,y;

	public DeplacerForme(String type, String name, double x, double y) {
		this.type = type;
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public void execute() {
		
		
		switch(type) {
			case "cercle":
				CercleDAO DAOcercle= new CercleDAO();
				Cercle cercle = DAOcercle.read(name);
				cercle.move(x, y);
				DAOcercle.update(cercle);
				break;
			case "carre":
				CarreDAO DAOcarre = new CarreDAO();
				Carre carre = DAOcarre.read(name);
				carre.move(x, y);
				DAOcarre.update(carre);
				break;
			case "rectangle":
				RectangleDAO DAOrectangle= new RectangleDAO();
				Rectangle rectangle = DAOrectangle.read(name);
				rectangle.move(x, y);
				DAOrectangle.update(rectangle);
				break;
			case "triangle":
				TriangleDAO DAOtriangle= new TriangleDAO();
				Triangle triangle = DAOtriangle.read(name);
				triangle.move(x, y);
				DAOtriangle.update(triangle);
				break;
			case "composite":
				CompositeDAO DAOcomposite= new CompositeDAO();
				CompositeForme composite = DAOcomposite.read(name);
				composite.move(x, y);
				DAOcomposite.update(composite);
				break;

		}
		
	}

	public void undo() {
		
	}
}
