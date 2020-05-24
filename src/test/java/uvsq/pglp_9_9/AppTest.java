package uvsq.pglp_9_9;

import static org.junit.Assert.*;
import org.junit.Test;

import uvsq.pglp_9_9.formes.Carre;
import uvsq.pglp_9_9.formes.Cercle;
import uvsq.pglp_9_9.formes.CompositeForme;
import uvsq.pglp_9_9.formes.Rectangle;
import uvsq.pglp_9_9.formes.Triangle;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	  @Test
	  public void CarreTest() {

	      Carre c = new Carre("c1", 0, 0, 20 );
	      assertEquals(c.centre_x, 0, 0.1);
	      assertEquals(c.centre_y, 0, 0.1);
	      
	      c.move(10, 20);
	      
	      assertEquals(c.centre_x, 10, 0.1);
	      assertEquals(c.centre_y, 20, 0.1);
	  }
	  
	  @Test
	  public void RectangleTest() {

	      Rectangle c = new Rectangle("c1", 5, 6, 0, 0 );
	      
	      assertEquals(c.centre_x, 0, 0.1);
	      assertEquals(c.centre_y, 0, 0.1);
	      
	      c.move(10, 20);
	      
	      assertEquals(c.centre_x, 10, 0.1);
	      assertEquals(c.centre_y, 20, 0.1);
	  }
	  
	  @Test
	  public void CercleTest() {

		  Cercle c = new Cercle("c1", 0, 0, 20 );
	      assertEquals(c.centre_x, 0, 0.1);
	      assertEquals(c.centre_y, 0, 0.1);
	      
	      c.move(10, 20);
	      
	      assertEquals(c.centre_x, 10, 0.1);
	      assertEquals(c.centre_y, 20, 0.1);
	  }
	  
	  @Test
	  public void TriangleTest() {

		  Triangle c = new Triangle("c1", 20, 18, 17, 0, 0 );
	      assertEquals(c.centre_x, 0, 0.1);
	      assertEquals(c.centre_y, 0, 0.1);
	      
	      c.move(10, 20);
	      
	      assertEquals(c.centre_x, 10, 0.1);
	      assertEquals(c.centre_y, 20, 0.1);
	  }
	  
	  @Test
	  public void CompositeTest() {

	      CompositeForme comp = new CompositeForme("comp", 0, 0 );
	      
		  Cercle c1 = new Cercle("c1", 5, 6, 90 );
		  Cercle c2 = new Cercle("c2", 1, 2, 20 );
		  
		  comp.add(c1);
		  comp.add(c2);
		  System.out.println(c1.centre_x);
		  
	      assertEquals(c1.centre_x, 5, 0.1);
	      assertEquals(c1.centre_y, 6, 0.1);
	      
	      assertEquals(c2.centre_x, 1, 0.1);
	      assertEquals(c2.centre_y, 2, 0.1);
	      
	      /*
	      comp.move(10, 20);
	     
	      assertEquals(c1.centre_x, 15, 0.1);
	      assertEquals(c1.centre_y, 26, 0.1);
	      
	      assertEquals(c2.centre_x, 11, 0.1);
	      assertEquals(c2.centre_y, 21, 0.1);
		  */
	  }
}
