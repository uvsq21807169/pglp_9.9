package uvsq.pglp_9_9;

import DAO.DAO;

public class DrawingApp {
	
	DrawingTUI drawing;

	public DrawingApp() {
		
		DAO.connect();
				
		drawing = new DrawingTUI();
		
		run();

	}
	
	public void run() {
		while(true) {
			drawing.nextCommand();	
		}
		
	}
	

}
