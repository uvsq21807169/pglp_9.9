package uvsq.pglp_9_9;

import java.util.ArrayList;
import java.util.Scanner;

import Commandes.CreerComposite;
import Commandes.CreerForme;
import Commandes.DeplacerForme;
import DAO.CarreDAO;
import DAO.CercleDAO;
import DAO.CompositeDAO;
import DAO.FormeDAO;
import DAO.TriangleDAO;
import uvsq.pglp_9_9.formes.Carre;
import uvsq.pglp_9_9.formes.Cercle;
import uvsq.pglp_9_9.formes.Forme;
import uvsq.pglp_9_9.formes.Triangle;

public class DrawingTUI {
	
	Scanner sc;

	public DrawingTUI() {
		sc = new Scanner(System.in);
	}
	
	public void nextCommand() {
		String line ="";
		if(sc.hasNextLine())
		    line = sc.nextLine();
		
		if(line.contains("=")) {
			if(line.contains("(")) {
				createForme(line);
				
			}
			else {
				createComposite(line);
			}
		}
		else if(line.contains("move")){
			moveForme(line);
		}
		else if(line.contains("show")){
			showForme(line);
		}
		
	}
	
	private void affiche() {
		
	}
	
	public void createForme(String line) {
		//c1 = Cercle((0, 0), 50)
		String[] args =  line.split("=");
		String name = args[0].trim();

		String[] rightArg = args[1].split("\\(\\(");
		String forme = rightArg[0].trim();
		
		String[] tab = rightArg[1].split(",");
		
		Double x = Double.parseDouble(tab[0].trim());
		Double y = Double.parseDouble(tab[1].split("\\)")[0].trim());
		
		ArrayList<Double> params = new ArrayList<Double>();
		
		tab[tab.length-1] = tab[tab.length-1].split("\\)")[0].trim();
		
		for(int i = 2; i <tab.length; i++) {
			params.add(Double.parseDouble(tab[i].trim()));	
		}
		
	
		CreerForme create = new CreerForme(forme.toLowerCase(), name, x, y, params);
		
		create.execute();

		//System.out.println((forme+ name+ Integer.parseInt(x)+ Integer.parseInt(y)+params.get(0) ));
		
		CarreDAO c = new CarreDAO();
		Carre c1 = c.read("car1");
		if(c1 != null ) {
			System.out.println(c1.print(0));
		}
		
					
	}
	
	public void createComposite(String line) {
		// comp = c1 + c2
		
		String[] args =  line.split("=");
		
		String name = args[0].trim();
		String[] params = args[1].split("\\+");
		
		ArrayList<String> composant = new ArrayList<>();
		for(int i = 0; i< params.length; i++) {
			composant.add(params[i].trim()); 
		}
		
		new CreerComposite(name, composant).execute();
				
	}
	
	public void moveForme(String line) {
		//move(c1, (10, 20))
		String[] args =  line.split("\\(");
		String name = args[1].trim().split(",")[0].trim();
		
		String coord = args[2].split("\\)")[0];
		
		Double x = Double.parseDouble(coord.split(",")[0].trim());
		Double y = Double.parseDouble(coord.split(",")[1].trim());
		
		String type = new FormeDAO().read(name).type;
		
		new DeplacerForme(type, name, x, y).execute();
		
	}
	
	public void showForme(String line) {
		
		String name =  line.split("show")[1].trim();
		
		Forme forme = new FormeDAO().read(name);
		
		System.out.println(forme.print(0));

	}
	
	

}
