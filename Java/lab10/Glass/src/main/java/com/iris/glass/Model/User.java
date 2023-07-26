package com.iris.glass.Model;

public class User {
    public int id;
    public String login;
    public String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
