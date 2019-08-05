import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Polynomial1Test {

	Polynomial1 p;
	
	@Before
	public void setUp() throws Exception 
	{
		p = new Polynomial1(3);
	}

	@Test
	public void testGetDegree()
	{
		assertEquals("Line 20", 3, p.getDegree());
		
	}

	@Test
	public void testgetCoefficient()
	{
		assertTrue(p.getCoefficient(0) == 0);
	}
	
	@Test
	public void testSetCoefficient() 
	{
		p.setCoefficient(0, 3);
		p.setCoefficient(1, 5);
		p.setCoefficient(2, 0);
		p.setCoefficient(3, 2);
		
		assertTrue(p.getCoefficient(2) == 0);
	}

	@Test
	public void testEvaluate() 
	{
		p.setCoefficient(0, 3);
		p.setCoefficient(1, 5);
		p.setCoefficient(2, 0);
		p.setCoefficient(3, 2);
		
		assertTrue(p.evaluate(7) == 724);
	}

}
