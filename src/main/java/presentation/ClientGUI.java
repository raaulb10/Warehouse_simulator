package presentation;

import business.BusinessLogicClass;
import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the user interface that contains the Client operation
 * It contains 4 fields that correspond with the fields from the Client class
 * It has 5 buttons. 4 of them are for the operations : add, edit, delete and view and one of them is a back button that opens the main interface
 */
public class ClientGUI {
    private final BusinessLogicClass<Client> bussines = new BusinessLogicClass<>(Client.class);
    private JTable table = new JTable();
    public ClientGUI() {
        JFrame frame = new JFrame("Client");
        JPanel panel = new JPanel();


        frame.setBounds(200, 300, 350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        panel.setBackground(new Color(35, 193, 161));


        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(10, 50, 80, 25);
        panel.add(labelID);

        JTextField textClientID = new JTextField();
        textClientID.setBounds(100, 50, 150, 25);
        panel.add(textClientID);


        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(10, 80, 80, 25);
        panel.add(labelName);

        JTextField textName = new JTextField();
        textName.setBounds(100, 80, 150, 25);
        panel.add(textName);


        JLabel labelAdress = new JLabel("Adress:");
        labelAdress.setBounds(10, 110, 80, 25);
        panel.add(labelAdress);

        JTextField textAdress = new JTextField();
        textAdress.setBounds(100, 110, 150, 25);
        panel.add(textAdress);


        JLabel labelPhonenr = new JLabel("Phone nr:");
        labelPhonenr.setBounds(10, 140, 80, 25);
        panel.add(labelPhonenr);

        JTextField textPhonenr = new JTextField();
        textPhonenr.setBounds(100, 140, 150, 25);
        panel.add(textPhonenr);


        JButton butAdd = new JButton("Add new client");
        butAdd.setBounds(100, 170, 150, 25);
        butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bussines.insertRow(new Client(Integer.parseInt(textClientID.getText()), textName.getText(), textAdress.getText(), textPhonenr.getText()));
                bussines.updateTable(table);
            }
        });
        panel.add(butAdd);

        JButton butEdit = new JButton("Edit client");
        butEdit.setBounds(100, 200, 150, 25);
        butEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bussines.updateRow(new Client(Integer.parseInt(textClientID.getText()), textName.getText(), textAdress.getText(), textPhonenr.getText()));
                bussines.updateTable(table);
            }
        });
        panel.add(butEdit);


        JButton butDelete = new JButton("Delete client");
        butDelete.setBounds(100, 230, 150, 25);
        butDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bussines.deleteRow(Integer.parseInt(textClientID.getText()));
                bussines.updateTable(table);
            }

        });
        panel.add(butDelete);


        JButton butView = new JButton("View clients");
        butView.setBounds(100, 260, 150, 25);
        butView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JScrollPane sp;
                JFrame viewClient = new JFrame("Clients Table");
                viewClient.setVisible(true);
                viewClient.setBounds(555, 30, 700, 500);

                JPanel viewPanelClient = new JPanel();
                viewPanelClient.setBackground(new Color(35, 193, 161));
                viewPanelClient.setLayout(null);
                viewClient.add(viewPanelClient);

                //JTable table = new JTable();
                table.setBounds(20, 80, 500, 250);
                bussines.updateTable(table);
                sp = new JScrollPane(table);
                sp.setBounds(20, 60, 600, 350);
                sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                viewPanelClient.add(sp);
            }
        });
        panel.add(butView);


        JButton butBack = new JButton("BACK");
        butBack.setBounds(100, 290, 150, 25);
        butBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI log = new GUI();
                frame.dispose();
            }
        });
        panel.add(butBack);


        frame.add(panel);
        frame.setVisible(true);
    }
}

