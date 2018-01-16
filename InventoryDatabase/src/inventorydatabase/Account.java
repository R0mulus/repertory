/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorydatabase;

import java.util.Date;

/**
 *
 * @author Joseph
 */
public class Account {
   
    private int id;
    private String login;
    private String password;
    private Date dateCreated;
    private Date lastPasswordChange;

    public Account(int id, String login, String password, Date dateCreated, Date lastPasswordChange) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.dateCreated = dateCreated;
        this.lastPasswordChange = lastPasswordChange;
    }

    public Account(String login, String password, Date dateCreated, Date lastPasswordChange) {
        this.login = login;
        this.password = password;
        this.dateCreated = dateCreated;
        this.lastPasswordChange = lastPasswordChange;
    }

    public Account(String login, String password, Date lastPasswordChange) {
        this.login = login;
        this.password = password;
        this.lastPasswordChange = lastPasswordChange;
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Account() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }
        
    
    
}
