/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import inventorydatabase.Account;
import inventorydatabase.Address;
import inventorydatabase.Customer;
import inventorydatabase.Goods;
import inventorydatabase.PastArrival;
import inventorydatabase.PastExpedition;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import inventorydatabase.Person;
import inventorydatabase.Shipper;
import inventorydatabase.Supplier;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Joseph
 */
public class ConnectionProvider {
    private static final String USERNAME = "root";
    //dtb pass for school computer = admin
    //dtb pass for elsewhere = ""
    private static final String PASSWORD = "";
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
        String query = "SELECT id FROM Accounts WHERE login LIKE ? AND password LIKE PASSWORD(?)";
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
    
    public List<Supplier> getSuppliers(){
        String query = "SELECT * FROM Suppliers";
        Connection conn = getConnection();
        Supplier supplier = null;
        List<Supplier> listOfSupplers = new ArrayList();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int addressID = rs.getInt("idAddress");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    supplier = new Supplier(id, addressID, name, phone, email);
                    listOfSupplers.add(supplier);
                }
                conn.close();
                return listOfSupplers;
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return null; 
    }
    
    public Supplier getSupplierByID(int id){
        String query = "SELECT * FROM Suppliers WHERE id = ?";
        Connection conn = getConnection();
        Supplier supplier = null;
        if (conn != null) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int addressID = rs.getInt("idAddress");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    supplier = new Supplier(id, addressID, name, phone, email);
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        
        return supplier;
    }
    
    public List<Shipper> getShippers(){
        String query = "SELECT * FROM Shippers";
        Connection conn = getConnection();
        Shipper shipper = null;
        List<Shipper> listOfShippers = new ArrayList();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int addressID = rs.getInt("idAddress");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    shipper = new Shipper(id, addressID, name, phone, email);
                    listOfShippers.add(shipper);
                }
                conn.close();
                return listOfShippers;
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return null; 
    }
    
    public Shipper getShipperByID(int id){
        String query = "SELECT * FROM Shippers WHERE id = ?";
        Connection conn = getConnection();
        Shipper shipper = null;
        if (conn != null) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int addressID = rs.getInt("idAddress");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    shipper = new Shipper(id, addressID, name, phone, email);
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        
        return shipper;
    }
    
    public int addNewArrival(int idSup, int idShip, int idUser){
        String query = "INSERT INTO Arrivals(idSupplier, idShipper, idUser) "
                + "VALUES(?, ?, ?)";
        Connection conn = getConnection();
        int idArrival = -1;
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idSup);
                ps.setInt(2, idShip);
                ps.setInt(3, idUser);
                ps.execute();
                
                try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        idArrival = generatedKeys.getInt(1);
                        conn.close();
                    }
                    else{
                        throw new SQLException("Creating new arrival failed, no ID obtained");
                    }
                }

            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return idArrival;
    }

    public void addArrivalDetails(int idArrival, int idGoods, int quantity){
        String query = "INSERT INTO ArrivalDetails(idArrival, idGoods, quantity, arrivalDate) "
                + "VALUES(?, ?, ?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idArrival);
                ps.setInt(2, idGoods);
                ps.setInt(3, quantity);
                ps.setString(4, getCurrentDateTime());
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public int addNewGoods(String name, String code, int quantity, double pricePerUnit){
        String query = "INSERT INTO Goods(name, code, quantity, pricePerUnit) "
                + "VALUES(?, ?, ?, ?)";
        Connection conn = getConnection();
        int idGoods = -1;
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, code);
                ps.setInt(3, quantity);
                ps.setDouble(4, pricePerUnit);
                ps.execute();
                
                try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        idGoods = generatedKeys.getInt(1);
                        conn.close();
                    }
                    else{
                        throw new SQLException("Creating new arrival failed, no ID obtained");
                    }
                }

            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return idGoods;
    }  
    
    public void updateGoodsQuantity(int id, int quantity, char type){
        String query = "UPDATE Goods SET quantity = quantity " + type + " ? WHERE id LIKE ?";
        Connection conn = getConnection();
        if (conn != null) {
            try(PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, quantity);
                ps.setInt(2, id);
                ps.execute();
                conn.close();
            }
            catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }

    public boolean updatePersonAndAccount(String firstName, String lastName, String email, String cardID, int idUser, int idAccount, String login, String password) throws SQLException {
        Connection conn = getConnection();
        
        String queryUserPersonal = "UPDATE UserPersonal SET cardID = ?,"
                + " firstName = ?,"
                + " lastName = ?,"
                + " email = ?"
                + " WHERE id = ?";

        String queryAccount = "UPDATE Accounts SET login = ?, password = PASSWORD(?), lastPasswordChange = ?" 
                + " WHERE id = ?";

        
        if(conn != null){
            try{
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement(queryUserPersonal);
                ps.setString(1, cardID);
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                ps.setString(4, email);
                ps.setInt(5, idUser);
                ps.execute();
                ps.close();
                
                ps = conn.prepareStatement(queryAccount);
                ps.setString(1, login);
                ps.setString(2, password);
                ps.setString(3, getCurrentDateTime());
                ps.setInt(4, idAccount);
                ps.execute();
                ps.close();
                
                conn.commit();
                
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
                try {
                    System.out.print("User + account update transaction is being rolled back.");
                    conn.rollback();
                    return false;
                } catch(SQLException excep) {
                    System.out.println("Error: " + excep.toString());
                }
            }finally {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
        return true;
    }
    
    public boolean updateBusinessPartnerAndAddress(String table, String name, String phone, String email, int idShipper, int idAddress, String country, String countryState, String postalCode, String city, String street, int streetNum) throws SQLException {
        Connection conn = getConnection();
        
        String queryShipper = "UPDATE " + table + " SET name = ?,"
                + " phone = ?,"
                + " email = ?"
                + " WHERE id = ?";
        String queryAddress = "UPDATE Addresses SET country = ?, countryState = ?, postalCode = ?, city = ?, street = ?, streetNum = ?" 
                + " WHERE id = ?";

        if(conn != null){
            try{
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement(queryShipper);
                ps.setString(1, name);
                ps.setString(2, phone);
                ps.setString(3, email);
                ps.setInt(4, idShipper);
                ps.execute();
                ps.close();
                
                ps = conn.prepareStatement(queryAddress);
                ps.setString(1, country);
                ps.setString(2, countryState);
                ps.setString(3, postalCode);
                ps.setString(4, city);
                ps.setString(5, street);
                ps.setInt(6, streetNum);
                ps.setInt(7, idAddress);
                ps.execute();
                ps.close();

                conn.commit();
                
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
                try {
                    System.out.print(table + " update transaction is being rolled back.");
                    conn.rollback();
                    return false;
                } catch(SQLException excep) {
                    System.out.println("Error: " + excep.toString());
                }
                
            }finally {
                conn.setAutoCommit(true);
                conn.close();
                
            }
        }
        return true;
    }
    
    public List<Customer> getCustomers(){
        String query = "SELECT * FROM Customers";
        Connection conn = getConnection();
        Customer customer = null;
        List<Customer> listOfCustomers = new ArrayList();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int addressID = rs.getInt("idAddress");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    customer = new Customer(id, addressID, name, phone, email);
                    listOfCustomers.add(customer);
                }
                conn.close();
                return listOfCustomers;
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return null; 
    }
    
    public Customer getCustomerByID(int id){
        String query = "SELECT * FROM Customers WHERE id = ?";
        Connection conn = getConnection();
        Customer customer = null;
        if (conn != null) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int addressID = rs.getInt("idAddress");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    customer = new Customer(id, addressID, name, phone, email);
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        
        return customer;
    }
    
    public int addNewExpedition(int idCustomer, int idShip, int idUser){
        String query = "INSERT INTO Expeditions(idCustomer, idShipper, idUser) "
                + "VALUES(?, ?, ?)";
        Connection conn = getConnection();
        int idExpedition = -1;
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idCustomer);
                ps.setInt(2, idShip);
                ps.setInt(3, idUser);
                ps.execute();
                
                try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        idExpedition = generatedKeys.getInt(1);
                        conn.close();
                    }
                    else{
                        throw new SQLException("Creating new arrival failed, no ID obtained");
                    }
                }

            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return idExpedition;
    }

    public void addExpeditionDetails(int idExpedition, int idGoods, int quantity){
        String query = "INSERT INTO ExpeditionDetails(idExpedition, idGoods, quantity, expeditionDate) "
                + "VALUES(?, ?, ?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idExpedition);
                ps.setInt(2, idGoods);
                ps.setInt(3, quantity);
                ps.setString(4, getCurrentDateTime());
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public int addNewAccount(String login, String password){
        String query = "INSERT INTO Accounts(login, password, dateCreated, lastPasswordChange) "
                + "VALUES(?, PASSWORD(?), ?, ?)";
        Connection conn = getConnection();
        int idAccount = -1;
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, login);
                ps.setString(2, password);
                ps.setString(3, getCurrentDateTime());
                ps.setString(4, getCurrentDateTime());
                ps.execute();
                
                try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        idAccount = generatedKeys.getInt(1);
                        conn.close();
                    }
                    else{
                        throw new SQLException("Creating new arrival failed, no ID obtained");
                    }
                }

            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return idAccount;
    }  
    
    public void addUserPersonal(int idAccount, String cardID, String firstName, String lastName, String email){
        String query = "INSERT INTO UserPersonal(idAccount, cardId, firstName, lastName, email) "
                + "VALUES(?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idAccount);
                ps.setString(2, cardID);
                ps.setString(3, firstName);
                ps.setString(4, lastName);
                ps.setString(5, email);
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public List<Person> getPeople(){
        String query = "SELECT * FROM UserPersonal";
        Connection conn = getConnection();
        Person person = null;
        List<Person> listOfPeople = new ArrayList();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int personID = rs.getInt("id");
                    int personAccID = rs.getInt("idAccount");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String email = rs.getString("email");
                    String cardID = rs.getString("cardId");
                    person = new Person(personID, personAccID, cardID, firstName, lastName, email);
                    listOfPeople.add(person);
                }
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return listOfPeople; 
    }
    
    public List<Account> getAccounts(){
        String query = "SELECT * FROM Accounts";
        Connection conn = getConnection();
        Account account = null;
        List<Account> listOfAccounts = new ArrayList();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    Date dateCreated = rs.getDate("dateCreated");
                    Date lastPasswordChange = rs.getDate("lastPasswordChange");
                    account = new Account(id, login, password, dateCreated, lastPasswordChange);
                    listOfAccounts.add(account);
                }
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return listOfAccounts; 
    }
    
    public List<Address> getAddresses(){
        String query = "SELECT * FROM Addresses";
        Connection conn = getConnection();
        Address address = null;
        List<Address> listOfAddress = new ArrayList();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int addressID = rs.getInt("id");
                    String country = rs.getString("country");
                    String countryState = rs.getString("countryState");
                    String postalCode = rs.getString("postalCode");
                    String city = rs.getString("city");
                    String street = rs.getString("street");
                    int streetNum = rs.getInt("streetNum");
                    address = new Address(addressID, country, countryState, postalCode, city, street, streetNum);
                    listOfAddress.add(address);
                }
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
        return listOfAddress;
    }
    
    public boolean deleteUserData(int id, int idAcc) throws SQLException {
        Connection conn = getConnection();
        
        String deleteUserPersonalQuery = "DELETE FROM UserPersonal WHERE id = ?";
        String deleteAccQuery = "DELETE FROM Accounts WHERE id = ?";

        if(conn != null){
            try{
                conn.setAutoCommit(false);
                
                PreparedStatement ps = conn.prepareStatement(deleteUserPersonalQuery);
                ps.setInt(1, id);
                ps.execute();
                ps.close();
                
                ps = conn.prepareStatement(deleteAccQuery);
                ps.setInt(1, idAcc);
                ps.execute();
                ps.close();

                conn.commit();
                
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
                try {
                    System.out.print("Transaction is being rolled back.");
                    conn.rollback();
                    return false;
                } catch(SQLException excep) {
                    System.out.println("Error: " + excep.toString());
                }
                
            }finally {
                conn.setAutoCommit(true);
                conn.close();
                
            }
        }
        return true;
    }
    
    public boolean deleteBusinessPartnerData(int id, int idAddress, String businessPartner) throws SQLException {
        Connection conn = getConnection();
        
        String deleteSupplierQuery = "DELETE FROM " + businessPartner + " WHERE id = ?";
        String deleteAddressQuery = "DELETE FROM Addresses WHERE id = ?";

        if(conn != null){
            try{
                conn.setAutoCommit(false);
                
                PreparedStatement ps = conn.prepareStatement(deleteSupplierQuery);
                ps.setInt(1, id);
                ps.execute();
                ps.close();
                
                ps = conn.prepareStatement(deleteAddressQuery);
                ps.setInt(1, idAddress);
                ps.execute();
                ps.close();

                conn.commit();
                
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
                try {
                    System.out.print("Transaction is being rolled back.");
                    conn.rollback();
                    return false;
                } catch(SQLException excep) {
                    System.out.println("Error: " + excep.toString());
                }
            }finally {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
        return true;
    }
    
   
    
    public List<PastArrival> getArrivals(String datepicked) {
        String query = "SELECT * FROM Arrivals " +
                "INNER JOIN ArrivalDetails ON Arrivals.id = ArrivalDetails.idArrival " +
                "INNER JOIN Goods ON Goods.id = ArrivalDetails.idGoods " +
                "INNER JOIN Shippers ON Shippers.id = Arrivals.idShipper " +
                "INNER JOIN Suppliers ON Suppliers.id = Arrivals.idSupplier " +
                "INNER JOIN UserPersonal ON UserPersonal.id = Arrivals.idUser " +
                "WHERE ArrivalDetails.arrivalDate LIKE ?";
        Connection conn = getConnection();
        PastArrival pastArrival;
        List<PastArrival> arrivals = new ArrayList();
        if (conn != null) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, datepicked);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String goodsName = rs.getString("Goods.name");
                    String goodsCode = rs.getString("Goods.code");
                    int goodsQuantity = rs.getInt("ArrivalDetails.quantity");
                    float pricePerUnit = rs.getFloat("Goods.pricePerUnit");
                    String supplierName = rs.getString("Suppliers.name");
                    String shipperName = rs.getString("Shippers.name");
                    String userFirstName = rs.getString("UserPersonal.firstName");
                    String userLastName = rs.getString("UserPersonal.lastName");
                    String userCardID = rs.getString("UserPersonal.cardId");
                    
                    int idGoods = rs.getInt("Goods.id");

                    pastArrival = new PastArrival(goodsName, goodsCode, goodsQuantity, pricePerUnit, supplierName, shipperName, userFirstName, userLastName, userCardID);
                    arrivals.add(pastArrival);         
                }
                
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return arrivals;
    }
    
    public List<PastExpedition> getExpeditions(String datepicked) {
        String query = "SELECT * FROM Expeditions " +
                "INNER JOIN ExpeditionDetails ON Expeditions.id = ExpeditionDetails.idExpedition " +
                "INNER JOIN Goods ON Goods.id = ExpeditionDetails.idGoods " +
                "INNER JOIN Shippers ON Shippers.id = Expeditions.idShipper " +
                "INNER JOIN Customers ON Customers.id = Expeditions.idCustomer " +
                "INNER JOIN UserPersonal ON UserPersonal.id = Expeditions.idUser " +
                "WHERE ExpeditionDetails.expeditionDate LIKE ?";
        Connection conn = getConnection();
        PastExpedition pastExpedition;
        List<PastExpedition> expeditions = new ArrayList();
        if (conn != null) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, datepicked);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String goodsName = rs.getString("Goods.name");
                    String goodsCode = rs.getString("Goods.code");
                    int goodsQuantity = rs.getInt("ExpeditionDetails.quantity");
                    float pricePerUnit = rs.getFloat("Goods.pricePerUnit");
                    String customerName = rs.getString("Customers.name");
                    String shipperName = rs.getString("Shippers.name");
                    String userFirstName = rs.getString("UserPersonal.firstName");
                    String userLastName = rs.getString("UserPersonal.lastName");
                    String userCardID = rs.getString("UserPersonal.cardId");

                    pastExpedition = new PastExpedition(goodsName, goodsCode, goodsQuantity, pricePerUnit, customerName, shipperName, userFirstName, userLastName, userCardID);
                    expeditions.add(pastExpedition);         
                }
                
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return expeditions;
    }
    
    
}
