package presentation;

import business.BillFactory;
import business.BusinessLogicClass;
import model.Client;
import model.Order;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class is the user interface that contains the Order operation
 * It contains 3 fields that correspond with the fields from the Order class
 * It has 2 buttons. One of them is to add an order with the information that are in the fields, and a button that goes back to the main interface
 * If the quantity of the products ordered exceeds the quantity of the products in the database a pop up will appear
 */
public class OrderGUI {
    private final BusinessLogicClass<Order> bussinesOrder=new BusinessLogicClass<>(Order.class);
    private final BusinessLogicClass<Client> bussinesClient=new BusinessLogicClass<>(Client.class);
    private final BusinessLogicClass<Product> bussinesProduce=new BusinessLogicClass<>(Product.class);
    BillFactory bill;
    public OrderGUI(){
        JFrame frame=new JFrame("Order");
        JPanel panel =new JPanel();


        frame.setBounds(200,300,340,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        panel.setBackground(new Color(35, 193, 161));


        JLabel labelIDClient = new JLabel("ID client:");
        labelIDClient.setBounds(10, 50, 80, 25);
        panel.add(labelIDClient);

        JTextField textClientID = new JTextField();
        textClientID.setBounds(100, 50, 150, 25);
        panel.add(textClientID);


        JLabel labelIDProdus = new JLabel("ID product:");
        labelIDProdus.setBounds(10, 80, 80, 25);
        panel.add(labelIDProdus);

        JTextField textIDProdus = new JTextField();
        textIDProdus.setBounds(100, 80, 150, 25);
        panel.add(textIDProdus);


        JLabel labelquantity = new JLabel("Quantity:");
        labelquantity.setBounds(10, 110, 80, 25);
        panel.add(labelquantity);

        JTextField textquantity = new JTextField();
        textquantity.setBounds(100, 110, 150, 25);
        panel.add(textquantity);


        JScrollPane sp1 ;
        JFrame viewProducts = new JFrame("Products Table");
        viewProducts.setVisible(true);
        viewProducts.setBounds(555,530,700,500);

        JPanel viewPanelProduct = new JPanel();
        viewPanelProduct.setBackground(new Color(35, 193, 161));
        viewPanelProduct.setLayout(null);
        viewProducts.add(viewPanelProduct);

        JTable products = new JTable();
        products.setBounds(20, 80, 500, 250);
        bussinesProduce.updateTable(products);
        sp1 = new JScrollPane(products);
        sp1.setBounds(20, 60, 600, 350);
        sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        viewPanelProduct.add(sp1);

        JScrollPane sp;
        JFrame viewClient = new JFrame("Clients Table");
        viewClient.setVisible(true);
        viewClient.setBounds(555, 30, 700, 500);

        JPanel viewPanelClient = new JPanel();
        viewPanelClient.setBackground(new Color(35, 193, 161));
        viewPanelClient.setLayout(null);
        viewClient.add(viewPanelClient);

        JTable clients = new JTable();
        clients.setBounds(20, 80, 500, 250);
        bussinesClient.updateTable(clients);
        sp = new JScrollPane(clients);
        sp.setBounds(20, 60, 600, 350);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        viewPanelClient.add(sp);


        JButton butAdd = new JButton("Add new order");
        butAdd.setBounds(100,140,150,25);
        butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textClientID.getText().equals("")||textIDProdus.getText().equals("")||textquantity.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please insert data");
                else {
                    Order neworder = new Order(bussinesOrder.getmaxId(), Integer.parseInt(textClientID.getText()), Integer.parseInt(textIDProdus.getText()), Integer.parseInt(textquantity.getText()));
                    Product produs = bussinesProduce.findbyId(neworder.getId_product());
                    Client client = bussinesClient.findbyId(neworder.getId_client());
                    if (produs.getQuantity() < neworder.getQuantity())
                        JOptionPane.showMessageDialog(null, "Not enough products");
                    else {
                        bill = new BillFactory(client, produs, neworder);
                        produs.setQuantity(produs.getQuantity() - neworder.getQuantity());
                        bussinesProduce.updateRow(produs);
                        bussinesOrder.insertRow(neworder);
                        bussinesProduce.updateTable(products);
                        bussinesClient.updateTable(clients);
                    }
                }
            }
        });
        panel.add(butAdd);



        JButton butBack = new JButton("BACK");
        butBack.setBounds(100,170,150,25);
        butBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI log=new GUI();
                frame.dispose();
                viewProducts.dispose();
                viewClient.dispose();
            }
        });
        panel.add(butBack);


        frame.add(panel);
        frame.setVisible(true);
    }

}
