package com.iris.glass;

public class Product {
    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getGroup1() {
        return group1;
    }

    public void setGroup1(String group1) {
        this.group1 = group1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String param, String discription, String group1, String name) {
        this.param = param;
        this.discription = discription;
        this.group1 = group1;
        this.name = name;
    }

    public String param;
    public String discription;
    public String group1;
    public String name;
}
