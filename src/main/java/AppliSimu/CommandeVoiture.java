package AppliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

/**
 * Contient les commandes modifiant le comportement de la voiture.
 */
public class CommandeVoiture extends JPanel implements ActionListener {

    /**
     * Le bouton pour accélérer la voiture.
     */
    private JButton boutonAccelerer;

    /**
     * Le bouton pour faire faire un demi-tour à la voiture.
     */
    private JButton boutonInverserDirection;

    /**
     * Le bouton pour tourner à droite.
     */
    private JButton boutonTournerADroite;

    /**
     * Le bouton pour tourner à gauche.
     */
    private JButton boutonTournerAGauche;

    /**
     * La voiture.
     */
    private Voiture maVoiture;

    /**
     * Initialise une classe CommandeVoiture.
     *
     * @param fenetre La fenêtre utilisée pour l'application.
     * @param voiture La voiture utilisée pour l'application.
     */
    public CommandeVoiture(final JFrame fenetre, final Voiture voiture) {

        super();
        this.setLayout(new FlowLayout());

        boutonAccelerer = new JButton("Accelerer");
        boutonAccelerer.addActionListener(this);
        this.add(boutonAccelerer);

        boutonInverserDirection = new JButton("Changer direction");
        boutonInverserDirection.addActionListener(this);
        this.add(boutonInverserDirection);

        boutonTournerADroite = new JButton("Tourner à droite");
        boutonTournerADroite.addActionListener(this);
        this.add(boutonTournerADroite);

        boutonTournerAGauche = new JButton("Trouner à gauche");
        boutonTournerAGauche.addActionListener(this);
        this.add(boutonTournerAGauche);

        fenetre.add(this);
        this.maVoiture = voiture;
    }


    @Override
    public final void actionPerformed(final ActionEvent event) {
        Object bouton = event.getSource();

        if (bouton == boutonAccelerer) {
            maVoiture.accelerer();
        } else if (bouton == boutonInverserDirection) {
            maVoiture.inverserDirection();
        } else if (bouton == boutonTournerADroite) {
            maVoiture.tournerADroite();
        } else if (bouton == boutonTournerAGauche) {
            maVoiture.tournerAGauche();
        }
    }
}
