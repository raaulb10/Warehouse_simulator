package business;

import dao.DataAccessClass;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * This class contains the business logic of the application
 * The methods in this class are generic methods that can be called by any class from the model package
 * The class contains an object from the model package and an object of type DataAccess
 */
public class BusinessLogicClass<T> {

    private final Class<T> currentClass;
    private final DataAccessClass<T> dao;

    /**
     * The constructor of this class also creates a DataAccess object with the currentClass type
     */
    public BusinessLogicClass(Class<T> currentClass) {
        this.currentClass = currentClass;
        dao = new DataAccessClass<>(currentClass);
    }

    /**
     * This method creates the Header of a JTable object
     * and then populates the table using the data from teh database using reflection techniques
     */
    public void updateTable(JTable table) {
        Object[] Head;
        Field[] fields = currentClass.getDeclaredFields();
        Head = new Object[fields.length];
        for (int i = 0; i < fields.length; i++) {
            String n = fields[i].getName();
            Head[i] = n;
        }
        DefaultTableModel tableModel = new DefaultTableModel(Head, 0);
        ArrayList<T> list = dao.findAll();
        for (T current : list) {
            tableModel.addRow(dao.getObjectData(current));
        }
        table.setModel(tableModel);
    }

    public void insertRow(T obj) {
        dao.insert(obj);
    }
    public void updateRow(T obj) {
        dao.update(obj);
    }
    public void deleteRow(int id) {
        dao.delete(id);
    }
    public T findbyId(int id) {
        return dao.getbyId(id);
    }
    public int getmaxId() {
        return dao.getmaxId();
    }

}

