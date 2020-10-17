package Informatica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {
    private JPanel panel1;
    private JButton irReservas;
    private JButton irListaVentas;
    private JButton irVentas;
    private JPanel MainPanel;
    private JButton irInventario;

    public Application() {

        irInventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        irReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        irVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        irListaVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Application");
        frame.setContentPane(new Application().MainPanel);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int height = size.height * 2 / 3;
        int width = size.width * 2 / 3;
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }


}
