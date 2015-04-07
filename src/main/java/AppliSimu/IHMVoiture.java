package AppliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import DomaineRoute.Route;
import DomaineVoiture.Voiture;

/**
 * Réalise l'interface graphique de l'application.
 */
public class IHMVoiture extends JFrame implements Observer {

    /**
     * paramètre de conversion de distance (1 pixel tout les 2 mètres).
     */
    private static final double PARAMATRE_CONVERSION_METRES_PIXELS = 0.5;

    /**
     * La voiture de l'application.
     */
    private final Voiture maVoiture;

    /**
     * Les commandes implémentées pour la voiture.
     */
    private CommandeVoiture maCommandeVoiture;

    /**
     * La liste des routes.
     */
    private List<Route> mesRoutes;

    /**
     * La taille de la fenêtre.
     */
    private static final int SIZE = 505;

    /**
     * Initialise l'interface graphique de l'application.
     */
    private void initGraphique() {
        this.setTitle("Simulateur de Voiture");
        this.setSize(SIZE, SIZE);

        this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

        this.setVisible(true);
    }

    /**
     * Initialise une classe IHMVoiture.
     * @param voiture La voiture de l'application.
     * @param routes Les routes de l'application.
     */
    public IHMVoiture(final Voiture voiture, final List<Route> routes) {
        super();
        this.maVoiture = voiture;
        this.mesRoutes = routes;
        voiture.addObserver(this);
        initGraphique();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Initialise une classe IHMVoiture sans voiture ni routes.
     */
    public IHMVoiture() {
        super();
        initGraphique();
        this.maVoiture = null;
        this.mesRoutes = null;
    }

    /**
     * Convertit les mètres en pixels.
     * @param d La distance en mètre.
     * @return La distance en pixel.
     */
    public final int calculerPositionPixels(final int d) {
        return (int) (PARAMATRE_CONVERSION_METRES_PIXELS * d);
    }

    @Override
    public final void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }

    @Override
    public final void paint(final Graphics contexteGraphique) {
        super.paint(contexteGraphique);
        dessinerRoute(contexteGraphique);
        dessinerVoiture(contexteGraphique);
    }

    /**
     * Dessine les routes de l'application.
     * @param contexteGraphique La fenêtre graphique.
     */
    private void dessinerRoute(final Graphics contexteGraphique) {
        if (mesRoutes == null) {
            return;
        }

        contexteGraphique.setColor(Color.BLACK);
        for (Route route : mesRoutes) {
            contexteGraphique.fillRect(route.getX(), route.getY(),
                    route.getWidth(), route.getHeight());
        }
    }

    /**
     * Dessine la voiture de l'application.
     * @param contexteGraphique La fenêtre graphique.
     */
    private void dessinerVoiture(final Graphics contexteGraphique) {
        if (maVoiture == null) {
            return;
        }

        int xMetres = maVoiture.getX();
        int yMetres = maVoiture.getY();
        int xPixel = calculerPositionPixels(xMetres);
        int yPixel = calculerPositionPixels(yMetres);
        contexteGraphique.setColor(Color.RED);
        contexteGraphique.fillRect(xPixel, yPixel, 30, 15);
    }
}
