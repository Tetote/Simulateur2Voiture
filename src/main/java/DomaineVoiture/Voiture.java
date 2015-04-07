package DomaineVoiture;

import java.util.Observable;

/**
 * Voiture
 */
public class Voiture extends Observable {

    /**
     * x position of Voiture.
     */
    private int x;
    /**
     * y position of Voiture.
     */
    private int y;
    /**
     * vitesse of Voiture (m/s).
     */
    private int vitesseMetreSeconde;
    /**
     * direction of Voiture (degree).
     */
    private int directionEnDegres;

    /**
     *
     * @param x position of Voiture.
     * @param y position of Voiture.
     * @param vitesse vitesse of Voiture.
     */
    public Voiture(final int x, final int y, final int vitesse) {
        this.x = x;
        this.y = y;
        this.vitesseMetreSeconde = vitesse;
        this.directionEnDegres = 0;
    }

    /**
     *
     */
    public final void miseAJourPosition() {
        miseAJourPositionX();
        miseAJourPositionY();
        notificationObservateur();
    }

    /**
     *
     */
    private void miseAJourPositionX() {
        if (directionEnDegres == 0) {
            x += vitesseMetreSeconde;
        } else if (directionEnDegres == 180) {
            x -= vitesseMetreSeconde;
        }

        if (x > 1000) {
            x = 1000;
        } else if (x < 0) {
            x = 0;
        }
    }

    /**
     *
     */
    private void miseAJourPositionY() {
        if (directionEnDegres == 90) {
            y += vitesseMetreSeconde;
        } else if (directionEnDegres == 270) {
            y -= vitesseMetreSeconde;
        }

        if (y > 1000) {
            y = 1000;
        } else if (y < 0) {
            y = 0;
        }
    }

    /**
     *
     */
    private void notificationObservateur() {
        this.setChanged();
        this.notifyObservers();
    }

    /**
     *
     * @return x
     */
    public final int getX() {
        return x;
    }

    /**
     *
     * @return y
     */
    public final int getY() {
        return y;
    }

    /**
     *
     */
    public final void accelerer() {
        if (vitesseMetreSeconde < 100) {
            vitesseMetreSeconde += 10;
        }
    }

    /**
     *
     * @return vitesse
     */
    public final Object getVitesse() {
        return vitesseMetreSeconde;
    }

    /**
     *
     * @param vitesse vitesse
     */
    public final void setVitesse(final int vitesse) {
        vitesseMetreSeconde = vitesse;
    }

    /**
     *
     * @param angleDirection direction
     */
    public final void setDirection(final int angleDirection) {
        this.directionEnDegres = angleDirection;
    }

    /**
     *
     */
    public final void inverserDirection() {
        directionEnDegres += 180;
        directionEnDegres = directionEnDegres % 360;
    }

    /**
     *
     * @return direction
     */
    public final Object getDirection() {
        return directionEnDegres;
    }

    /**
     *
     */
    public final void tournerADroite() {
        directionEnDegres += 90;
        directionEnDegres = directionEnDegres % 360;
    }

    /**
     *
     */
    public final void tournerAGauche() {
        directionEnDegres += 270;
        directionEnDegres = directionEnDegres % 360;
    }
}
