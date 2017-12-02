/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorChecking;

import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Joseph
 */
public class InputCheck {
    
    private static final String phonePrefixPlus = "+";
    private static final String phonePrefixZeroes = "00";
    
    public InputCheck(){}
    
    /*
    *   check if string can be parsed to integer data type
    */
    public boolean isInt(String text){
        if(text.trim().length() > 0){
            try {
                Integer.parseInt(text);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Error parsing to Integer: " + e);
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
            System.out.println("Error parsing to Long: " + e);
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
            
}
