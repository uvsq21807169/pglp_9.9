package uvsq.pglp_9_9.formes;

import java.util.ArrayList;

import Commandes.DeplacerForme;

public class CompositeForme extends Forme{
	
	public ArrayList<Forme> childForme = new ArrayList<Forme>() ;
	
	public CompositeForme(String name, double x, double y) {
		
		super(name, "composite", x, y);

	}
	
	public void add(Forme forme) {
		
		childForme.add(forme);
		
	}
	
	public void addWithMove(Forme forme) {
		if(this.childForme.size() == 0) {
			this.centre_x = forme.centre_x;
			this.centre_y = forme.centre_y;
		}
		else {
			this.centre_x += (forme.centre_x - this.centre_x)/2;
			this.centre_y += (forme.centre_y - this.centre_y)/2;
		}
		add(forme);
	}

	public String print(int niveau) {
		String tabulation = "";
		for(int i =0; i < niveau; i++) tabulation += "\t";
		
		String str = tabulation+"composite name : "+name+
					 "\n"+tabulation+"composite position : ("+centre_x+" , "+centre_y+" )\n";
		for(int i = 0; i < childForme.size(); i++) {
			str += tabulation+"Forme "+(i+1);
			str += "\n"+ childForme.get(i).print(niveau+1);
		}
		str += "\n";
		return str;
	}

	public void move(double x, double y) {
		centre_x += x;
		centre_y += y;	
		for(Forme child : childForme ) {
			new DeplacerForme(child.type, child.name,  x,  y).execute();
		}
	}
	
	
	
	
	
	
	
	
	

}
