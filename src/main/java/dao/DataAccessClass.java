package dao;

import connection.ConnectionFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is used to communicate data with the database.
 * This is a generified class, and it's meant to be used the classes mapped to the database.
 * It uses Java Reflection to generate the statements.
 */
public class DataAccessClass<T> {

    private final Class<T> currentClass;

    public DataAccessClass(Class<T> currentClass) {
        this.currentClass = currentClass;
    }

    /**
     * This method creates and returns an arraylist that contains the elements from the table
     * It is used to display the contents of the table using reflection techniques
     */
    public ArrayList<T> findAll() {
        ArrayList<T> toReturn = new ArrayList<>();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement selectStatement = null;
        ResultSet resultSet = null;
        try {
            String selectStatementString = "SELECT * FROM " + ConnectionFactory.DBNAME + "." + currentClass.getSimpleName();
            selectStatement = connection.prepareStatement(selectStatementString);
            resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Object[] field_values = getObjectData(currentClass.getDeclaredFields(), resultSet);
                T currentObj = currentClass.getDeclaredConstructor().newInstance();
                setObjectData(currentObj, currentClass.getDeclaredFields(), field_values);
                toReturn.add(currentObj);
            }

        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException throwable) {
            throwable.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(selectStatement);
            ConnectionFactory.close(connection);
        }

        return toReturn;
    }

    /**
     * This method is used to insert an Object into a table
     * The insertStatement is created using reflection techniques
     */
    public void insert(T obj) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        try {
            Field[] fields = currentClass.getDeclaredFields();
            StringBuilder insertStatementBuilder = new StringBuilder("INSERT INTO " + ConnectionFactory.DBNAME + "." + currentClass.getSimpleName() + " (");
            for (int i = 1; i < fields.length; i++)
                insertStatementBuilder.append(fields[i].getName()).append(',');
            insertStatementBuilder.deleteCharAt(insertStatementBuilder.length() - 1);
            insertStatementBuilder.append(") VALUES (");
            Object[] values = getObjectData(obj);
            for (int i = 1; i < values.length; i++) {
                if (fields[i].getType() == String.class) {
                    insertStatementBuilder.append('\'').append(values[i].toString()).append('\'').append(',');
                } else {
                    insertStatementBuilder.append(values[i].toString()).append(',');
                }
            }
            insertStatementBuilder.deleteCharAt(insertStatementBuilder.length() - 1);
            insertStatementBuilder.append(");");
            insertStatement = connection.prepareStatement(insertStatementBuilder.toString());
            insertStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * This method is used to delete an Object from a table
     * The deleteStatement is created using reflection techniques
     */
    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;

        try {
            String deleteStatementString = "DELETE FROM " + ConnectionFactory.DBNAME + "." + currentClass.getSimpleName() + " WHERE " + currentClass.getDeclaredFields()[0].getName() + " = " + id;
            deleteStatement = connection.prepareStatement(deleteStatementString);
            deleteStatement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * This method is used to update an Object from a table
     * The updateStatement is created using reflection techniques
     */
    public void update(T obj) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        try {
            Field[] fields = currentClass.getDeclaredFields();
            Object[] values = getObjectData(obj);
            StringBuilder updateStatementBuilder = new StringBuilder("UPDATE " + ConnectionFactory.DBNAME + "." + currentClass.getSimpleName() + " SET ");
            for (int i = 1; i < fields.length; i++) {
                updateStatementBuilder.append(fields[i].getName()).append(" = ");
                if (fields[i].getType() == String.class) {
                    updateStatementBuilder.append('\'').append(values[i].toString()).append('\'').append(',');
                } else {
                    updateStatementBuilder.append(values[i].toString()).append(',');
                }
            }
            updateStatementBuilder.deleteCharAt(updateStatementBuilder.length() - 1);
            updateStatementBuilder.append(" WHERE ").append(fields[0].getName()).append(" = ").append(values[0].toString());
            updateStatement = connection.prepareStatement(updateStatementBuilder.toString());
            updateStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * This method extracts the values from a ResultSet using reflection techniques
     */
    private Object[] getObjectData(Field[] fields, ResultSet resultSet) {
        Object[] toReturn = new Object[fields.length];
        try {
            for (int i = 0; i < fields.length; i++) {
                toReturn[i] = resultSet.getObject(fields[i].getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    /**
     * This method extracts the values from an Object using reflection techniques using his getters
     */
    public Object[] getObjectData(Object obj) {
        Object[] toReturn = null;
        try {
            Field[] fields = currentClass.getDeclaredFields();
            toReturn = new Object[fields.length];
            for (int i = 0; i < fields.length; i++) {
                String n = fields[i].getName();
                Method method = currentClass.getDeclaredMethod("get" + n.substring(0, 1).toUpperCase() + n.substring(1));
                toReturn[i] = method.invoke(obj);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    /**
     * This method sets the values of an Object using reflection techniques using his setters
     */
    private void setObjectData(Object obj, Field[] field, Object[] values) {
        try {
            for (int i = 0; i < field.length; i++) {
                String n = field[i].getName();
                Method method = currentClass.getDeclaredMethod("set" + n.substring(0, 1).toUpperCase() + n.substring(1),
                        field[i].getType());
                method.invoke(obj, values[i]);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method returns the Object from a table that has the corresponding id
     */
    public T getbyId(int id) {
        ArrayList<T> list = this.findAll();
        String field = currentClass.getDeclaredFields()[0].getName();
        try {
            Method method = currentClass.getDeclaredMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1));
            for (T current : list) {
                if (method.invoke(current).equals(id))
                    return current;
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method returns the next number that ha
     */
    public int getmaxId() {
        int id = 1;
        ArrayList<T> list = this.findAll();
        String field = currentClass.getDeclaredFields()[0].getName();
        try {
            Method method = currentClass.getDeclaredMethod("get" + field.substring(0, 1).toUpperCase() + field.substring(1));
            for (T current : list) {
                if (method.invoke(current).equals(id))
                    id++;
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return id;
    }
}

