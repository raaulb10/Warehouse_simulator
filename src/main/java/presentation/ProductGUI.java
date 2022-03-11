package presentation;

import business.BusinessLogicClass;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class is the user interface that contains the Product operation
 * It contains 3 fields that correspond with the fields from the Product class
 * It has 5 buttons. 4 of them are for the operations : add, edit, delete and view and one of them is a back button that opens the main interface
 */
public class ProductGUI {
    private final BusinessLogicClass<Product> bussines=new BusinessLogicClass<>(Product.class);
    private JTable table = new JTable();
    public ProductGUI(){
        JFrame frame=new JFrame("Product");
        JPanel panel =new JPanel();


        frame.setBounds(200,300,350,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        panel.setBackground(new Color(35, 193, 161));


        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(10, 50, 80, 25);
        panel.add(labelID);

        JTextField textproductID = new JTextField();
        textproductID.setBounds(100, 50, 150, 25);
        panel.add(textproductID);


        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(10, 80, 80, 25);
        panel.add(labelName);

        JTextField textName = new JTextField();
        textName.setBounds(100, 80, 150, 25);
        panel.add(textName);

        JLabel labelquantity = new JLabel("Quantity:");
        labelquantity.setBounds(10, 110, 80, 25);
        panel.add(labelquantity);

        JTextField textquantity = new JTextField();
        textquantity.setBounds(100, 110, 150, 25);
        panel.add(textquantity);


        JButton butAdd = new JButton("Add new product");
        butAdd.setBounds(100,170,150,25);
        butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bussines.insertRow(new Product(Integer.parseInt(textproductID.getText()),textName.getText(),Integer.parseInt(textquantity.getText())));
                bussines.updateTable(table);
            }
        });
        panel.add(butAdd);

        JButton butEdit = new JButton("Edit product");
        butEdit.setBounds(100,200,150,25);
        butEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bussines.updateRow(new Product(Integer.parseInt(textproductID.getText()),textName.getText(),Integer.parseInt(textquantity.getText())));
                bussines.updateTable(table);
            }
        });
        panel.add(butEdit);


        JButton butDelete = new JButton("Delete product");
        butDelete.setBounds(100,230,150,25);
        butDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bussines.deleteRow(Integer.parseInt(textproductID.getText()));
                bussines.updateTable(table);
            }
        });
        panel.add(butDelete);


        JButton butView = new JButton("View products");
        butView.setBounds(100,260,150,25);
        butView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JScrollPane sp ;
                JFrame viewProducts = new JFrame("Products Table");
                viewProducts.setVisible(true);
                viewProducts.setBounds(555,530,700,500);

                JPanel viewPanelProduct = new JPanel();
                viewPanelProduct.setBackground(new Color(35, 193, 161));
                viewPanelProduct.setLayout(null);
                viewProducts.add(viewPanelProduct);

                //JTable table = new JTable();
                table.setBounds(20, 80, 500, 250);
                bussines.updateTable(table);
                sp = new JScrollPane(table);
                sp.setBounds(20, 60, 600, 350);
                sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                viewPanelProduct.add(sp);
            }
        });
        panel.add(butView);


        JButton butBack = new JButton("BACK");
        butBack.setBounds(100,290,150,25);
        butBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI log=new GUI();
                frame.dispose();
            }
        });
        panel.add(butBack);


        frame.add(panel);
        frame.setVisible(true);
    }

}
