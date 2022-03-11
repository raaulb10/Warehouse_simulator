package model;
/**
 * This class represent the product table from the sql database
 * All the names of the fields are the same as the names of the columns from the table
 * the class also contains getters and setter for each field an 2 constructors one with arguments and one without
 */
public class Product {

    private int id_product;
    private String name;
    private int quantity;

    public Product() {
        id_product = 0;
        name = "";
        quantity = 0;
    }

    public Product(int id_product, String name, int quantity) {
        this.id_product = id_product;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId_product() { return id_product; }
    public void setId_product(int id_product) { this.id_product = id_product; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

}