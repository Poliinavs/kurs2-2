//package com.devcolibri.logic;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;


public class Admin {
    public ArrayList<Client>  clientList;
    public Admin() {
        clientList = new ArrayList<>();
    }

    public void add(Client em)
    {
        clientList.add(em);

    }

    public void removeEmployee(Client em)
    {
        if(clientList.contains(em)) {
            clientList.remove(em);
        }
        else
        {
            System.out.println("Такого клиента нет");
        }
    }

    public void FindClient(String name){
        for (var a:this.clientList
        ) {
            if(a.name==name){
                System.out.println("\n This client was find");
            }

        }
    }
    public int summa(Client a){
        return a.card1+a.card2;
    }



}
