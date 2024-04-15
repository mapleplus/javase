package myproject.menu;

public class Menu {
    private String mName;
    private double mPrice;
    private String mInfo;
    public Menu(){}
    public Menu(String name, double price, String info) {
        mName = name;
        mPrice = price;
        mInfo = info;
    }
    public String getName() {return mName;}
    public double getPrice() {return mPrice;}
    public String getInfo() {return mInfo;}
    public void setmName(String name) {mName = name;}
    public void setPrice(double price) {mPrice = price;}
    public void setInfo(String info) {mInfo = info;}
}
