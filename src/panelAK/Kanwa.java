package panelAK;

import jdk.javadoc.doclet.Taglet;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class Kanwa extends JPanel implements MouseInputListener, KeyListener{

    Point b = null;
    Ksztalt k = null;
    boolean hasEscaped = false;
    boolean draw = true;

    public Kanwa() {
        setFocusable(true);
        setBorder(new LineBorder(new Color(9, 92, 225), 14, true));
        setLayout(null);
        setBackground(Color.black);



        addMouseListener(this);
        addKeyListener(this);
    }

    public void czysc(){
        k = null;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        b = getMousePosition();
        hasEscaped = false;
        draw = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        grabFocus();
        if (hasEscaped) draw=false;
        //jesli uzytkownik uciekł kursorem z pola przed podniesieniem myszy
        // to nie rysuje (WCAG 2.1 wytyczna 2.5.2)

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hasEscaped = true;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        try {
            g2d.setColor(Color.white);
            if(k!=null)
            k.draw(g2d);
        } finally {
            g2d.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char znak = e.getKeyChar();

        switch (znak){
            case 'o':
                k = new Okrag( (int) b.getX(), (int) b.getY());
                break;

            case 'k':
                k = new Kwadrat((int) b.getX(), (int) b.getY());

        }
        if(draw)
            repaint();
    }
}

