/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorydatabase;

/**
 *
 * @author Joseph
 */
public class Customer extends BusinessPartner{

    public Customer() {
    }

    public Customer(int id, int idAddress, String name, String phoneNum, String email) {
        this.id = id;
        this.idAddress = idAddress;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }
    
    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPhoneNum(String phoneNum) {
        super.setPhoneNum(phoneNum); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPhoneNum() {
        return super.getPhoneNum(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdAddress(int idAddress) {
        super.setIdAddress(idAddress); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdAddress() {
        return super.getIdAddress(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
