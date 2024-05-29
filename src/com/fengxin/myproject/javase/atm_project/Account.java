package com.fengxin.myproject.javase.atm_project;

/**
 * @author FENGXIN
 */
public class Account {
    private String card;
    private String name;
    private char sex;
    private String password;
    private double money;
    //取现额度
    private double limitMoney;

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getName() {

        return name +(sex == '男'?"先生":"女士");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(double limitMoney) {
        this.limitMoney = limitMoney;
    }
}
