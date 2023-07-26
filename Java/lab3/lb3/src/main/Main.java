package main;
import lab3.payments.Admin.Admin;
import lab3.payments.Client.Client;
import  lab3.payments.account.*;
import  lab3.payments.Cards.*;
import  lab3.payments.Client.*;
import java.util.ArrayList;
import java.util.logging.*;
import java.util.logging.Level.*;


public class Main {
    // private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger("lab3.payments.main");
        logger.setLevel(Level.INFO);
        try {
            logger.info("Начало выполнения программы");
            Cards card1=new Cards(1, 2000);
            Cards card2=new Cards(1, 2300);
            Cards card3=new Cards(3, 5000);
            Cards card4=new Cards(3, 5000, CardsType.cardType.credit);

            account acc1 = new account();
            account acc2 = new account();
            acc1.add(card1);
            acc1.add(card2);
            acc1.add(card3);
            acc1.add(card4);
            acc2.add(card3);
            acc1.add(card4);

            Client cl1= new Client();
            Client cl2= new Client();
            cl1.name="Ivanov";
            cl2.name="Petrov";
            cl1.acc=acc1;
            cl2.acc=acc2;
            System.out.println("\nShow Information:");
            cl1.Show(3);
            cl1.Block(3);
            System.out.println("\nShow Information after block:");
            cl1.Show(3);
            System.out.println("\nShow Information after addition money:");
            cl1.Addition(3,100);
            cl1.Show(3);

            Admin admin1= new Admin();
            admin1.Block(1);
            admin1.add(cl1);
            admin1.add(cl2);
            admin1.FindClient("Ivanov");
            admin1.newCard(CardsType.cardType.credit, CardsType.cardType.debit);
           // card3.Show();
          logger.info("You successfully ran this program!");


        }
        catch (Exception e){
            logger.warning("Fatal error! " + e.getMessage());
        }

    }
}