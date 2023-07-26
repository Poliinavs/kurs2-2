package lab3.payments.account;
import java.util.ArrayList;
import java.util.List;
import lab3.payments.Cards.Cards;


public class account {
    public static int number;
    public static int balance;
    public List<Cards> cardList;

    public account() {
        cardList = new ArrayList<>();
    }
    public List<Cards> getCardList(){return cardList;}
    public void setCardList(List<Cards> cardList){
        this.cardList=cardList;
    }

    public void add(Cards card){
        cardList.add(card);
    }
    public void delete(Cards card){
        cardList.remove(card);
    }
    public void deleteAll(){cardList.removeAll(cardList);}
    public String Show(){
        System.out.println("number of Account: "+number+ " balance: "+balance);
        return "number of Account: "+number+ " balance: "+balance;
    }

}
