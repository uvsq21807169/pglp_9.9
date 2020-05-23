package uvsq.pglp_9_9.formes;

public class Cercle extends Forme{
	
	public double rayon;

	public Cercle(String name, double centre_x, double centre_y, double rayon) {
		
		super(name, "cercle", centre_x, centre_y);

		this.rayon = rayon;
	}
	
	public String print(int niveau) {
		String tabulation = "";
		for(int i =0; i < niveau; i++) tabulation += "\t";
		
		String str = tabulation+"-------------------\n"+
				tabulation+"nom : "+name+
				      "\n"+tabulation+"position : ("+centre_x+" , "+centre_y+" )\n"+
				      tabulation+"rayon : "+rayon+
				      "\n"+tabulation+"------------------\n";
		return str;
	}

	public void move(double x, double y) {
		centre_x += x;
		centre_y += y;
	}


}
