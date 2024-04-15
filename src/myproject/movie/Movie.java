package myproject.movie;

public class Movie {
    private int ID;
    private String NAME;
    private double PRICE;
    private String ACTOR;
    private String INFO;
//  默认构造器
    public Movie() {
    }
//  有参构造器
    public Movie(int ID, String NAME, double PRICE, String ACTOR, String INFO) {
        this.ID = ID;
        this.NAME = NAME;
        this.PRICE = PRICE;
        this.ACTOR = ACTOR;
        this.INFO = INFO;
    }

    //  设置---获取数据
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    public String getACTOR() {
        return ACTOR;
    }

    public void setACTOR(String ACTOR) {
        this.ACTOR = ACTOR;
    }

    public String getINFO() {
        return INFO;
    }

    public void setINFO(String INFO) {
        this.INFO = INFO;
    }
}
