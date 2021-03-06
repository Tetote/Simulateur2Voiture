package DomaineVoiture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestVoiture {
	
	private Voiture maVoiture;
	
	@Before
	public void setUp(){
		maVoiture = new Voiture (100, 100, 10);
	}
	
	@Test
	public void  testEvolutionXenFonctionVitesseSurUnTopSeconde() {
		maVoiture.setDirection(0);
		maVoiture.miseAJourPosition();
		
		assertEquals(110, maVoiture.getX());
	}

	@Test
	public void  testEvolutionYenFonctionVitesseSurUnTopSeconde() {
		maVoiture.setDirection(90);
		maVoiture.miseAJourPosition();

		assertEquals(110, maVoiture.getY());
	}
	
	@Test
	public void testAcceleration(){
		
		maVoiture.accelerer();
		
		assertEquals(20, maVoiture.getVitesse());
	}
	
	@Test
	public void testAccelerationLimite() {
		
		maVoiture.setVitesse(100);
		maVoiture.accelerer();
		assertEquals(100, maVoiture.getVitesse());
		
	}

	@Test
	public void testChangementDeSens() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		assertEquals(180, maVoiture.getDirection());
		
	}
	
	@Test
	public void testChangementDeSensEtEvolutionDeX() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(90, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteHaute() {
		
		maVoiture.setVitesse(1000);
		maVoiture.miseAJourPosition();
		assertEquals(1000, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteBasse() {
		
		maVoiture.setVitesse(1000);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(0, maVoiture.getX());
		
	}

	@Test
	public void testTournerADroite() {
		maVoiture.setDirection(0);
		maVoiture.tournerADroite();
		assertEquals(90, maVoiture.getDirection());
	}

	@Test
	public void testTournerAGauche() {
		maVoiture.setDirection(0);
		maVoiture.tournerAGauche();
		assertEquals(270, maVoiture.getDirection());
	}
	
}
