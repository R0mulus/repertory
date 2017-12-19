/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import inventorydatabase.Goods;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import inventorydatabase.Person;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph
 */
public class ConnectionProvider {
    private static final String USERNAME = "root";
    //dtb pass for school computer = admin
    //dtb pass for elsewhere = ""
    private static final String PASSWORD = "admin";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String DBNAME = "inventory";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String UseSSL = "?useSSL=false";

    
    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL + DBNAME + UseSSL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return conn;
    }
    
    private String getCurrentDateTime(){
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(cal.getTimeZone());
        String dateString = sdf.format(cal.getTime());
        return dateString;
    }
    
    public boolean isAccountPasswordValid(String username, String password) {
        String query = "SELECT id FROM Accounts WHERE login LIKE BINARY ? AND password LIKE BINARY ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                boolean result = rs.next();

                conn.close();

                return result;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return false;
    }
    
    public int getAccountID(String username){
       String query = "SELECT id FROM Accounts WHERE login LIKE BINARY ?";
        Connection conn = getConnection();
        int id = -1;

        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    id = rs.getInt("id");
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return id;
    }
    
    public Person getPersonByID(int id){
        String query = "SELECT * FROM UserPersonal WHERE id LIKE ?";
        Connection conn = getConnection();
        Person person = null; 
        if(conn != null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int idAcc = rs.getInt("idAccount");
                    String cardId = rs.getString("cardId");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");

                    person = new Person(id, idAcc, cardId, firstname, lastname, email);
                }else{
                    person = new Person(id, -1, "", "", "", "");
                }
                conn.close();
                
            } catch (SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return person;
    }
    
    public List<Goods> getGoods(){
        String query = "SELECT * FROM Goods";
        Connection conn = getConnection();
        Goods goods = null;
        List<Goods> listOfGoods = new ArrayList();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int goodsID = rs.getInt("id");
                    String goodsName = rs.getString("name");
                    String goodsCode = rs.getString("code");
                    int goodsQuantity = rs.getInt("quantity");
                    float goodsPricePerUnit = rs.getFloat("pricePerUnit");
                    goods = new Goods(goodsID, goodsName, goodsCode, goodsQuantity, goodsPricePerUnit );
                    listOfGoods.add(goods);
                }
                conn.close();
                return listOfGoods;
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return null; 
    }
    
    public void addNewShipper(int idAddress, String name, String phone, String email){
        String query = "INSERT INTO Shippers(idAddress, name, phone, email) "
                + "VALUES(?, ?, ?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idAddress);
                ps.setString(2, name);
                ps.setString(3, phone);
                ps.setString(4, email);
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public void addNewCustomer(int idAddress, String name, String phone, String email){
        String query = "INSERT INTO Customers(idAddress, name, phone, email) "
                + "VALUES(?, ?, ?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idAddress);
                ps.setString(2, name);
                ps.setString(3, phone);
                ps.setString(4, email);
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public void addNewSupplier(int idAddress, String name, String phone, String email){
        String query = "INSERT INTO Suppliers(idAddress, name, phone, email) "
                + "VALUES(?, ?, ?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idAddress);
                ps.setString(2, name);
                ps.setString(3, phone);
                ps.setString(4, email);
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public int addNewAddress(String country, String state, String zipCode, String city, String street, int streetNum){
        String query = "INSERT INTO Addresses(country, countryState, postalCode, city, street, streetNum) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        int idAddress = -1;
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, country);
                ps.setString(2, state);
                ps.setString(3, zipCode);
                ps.setString(4, city);
                ps.setString(5, street);
                ps.setInt(6, streetNum);
                ps.execute();
                
                try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        idAddress = generatedKeys.getInt(1);
                        conn.close();
                        return idAddress;
                    }
                    else{
                        throw new SQLException("Creating address failed, no ID obtained");
                    }
                }

            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return idAddress;
    }
    
    public List<Goods> getShippers(){
        String query = "SELECT * FROM Shippers";
        Connection conn = getConnection();
        Goods goods = null;
        List<Goods> listOfGoods = new ArrayList();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int goodsID = rs.getInt("id");
                    String goodsName = rs.getString("name");
                    String goodsCode = rs.getString("code");
                    int goodsQuantity = rs.getInt("quantity");
                    float goodsPricePerUnit = rs.getFloat("pricePerUnit");
                    goods = new Goods(goodsID, goodsName, goodsCode, goodsQuantity, goodsPricePerUnit );
                    listOfGoods.add(goods);
                }
                conn.close();
                return listOfGoods;
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return null; 
    }
}
