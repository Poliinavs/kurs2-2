package Shower;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shower
{
    public int maxCapacity;

    public ArrayList<Person> pr;
   /* public ArrayList<Person> Man;
    public ArrayList<Person> Woman;*/
   // public static Woman wm;
    //public static Man mn;
    public int nowCapacity;

    public Shower(int maxCapacity) {
       // wm=new Woman();
      //  mn= new Man();
        pr=new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }
    public static void Choose(List Man, List Woman){
       /* var Woman_Time= Woman.stream()
                .collect(Collectors.averagingInt(num. -> Integer.parseInt(num));
*/
      int amount_man=0;
        String Man_inf="";
        double Man_Time=0;
        double Woman_Time=0;
        for (Object sh:Man
        ) {
            if(amount_man<3){
                Man_inf+=((Person) sh).toString();

                amount_man++;
                Man_Time+=((Person) sh).time;
            }
        }
        Man_Time=Man_Time/amount_man;
        int amount_woman=0;
        String Woman_inf="";
        for (Object sh:Woman
        ) {
            if(amount_woman<3){
                Woman_inf+=((Person) sh).toString();
                amount_woman++;
                Woman_Time+=((Person) sh).time;
            }
        }
        Woman_Time=Woman_Time/amount_woman;

        if(Woman_Time>Man_Time){ //значит мужчны заходят
          //  new mn().start();
           // mn.run();
          /*  while(i>=-1){*/
            System.out.printf(Man_inf);
            People_In_Shower people_In_Shower = new People_In_Shower();
            Thread t = new Thread((Runnable) new Man(people_In_Shower,amount_man));
            synchronized(t) {
                t.start();
                try {
                    t.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            while(amount_man>0){
                Man.remove(amount_man);
                amount_man--;
            }
                /*i--;
            }*/
        }
        else{
            People_In_Shower people_In_Shower= new People_In_Shower();
            Thread t = new Thread((Runnable) new Man(people_In_Shower,amount_woman));
            t.start();
            System.out.printf(Woman_inf);
            while(amount_woman>0){
                Woman.remove(amount_woman);
                amount_woman--;
            }

        }

    }

    public static void TakeShower(List Man, List Woman) throws InterruptedException {

        int size=(Man.size()+Woman.size())/3;
     while(size>0){
            Choose(Man,Woman);
            size--;
         Thread.sleep(2000);
        }

    }
}
class People_In_Shower{

   public int x=1;
}
class Man  implements Runnable {
    People_In_Shower res;
    int Current;
    Man(People_In_Shower res, int cur){
        this.res=res;
        this.Current=cur;
    }
    public void run(){

            synchronized (res) {
                    for (int i = 0; i < Current; i++) {
                        System.out.printf("\nЛюдей в душе" + res.x);
                        res.x++;
                    }
                }
                res.x = 1;
                System.out.printf("\n------------\n");
            }
        }


class Woman  implements Runnable {
    People_In_Shower res;
    Woman(People_In_Shower res){
        this.res=res;
    }
    public void run(){
        synchronized(res){
            res.x=1;
            for (int i = 0; i < 3; i++){
                System.out.printf("\nЖенщин в душе"+ res.x);
                res.x++;

            }
            System.out.printf("\n------------\n");
        }
    }
}