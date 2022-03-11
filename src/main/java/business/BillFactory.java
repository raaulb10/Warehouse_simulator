package business;

import model.Client;
import model.Order;
import model.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * This class generates a bill in format .txt
 */
public class BillFactory {
    /**
     * The constructor has 3 parameters: the client that made the order, the product that was ordered and the order that was made
     * It gets the current date and time and it writes the important information in Bill.txt
     */
    public BillFactory(Client client, Product product, Order order) {


        try {
            FileWriter fileWriter = new FileWriter("Bill.txt");

            String towrite;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");
            LocalDateTime ordertime = LocalDateTime.now();
            towrite = dtf.format(ordertime);
            towrite += "\n\nOrder Number:\t " + order.getId_order() + "\nProduct:\t " + product.getName() + "\nQuantity: \t" + order.getQuantity() + "\nName:\t\t" + client.getName() + "\nAddress:\t" + client.getAdress();
            fileWriter.write(towrite);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
