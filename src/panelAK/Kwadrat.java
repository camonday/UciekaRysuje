package panelAK;

import java.awt.*;

public class Kwadrat extends Ksztalt{

    /**
     * @param x - horizontal
     * @param y - vertical
     */
    public Kwadrat(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        int w = 40;
        g2d.fillRect(x-Math.round(w /2), y-Math.round(w /2), w, w);
    }

}
