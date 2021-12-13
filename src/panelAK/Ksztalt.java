package panelAK;

import java.awt.*;

public abstract class Ksztalt {
    protected int x, y;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param x
     * @param y
     */
    public Ksztalt(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     *
     */
    public Ksztalt() {
        this(1,1);
    }

    /**
     * Draw the element in stored coordinates
     * @param g2d graphics to draw on
     */
    public abstract void draw(Graphics2D g2d);

}