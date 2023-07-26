package Shower;

import java.util.List;

public class GoToShower {
    public int Capacity;


    public GoToShower(int capacity) {
        Capacity = capacity;
    }

    public synchronized void goToShower(List Man, List Woman)
    {
        int amount_man=0;
        double Man_Time=0;
        double Woman_Time=0;
        for (Object sh:Man
        ) {
            if(amount_man<3){

                amount_man++;
                Man_Time+=((Person) sh).time;
            }
        }
        Man_Time=Man_Time/amount_man;
        int amount_woman=0;
        for (Object sh:Woman
        ) {
            if(amount_woman<3){

                amount_woman++;
                Woman_Time+=((Person) sh).time;
            }
        }
        Woman_Time=Woman_Time/amount_woman;
        if (Woman_Time>Man_Time){ //тогда мужчины

        }

     /*   while ((currentCapacity>=maxCapacity || currentGender!=person.getGender() || currentTime<person.getHour())
                && currentCapacity!=0 && currentTime!=0)
        {
            try
            {
                System.out.println(person.getPersonName() + " îæèäàåò ñâîåé î÷åðåäè(" + person.getHour() + " ÷àñîâ, â äóøå "
                        + currentCapacity + " ÷åëîâåê)");
                wait();
            }
            catch (InterruptedException e){}
        }

        if(currentCapacity == 0){
            currentGender = person.getGender();
            currentTime = person.getHour();
        }
        currentCapacity++;
        System.out.println(person.getPersonName() + " çàø¸ë(à) â äóø(" + person.getHour() + " ÷àñîâ, â äóøå "
                + currentCapacity + " ÷åëîâåê)");
        notify();*/
    }
}
class Current_Capacity{

    public int x=1;
}
class Go  implements Runnable {
    Current_Capacity res;
    Go(Current_Capacity res){
        this.res=res;
    }
    public void run(){
        synchronized(res){
            res.x=1;
            for (int i = 0; i < 3; i++){

                System.out.printf("\nСейчас в душе"+ res.x);

                res.x++;

            }
            System.out.printf("\n------------\n");
        }
    }
}