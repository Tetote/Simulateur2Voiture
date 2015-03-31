package AppliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import DomaineRoute.Route;
import DomaineVoiture.Voiture;

public class ProtoSimu {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;

	public static void main(String[] args) {

		final Voiture maVoiture = new Voiture (100, 0, 10);

		final List<Route> mesRoutes = new ArrayList<Route>();
		mesRoutes.add(new Route(0, 285, 505, 30));
		mesRoutes.add(new Route(100, 0, 30, 505));

		IHMVoiture monTriangle = new IHMVoiture(maVoiture, mesRoutes);
		
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				maVoiture.miseAJourPosition();
			}
		});
		
		timerAvancer.start();
		
		while(true){
		}

	}

}
