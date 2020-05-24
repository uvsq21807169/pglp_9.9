package uvsq.pglp_9_9.formes;

public class Triangle extends Forme{

	
	public double cote_1;
	public double cote_2;
	public double cote_3;

	
	public Triangle(String name, double cote_1, double cote_2, double cote_3, double centre_x, double centre_y ) {
		
		super(name, "triangle", centre_x, centre_y);
		
		this.cote_1 = cote_1;
		this.cote_2 = cote_2;
		this.cote_3 = cote_3;
	}
	
	public String print(int niveau) {
		String tabulation = "";
		for(int i =0; i < niveau; i++) tabulation += "\t";
		
		String str = tabulation+"-------------------\n"+
				tabulation+"nom : "+name+
			      "\n"+tabulation+"position : ("+centre_x+" , "+centre_y+" )\n"+
			      tabulation+"cote 1 : "+cote_1+"\n"+
			      tabulation+"cote 2 : "+cote_2+"\n"+
			      tabulation+"cote 3 : "+cote_3+"\n"+
			      "\n"+tabulation+"------------------\n";
		return str;
	}

	public void move(double x, double y) {
		centre_x += x;
		centre_y += y;
		
	}


}
