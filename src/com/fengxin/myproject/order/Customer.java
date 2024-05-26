package com.fengxin.myproject.order;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class Customer {
    private String customerName;
    private int customerId = 0;
    private String customerPassward;

    public String getCustomerName() {
        return this.customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerPassward() {
        return this.customerPassward;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCutomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerPassward(String customerPassward) {
        this.customerPassward = customerPassward;
    }

    public static void sign(String name, String passward, int count) {
        String fileCustomerPath = "E:\\customer.txt";
        if (count == 1) {
            File file = new File(fileCustomerPath);
        }
        FileOutputStream fos = new FileOutputStream(fileCustomerPath);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

    }
}
