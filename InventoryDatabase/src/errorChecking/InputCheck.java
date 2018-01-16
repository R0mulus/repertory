/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorChecking;

import database.ConnectionProvider;
import inventorydatabase.Account;
import inventorydatabase.Customer;
import inventorydatabase.Person;
import inventorydatabase.Shipper;
import inventorydatabase.Supplier;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Joseph
 */
public class InputCheck {
    
    private static final String phonePrefixPlus = "+";
    private static final String phonePrefixZeroes = "00";
    private List<Customer> customers = null;
    private List<Shipper> shippers = null;
    private List<Supplier> suppliers = null;
    private List<Person> people = null;
    
    public InputCheck(){}
    
    private void refreshLists(){
        customers = null;
        shippers = null;
        suppliers = null;
        people = null;
        ConnectionProvider conn = new ConnectionProvider();
        customers = conn.getCustomers();
        shippers = conn.getShippers();
        suppliers = conn.getSuppliers();
        people = conn.getPeople();
    }
    
    public boolean isEmailInDatabase(String email){
        refreshLists();
        for(Customer customer : customers){
            if((customer.getName()).equalsIgnoreCase(email)){
                return true;
            }
        }
        for(Shipper shipper : shippers){
            if((shipper.getName()).equalsIgnoreCase(email)){
                return true;
            }
        }
        for(Supplier supplier : suppliers){
            if((supplier.getName()).equalsIgnoreCase(email)){
                return true;
            }
        }
        for(Person person : people){
            if((person.getEmail()).equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isNameInUse(String name, char type){
        refreshLists();
        switch(type){
            case 'c':for(Customer customer : customers){
                        if((customer.getName()).equalsIgnoreCase(name)){
                            return true;
                        }
                     }return false;
            case 'i':for(Shipper ship : shippers){
                        if((ship.getName()).equalsIgnoreCase(name)){
                            return true;
                        }
                     }
                     return false;
            case 'u':for(Supplier supplier : suppliers){
                        if((supplier.getName()).equalsIgnoreCase(name)){
                            return true;
                        }
                     }
                     return false;
            default:return true;
        }
    }
    
    public boolean isPhoneInUse(String phone){
        refreshLists();
        for(Customer customer : customers){
            if((customer.getPhoneNum()).equalsIgnoreCase(phone)){
                return true;
            }
        }
        for(Shipper shipper : shippers){
            if((shipper.getPhoneNum()).equalsIgnoreCase(phone)){
                return true;
            }
        }
        for(Supplier supplier : suppliers){
            if((supplier.getPhoneNum()).equalsIgnoreCase(phone)){
                return true;
            }
        }
        return false;
    }
    
    /*
    *   check if string can be parsed to integer data type
    */
    public boolean isInt(String text){
        if(text.trim().length() > 0){
            try {
                Integer.parseInt(text);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
    
    /*
    *   check if string can be parsed to long data type
    */
    private boolean isLong(String text){
        try {
            Long.parseLong(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /*
    *   check if string can be parsed to double data type
    */
    public boolean isDouble(String text){
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /*
    *   check string length with maximum and minimum properties
    */
    public boolean isInputLengthCorrect(String text, int maxLength, int minLength){
        return text.length() <= maxLength && text.length() >= minLength;
    }
    
    /*
    *   apache commons email validator
    *   - disabled local addresses
    */
    public boolean isEmailCorrect(String text){
        return EmailValidator.getInstance(false).isValid(text);
    }
    
    /*
    *   check if phone number starts with international telephone prefix
    */
    public boolean isPhoneCorrect(String text){
        if(text.startsWith(phonePrefixPlus)){
            String phoneString = text.substring(1);
            return isLong(phoneString);
        }else if(text.startsWith(phonePrefixZeroes)){
            return isLong(text);
        }
        return false;

    }
    
    /*
    *   check if input has surpassed given decimal point
    */
    public boolean hasNumberSurpassedDecimalPoint(Double value, int numberOfDecimalPoints){
        return BigDecimal.valueOf(value).scale() > numberOfDecimalPoints;
    }
    
    public boolean isPasswordStrongEnough(String password){
        boolean hasDigit = false;
        boolean hasLetter = false;
        if(isInputLengthCorrect(password, 20, 8)){
            for(char c : password.toCharArray()) {
                if(Character.isDigit(c)){
                    hasDigit = true;
                }else if(Character.isLetter(c)){
                    hasLetter = true;
                }else{
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean doPasswordsMatch(String password1, String password2){
        return password1.equals(password2);
    }
            
}
