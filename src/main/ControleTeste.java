package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


// 19 21 22 28 29 30 

public class ControleTeste {
	private Controle controle;
	@Before
	public void padrao()
	{
		controle = new Controle();
	}
	
	@Test
	public void teste10()
	{
		boolean setH;
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.getAlerta();
		assertFalse(setH);
		setH = controle.temperatura.setH();
		assertFalse(setH);
	}
	
	@Test
	public void teste12()
	{
		boolean setH;
		
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.resetAlerta();
		assertFalse(setH);
		setH = controle.temperatura.setH();
		assertFalse(setH);
	}
	
	public void teste13()
	{
		boolean setH;
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.resetAlerta();
		assertFalse(setH);
		setH = controle.temperatura.setAlerta();
		assertTrue(setH);
	}
	
	public void teste19()
	{
		
		
		
		boolean setH;
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.setAlerta();
		assertTrue(setH);
		setH = controle.temperatura.resetAlerta();
		assertTrue(setH);
	}
	
	public void teste21()
	{
		
		//set h set alerta setR setAlerta
		
		boolean setH;
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.setAlerta();
		assertFalse(setH);
		controle.temperatura.setR(1);
		assertFalse(setH);
		setH = controle.temperatura.setAlerta();
		assertTrue(setH);
	}
	
	public void teste22()
	{
		
		boolean setH;
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.setAlerta();
		assertTrue(setH);
		setH = controle.temperatura.resetH();
		assertTrue(setH);
		setH = controle.temperatura.setH();
		assertTrue(setH);
		
	}
	
	public void teste28()
	{
		
		//set h set alerta set alerta set alerta
		
		boolean setH;
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.resetAlerta();
		assertFalse(setH);
		setH = controle.temperatura.setAlerta();
		assertTrue(setH);
	}

	public void teste29()
	{
		
		//set h set alerta getAlerta setH
		boolean setH;
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.resetAlerta();
		assertFalse(setH);
		setH = controle.temperatura.setAlerta();
		assertTrue(setH);
	}
	
	public void teste30()
	{
		
		//set h set alerta getAlerta setAlerta
		boolean setH;
		setH = controle.temperatura.setH();
		assertTrue(setH);
		setH = controle.temperatura.resetAlerta();
		assertFalse(setH);
		setH = controle.temperatura.setAlerta();
		assertTrue(setH);
	}
	

	
}