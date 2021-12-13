package panelAK;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * klasa główna
 */
public class MyWindow extends JFrame {

    Point uciekajStart = new Point(10,200);
    Point uciekajGdzie = new Point(0,0);

    Random rand = new Random();
    int x, y;
    int ktoraUcieczka=0;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MyWindow okno = new MyWindow();
                    okno.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public MyWindow() throws HeadlessException {
        this("Okno uciekania i rysowania");
    }

    public MyWindow(String title) {
        super(title);
        buildOkineko();
    }

    /**
     * Buduje okienko
     */
    protected void buildOkineko() {
        int width = 700, height = 350;
        setBounds(100, 100, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //główny panel
        JPanel contentPane = buildPanel();

        //panel rysunku
        Kanwa kanwa = new Kanwa();
        kanwa.setBounds(10,10,665,180);
        contentPane.add(kanwa);
        kanwa.setVisible(false);

        //Przyciski
        int bwidth = 100, bheight = 60;

        JButton czyscButton = new JButton("Wyczysc tablice");
        JButton uciekajButton = new JButton("Uciekam");
        JButton resetButton = new JButton("Reset");

        //-- Przycisk uciekania
        {
            contentPane.add(uciekajButton);
            uciekajButton.setBounds(0, 0, bwidth, bheight);
            uciekajButton.setLocation(uciekajStart);

            uciekajButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    kanwa.setVisible(true);
                    czyscButton.setVisible(true);

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                    x = rand.nextInt(width - bwidth);
                    y = rand.nextInt(height - bheight);


                    uciekajGdzie.setLocation(x, y);

                    if (ktoraUcieczka++ < 3)
                        uciekajButton.setLocation(uciekajGdzie);

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        //-- Przycik resetowania
        {
            resetButton.setBounds(120, 200, bwidth, bheight);
            contentPane.add(resetButton);

            resetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    uciekajButton.setLocation(uciekajStart);
                    ktoraUcieczka = 0;
                    kanwa.czysc();
                    kanwa.setVisible(false);
                    czyscButton.setVisible(false);
                }
            });
        }

        //-- Przycisk czyszczenia tablicy
        {
            czyscButton.setBounds(240, 200, bwidth+100, bheight);
            contentPane.add(czyscButton);
            czyscButton.setVisible(false);

            czyscButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    kanwa.czysc();
                }
            });

        }

    }


    /**
     * Buduje główny panel
     *
     * @return zwracam główny panel który właśnie utworzyłam
     */
    protected JPanel buildPanel() {
        JPanel contentPane = new JPanel();
        // Poniżej: Ustawienia panelu
        {
            contentPane.setBorder(new LineBorder(new Color(255, 105, 44), 5, true));
            setContentPane(contentPane);
            contentPane.setLayout(null);
        }
        return contentPane;
    }


}
