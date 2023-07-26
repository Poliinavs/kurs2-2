package com.iris.glass.Model;

import javax.xml.crypto.Data;

public class aircompany {
    public aircompany(String airplane, String country, String day) {
        this.airplane = airplane;
        this.country = country;
        this.day = day;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String airplane;
    public String country;
    public String day;


}
