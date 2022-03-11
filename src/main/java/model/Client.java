package model;
/**
 * This class represent the client table from the sql database
 * All the names of the fields are the same as the names of the columns from the table
 * the class also contains getters and setter for each field an 2 constructors one with arguments and one without
 */
public class Client {

    private int id_client;
    private String name;
    private String adress;
    private String phone_nr;

    public Client() {
        id_client = 0;
        name = "";
        adress = "";
        phone_nr = "";
    }

    public Client(int id_client, String name, String adress, String phone_nr) {
        this.id_client = id_client;
        this.name = name;
        this.adress = adress;
        this.phone_nr = phone_nr;
    }

    public int getId_client() {
        return id_client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getPhone_nr() {
        return phone_nr;
    }
    public void setPhone_nr(String phone) {
        this.phone_nr = phone;
    }

}