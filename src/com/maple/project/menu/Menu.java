package com.maple.project.menu;

/**
 * @author FENGXIN
 */
public class Menu {
    private String mName;
    private Double mPrice;
    private String mInfo;
    public Menu(){}
    public Menu(String name, Double price, String info) {
        mName = name;
        mPrice = price;
        mInfo = info;
    }
    public String getName() {return mName;}
    public Double getPrice() {return mPrice;}
    public String getInfo() {return mInfo;}
    public void setmName(String name) {mName = name;}
    public void setPrice(Double price) {mPrice = price;}
    public void setInfo(String info) {mInfo = info;}
}
