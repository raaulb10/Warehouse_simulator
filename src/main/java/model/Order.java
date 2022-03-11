package model;
/**
 * This class represent the order table from the sql database
 * All the names of the fields are the same as the names of the columns from the table
 * the class also contains getters and setter for each field an 2 constructors one with arguments and one without
 */
public class Order {

    private int id_order;
    private int id_client;
    private int id_product;
    private int quantity;

    public Order() {
        id_client = 0;
        id_order = 0;
        id_product = 0;
        quantity = 0;
    }

    public Order(int id_order, int id_client, int id_product, int quantity) {
        this.id_order = id_order;
        this.id_product = id_product;
        this.id_client = id_client;
        this.quantity = quantity;
    }

    public int getId_order() {
        return id_order;
    }
    public void setId_order(int id_order) {
        this.id_order = id_order;
    }
    public int getId_product() {
        return id_product;
    }
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
    public int getId_client() {
        return id_client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}