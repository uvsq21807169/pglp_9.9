package Commandes;

import java.lang.reflect.Array;
import java.util.ArrayList;

import DAO.CompositeDAO;
import DAO.FormeDAO;
import DAO.TriangleDAO;
import uvsq.pglp_9_9.formes.CompositeForme;
import uvsq.pglp_9_9.formes.Forme;

public class CreerComposite extends CreerForme{
	
	ArrayList<String> composant;

	public CreerComposite( String name, ArrayList<String> composant) {
		super("composite",name,0, 0, null);
		
		this.composant = composant;
	}
	
	public void execute() {
		
		CompositeForme composite = new CompositeForme(name, 0, 0);
		for(int i = 0; i < composant.size();i++) {
			Forme forme = new FormeDAO().read(composant.get(i));
			composite.addWithMove(forme);
		}
		
		new CompositeDAO().create(composite);
		
	}
	
}
