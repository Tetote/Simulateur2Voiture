package AppliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import DomaineRoute.Route;
import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer {
	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private CommandeVoiture maCommandeVoiture;
	private List<Route> mesRoutes;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture, List<Route> mesRoutes) {
		super();
		this.maVoiture = maVoiture;
		this.mesRoutes = mesRoutes;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
		this.mesRoutes = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);

		dessinerRoute(contexteGraphique);

		contexteGraphique.setColor(Color.red);
		dessinerVoiture(contexteGraphique);
	}

	private void dessinerRoute(Graphics contexteGraphique) {
		contexteGraphique.setColor(Color.BLACK);
		for (Route route : mesRoutes) {
			contexteGraphique.fillRect(route.getX(), route.getY(),
					route.getWidth(), route.getHeight());
		}
	}

	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
		contexteGraphique.fillRect(xPixel, 300, 30, 15);
	}
	
}
