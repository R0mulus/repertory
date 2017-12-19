/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author client
 */
@ManagedBean
@RequestScoped
public class KalkulackaBeans {

    private double cislo1;
    private double cislo2;
    private double vysledok;
    private String operacia;
    private Map<String,String> mozneOperacie;
    
    
    /**
     * Creates a new instance of KalkulacnaBeans
     */
    public KalkulackaBeans() {
        mozneOperacie = new LinkedHashMap<>();
        mozneOperacie.put("Spocitaj","+");
        mozneOperacie.put("Odcitaj","-");
        mozneOperacie.put("Vynasob","*");
        mozneOperacie.put("Vydel","/");
    }
    
    public void vypocitaj(){
        switch(operacia){
            case "+":
                vysledok = getCislo1() + getCislo2();
                break;
            case "-":
                vysledok = getCislo1() - getCislo2();
                break;
            case "*":
                vysledok = getCislo1() * getCislo2();
                break;
            case "/":
                vysledok = getCislo1() / getCislo2();
                break;
            default: 
                vysledok = 0;
        }
    }

    public double getCislo1() {
        return cislo1;
    }

    public void setCislo1(double cislo1) {
        this.cislo1 = cislo1;
    }

    public double getCislo2() {
        return cislo2;
    }

    public void setCislo2(double cislo2) {
        this.cislo2 = cislo2;
    }

    public String getOperacia() {
        return operacia;
    }

    public void setOperacia(String operacia) {
        this.operacia = operacia;
    }

    public Map<String, String> getMozneOperacie() {
        return mozneOperacie;
    }

    public void setMozneOperacie(Map<String, String> mozneOperacie) {
        this.mozneOperacie = mozneOperacie;
    }

    public double getVysledok() {
        return vysledok;
    }

    public void setVysledok(double vysledok) {
        this.vysledok = vysledok;
    }
    
    
    
    
    
}
