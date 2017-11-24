/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorydatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author client
 */
public class InventoryDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^www\\.[a-z]*\\.(sk|cz)$");
        Pattern p2 = Pattern.compile("[^abc]$");
        Matcher m = p2.matcher("www.aaaaaaaaaaaaaa.skabca");
         
        if(m.find()){
            System.out.println("pravidla su splnene");
        }else{
            System.out.println("pravidla nesplnene");
        }
    }
    
}
