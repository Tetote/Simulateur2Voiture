package DomaineVoiture;

import java.util.Observable;

/**
 * Voiture.
 */
public class Voiture extends Observable {

    /**
     * MAX VITESSE.
     */
    public static final int MAX_VITESSE = 100;
    /**
     * MIN X.
     */
    public static final int MIN_X = 0;
    /**
     * MAX X.
     */
    public static final int MAX_X = 1000;
    /**
     * MIN Y.
     */
    public static final int MIN_Y = 0;
    /**
     * MAX Y.
     */
    public static final int MAX_Y = 1000;
    /**
     * TOUR COMPLET.
     */
    public static final int TOUR_COMPLET = 360;
    /**
     * TO LEFT.
     */
    public static final int TO_LEFT = 0;
    /**
     * TO DOWN.
     */
    public static final int TO_DOWN = 90;
    /**
     * TO RIGHT.
     */
    public static final int TO_RIGHT = 180;
    /**
     * TO UP.
     */
    public static final int TO_UP = 270;

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
     * @param xPos position of Voiture.
     * @param yPos position of Voiture.
     * @param vitesse vitesse of Voiture.
     */
    public Voiture(final int xPos, final int yPos, final int vitesse) {
        this.x = xPos;
        this.y = yPos;
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
        if (directionEnDegres == TO_LEFT) {
            x += vitesseMetreSeconde;
        } else if (directionEnDegres == TO_RIGHT) {
            x -= vitesseMetreSeconde;
        }

        if (x > MAX_X) {
            x = MAX_X;
        } else if (x < MIN_X) {
            x = MIN_X;
        }
    }

    /**
     *
     */
    private void miseAJourPositionY() {
        if (directionEnDegres == TO_DOWN) {
            y += vitesseMetreSeconde;
        } else if (directionEnDegres == TO_UP) {
            y -= vitesseMetreSeconde;
        }

        if (y > MAX_Y) {
            y = MAX_Y;
        } else if (y < MIN_Y) {
            y = MIN_Y;
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
        if (vitesseMetreSeconde < MAX_VITESSE) {
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
        directionEnDegres = directionEnDegres % TOUR_COMPLET;
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
        directionEnDegres = directionEnDegres % TOUR_COMPLET;
    }

    /**
     *
     */
    public final void tournerAGauche() {
        directionEnDegres += 270;
        directionEnDegres = directionEnDegres % TOUR_COMPLET;
    }
}
