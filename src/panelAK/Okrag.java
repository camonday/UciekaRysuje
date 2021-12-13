package panelAK;

import java.awt.*;

public class Okrag extends Ksztalt{

    /**
     * @param x - horizontal
     * @param y - vertical
     */
    public Okrag(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        int w = 40;
        int h = 60;
        g2d.fillOval(x-Math.round(w /2), y-Math.round(h /2), w, h);
    }

}
