package com.iris.glass.Pages;

public enum Page
{
    LOGIN_PAGE("/index.jsp"),
    REGISTER_PAGE("/reg.jsp"),
    WELCOME_PAGE("/tabl.jsp"),
    ERROR_PAGE("/error.jsp");

    private final String thisStr;
    Page(String s) {
        thisStr = s;
    }

    public String getPage()
    {
        return thisStr;
    }
}
