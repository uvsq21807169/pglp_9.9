package uvsq.pglp_9_9.formes;

public class Carre extends Forme{
	
	
	public double cote;
	

	public Carre(String name, double centre_x, double centre_y, double cote ) {
		
		super(name, "carre", centre_x, centre_y);

		this.name = name;
		this.cote = cote;
	}
	
	public String print(int niveau) {
		String tabulation = "";
		for(int i =0; i < niveau; i++) tabulation += "\t";
		
		String str = tabulation+"-------------------\n"+
				tabulation+"nom : "+name+
			      "\n"+tabulation+"position : ("+centre_x+" , "+centre_y+" )\n"+
			      tabulation+"cote : "+cote+
			      "\n"+tabulation+"------------------\\n";
		return str;
	}

	public void move(double x, double y) {
		centre_x += x;
		centre_y += y;
		
	}


}
