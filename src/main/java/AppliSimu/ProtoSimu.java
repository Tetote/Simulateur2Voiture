package AppliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import DomaineRoute.Route;
import DomaineVoiture.Voiture;

/**
 * Correspond au "main" de l'application.
 */
public final class ProtoSimu {

    /**
     * Constructeur privé pour éviter une instanciation inutile de la classe.
     */
    private ProtoSimu() {

    }

    /**
     * Nom explicite.
     */
    public static final int DUREE_UNE_SECONDE_EN_MILLI_SECONDES = 1000;

    /**
     * Le main de l'application.
     * @param args Les arguments donnés en paramètres.
     */
    public static void main(final String[] args) {

        final Voiture maVoiture = new Voiture(100, 600, 10);

        final List<Route> mesRoutes = new ArrayList<Route>();
        mesRoutes.add(new Route(0, 285, 505, 30));
        mesRoutes.add(new Route(100, 0, 30, 505));

        IHMVoiture monTriangle = new IHMVoiture(maVoiture, mesRoutes);

        Timer timerAvancer = new Timer(
                DUREE_UNE_SECONDE_EN_MILLI_SECONDES, new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                maVoiture.miseAJourPosition();
            }
        });

        timerAvancer.start();

        while (true) {

        }
    }
}
