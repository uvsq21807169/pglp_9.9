package uvsq.pglp_9_9.formes;

public class Triangle extends Forme{

	
	public double angle_1;
	public double angle_2;
	public double angle_3;

	
	public Triangle(String name, double angle_1, double angle_2, double angle_3, double centre_x, double centre_y ) {
		
		super(name, "triangle", centre_x, centre_y);
		
		this.angle_1 = angle_1;
		this.angle_2 = angle_2;
		this.angle_3 = angle_3;
	}
	
	public String print(int niveau) {
		String tabulation = "";
		for(int i =0; i < niveau; i++) tabulation += "\t";
		
		String str = tabulation+"-------------------\n"+
				tabulation+"nom : "+name+
			      "\n"+tabulation+"position : ("+centre_x+" , "+centre_y+" )\n"+
			      tabulation+"angle 1 : "+angle_1+"\n"+
			      tabulation+"angle 2 : "+angle_2+"\n"+
			      tabulation+"angle 3 : "+angle_3+"\n"+
			      "\n"+tabulation+"------------------\n";
		return str;
	}

	public void move(double x, double y) {
		centre_x += x;
		centre_y += y;
		
	}


}
