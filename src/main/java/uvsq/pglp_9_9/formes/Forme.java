package uvsq.pglp_9_9.formes;

public abstract class Forme {
	
	public String name;
	public String type;
	public double centre_x;
	public double centre_y;
	
	public Forme(String name, String type, double centre_x, double centre_y) {
		
		this.name = name;
		this.type = type;
		this.centre_x = centre_x;
		this.centre_y = centre_y;
		
	}

	public abstract String print(int niveau);
	
	public abstract void move(double x, double y);


}