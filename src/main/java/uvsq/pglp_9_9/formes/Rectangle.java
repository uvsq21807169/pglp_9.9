package uvsq.pglp_9_9.formes;

public class Rectangle extends Forme{

	
	public double longuer;
	public double largeur;
	
	
	public Rectangle(String name, double longuer, double largeur, double centre_x, double centre_y) {
		
		super(name, "rectangle", centre_x, centre_y);

		this.largeur = largeur;
		this.longuer = longuer;

	}
	
	public String print(int niveau) {
		String tabulation = "";
		for(int i =0; i < niveau; i++) tabulation += "\t";
		
		String str = tabulation+"-------------------\n"+
				tabulation+"nom : "+name+
			      "\n"+tabulation+"position : ("+centre_x+" , "+centre_y+" )\n"+
			      tabulation+"largeur : "+largeur+
			      tabulation+"longuer : "+longuer+
			      "\n"+tabulation+"------------------\n";
	return str;
	}

	public void move(double x, double y) {
		centre_x += x;
		centre_y += y;
		
	}


}
