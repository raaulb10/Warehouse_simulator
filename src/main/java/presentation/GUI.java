package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the first user interface that opens when we run the application
 * The interface contains 3 buttons, one for clients, one for products and one for clients
 * By pressing any button the main interface will disappear and the interface selected will be opened
 */
public class GUI {
    private static JButton Clientbtn;
    private static JButton Productbtn;
    private static JButton Orderbtn;

    public GUI() {
        JFrame frame = new JFrame("GUI");
        JPanel panel = new JPanel();

        frame.setBounds(200, 300, 700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        panel.setBackground(new Color(35, 193, 161));

        Clientbtn = new JButton("Client");
        Clientbtn.setBounds(80, 100, 150, 80);
        Clientbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientGUI log = new ClientGUI();
                frame.dispose();
            }
        });
        panel.add(Clientbtn);

        Productbtn = new JButton("Product");
        Productbtn.setBounds(250, 100, 150, 80);
        Productbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductGUI log = new ProductGUI();
                frame.dispose();
            }
        });
        panel.add(Productbtn);

        Orderbtn = new JButton("Order");
        Orderbtn.setBounds(430, 100, 150, 80);
        Orderbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderGUI log = new OrderGUI();
                frame.dispose();
            }
        });
        panel.add(Orderbtn);

        frame.add(panel);
        frame.setVisible(true);
    }
}
