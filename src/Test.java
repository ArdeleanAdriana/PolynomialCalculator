import static org.junit.Assert.*;

import java.util.ArrayList;

public class Test {

	Model model = new Model();
	//public Test(Model model) {
	//	this.model=model;
	//}
	
	@org.junit.Test
	public void testAdunare() {
		Polinom p1=new Polinom("");
		Polinom p2=new Polinom("");
		Polinom p3=new Polinom("");
		Polinom rez=new Polinom("");
		p1.add(new Monom(1,1)); 
		p1.add(new Monom(2,2)); 
		p2.add(new Monom(1,2)); 
		rez.add(new Monom(3,2)); 
		rez.add(new Monom(1,1)); 
		p3=model.adunare(p1,p2); 
		rez.sortByPower();
		String result = model.print(rez);
		String polinom3 =  model.print(p3);
		assertEquals(result,polinom3); 
		
		p1=new Polinom("");
		p2=new Polinom("");
		rez=new Polinom("");
		p1.add(new Monom(2,1));
		p2.add(new Monom(2,3));
		rez.add(new Monom(2,3));
		rez.add(new Monom(2,1));
		rez.sortByPower();
		p3=model.adunare(p1,p2);
		result = model.print(rez);
	    polinom3 =  model.print(p3);
	    assertEquals(result,polinom3); 
	}
	
	@org.junit.Test
	public void testScadere() 
	{
	
		Polinom p1=new Polinom("");
		Polinom p2=new Polinom("");
		Polinom p3=new Polinom("");
		Polinom rez=new Polinom("");
		p1.add(new Monom(4,1));
		p1.add(new Monom(2,3));
		p2.add(new Monom(2,5));
		p2.add(new Monom(2,2));
		rez.add(new Monom(4,1));
		rez.add(new Monom(2,3));
		rez.add(new Monom(-2,5));
		rez.add(new Monom(-2,2));
		p3=model.scadere(p1,p2);
		rez.sortByPower();
		String result = model.print(rez);
	    String polinom3 =  model.print(p3);
	    assertEquals(result,polinom3); 
	}
	@org.junit.Test
	public void testInmultire() {
		Polinom p1=new Polinom("");
		Polinom p2=new Polinom("");
		Polinom p3=new Polinom("");
		Polinom rez=new Polinom("");
		p1.add(new Monom(3,2));
		p1.add(new Monom(2,1));
		p2.add(new Monom(2,1));
		rez.add(new Monom(6,3));
		rez.add(new Monom(4,2));
		p3=model.inmultire(p1, p2);
		rez.sortByPower();
		String result = model.print(rez);
	    String polinom3 =  model.print(p3);
	    assertEquals(result,polinom3); 
	}
	
	@org.junit.Test
	public void testImpartire() {
		Polinom p1=new Polinom("");
		Polinom p2=new Polinom("");
		Polinom rez=new Polinom("");
		Polinom rest=new Polinom("");
		p1.add(new Monom(1,3));
		p1.add(new Monom(-2,2));
		p1.add(new Monom(6,1));
		p1.add(new Monom(-5,0));
		p2.add(new Monom(1,2));
		p2.add(new Monom(-1,0));
		rez.add(new Monom(1,1));
		rez.add(new Monom(-2,0));
		rest.add(new Monom(7,1));
		rest.add(new Monom(-7,0));
		
		ArrayList<Polinom> rezultat = model.impartire(p1, p2);
		
		rezultat.get(0).sortByPower();
		rezultat.get(1).sortByPower();
		String result = model.print(rez);
		String restt = model.print(rest);
	    String polinom3 =  model.print(rezultat.get(0));
	    String polinom4 =  model.print(rezultat.get(1));
	    assertEquals(result,polinom3); 
	    assertEquals(restt,polinom4); 
	}
	
	@org.junit.Test
	public void testDer() {
		Polinom p1=new Polinom("");
		Polinom p2=new Polinom("");
		Polinom rez=new Polinom("");
		p1.add(new Monom(1,1));
		p1.add(new Monom(2,2));
		rez.add(new Monom(4,1));
		rez.add(new Monom(1,0));
		p2=model.derivare(p1);
		rez.sortByPower();
		String result = model.print(rez);
	    String polinom2 =  model.print(p2);
	    assertEquals(result,polinom2); 
		
	}

	@org.junit.Test
	public void testInt() {
		Polinom p1=new Polinom("");
		Polinom p2=new Polinom("");
		Polinom rez=new Polinom("");
		p1.add(new Monom(2,1));
		p1.add(new Monom(3,2));
		rez.add(new Monom(1,3));
		rez.add(new Monom(1,2));
		p2=model.integrare(p1);
		rez.sortByPower();
		String result = model.print(rez);
	    String polinom2 =  model.print(p2);
	    assertEquals(result,polinom2); 
		

	}


}
