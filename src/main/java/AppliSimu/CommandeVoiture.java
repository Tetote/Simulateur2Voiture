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
     * La voiture.
     */
    private Voiture maVoiture;

    /**
     * Ajoute les commandes à la fenêtre placée en paramètre.
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

        fenetre.add(this);
        this.maVoiture = voiture;
    }


    @Override
    public final void actionPerformed(final ActionEvent event) {
        Object bouton = event.getSource();
        if (bouton == boutonAccelerer) {
            maVoiture.accelerer();
        } else {
            maVoiture.inverserDirection();
        }
    }
}
