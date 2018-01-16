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
public class Address {
        
    private int id;
    private String country;
    private String countryState;
    private String postalCode;
    private String city;
    private String street;
    private int streetNum;

    public Address(int id, String country, String countryState, String postalCode, String city, String street, int streetNum) {
        this.id = id;
        this.country = country;
        this.countryState = countryState;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.streetNum = streetNum;
    }

    public Address(String country, String countryState, String postalCode, String city, String street, int streetNum) {
        this.country = country;
        this.countryState = countryState;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.streetNum = streetNum;
    }

    public Address() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryState() {
        return countryState;
    }

    public void setCountryState(String countryState) {
        this.countryState = countryState;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }
    
    
    
}
