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
public class PastArrival {
    private String goodsName;
    private String goodsCode;
    private int goodsQuantity;
    private float pricePerUnit;
    private String supplierName;
    private String shipperName;
    private String userFirstName;
    private String userLastName;
    private String userCardID;

    public PastArrival(String goodsName, String goodsCode, int goodsQuantity, float pricePerUnit, String supplierName, String shipperName, String userFirstName, String userLastName, String userCardID) {
        this.goodsName = goodsName;
        this.goodsCode = goodsCode;
        this.goodsQuantity = goodsQuantity;
        this.pricePerUnit = pricePerUnit;
        this.supplierName = supplierName;
        this.shipperName = shipperName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCardID = userCardID;
    }

    public PastArrival() {
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserCardID() {
        return userCardID;
    }

    public void setUserCardID(String userCardID) {
        this.userCardID = userCardID;
    }
    
    
}
