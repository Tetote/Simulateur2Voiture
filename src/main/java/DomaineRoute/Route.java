package DomaineRoute;

public class Route {
    /**
     *
     */
    private int x;
    /**
     *
     */
    private int y;
    /**
     *
     */
    private int width;
    /**
     *
     */
    private int height;

    /**
     *
     * @param posX x position of Route.
     * @param posY y position of Route.
     * @param widthRoute width of Route.
     * @param heightRoute height of Route.
     */
    public Route(final int posX, final int posY,
                 final int widthRoute, final int heightRoute) {
        this.x = posX;
        this.y = posY;
        this.width = widthRoute;
        this.height = heightRoute;
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
     * @return width
     */
    public final int getWidth() {
        return width;
    }

    /**
     *
     * @return height
     */
    public final int getHeight() {
        return height;
    }
}
