package Park;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Park {
    public int Park_id;
    public int capacity;
     public int now_car=0;
    public Park(int park_id, int capacity) {
        Park_id = park_id;
        this.capacity = capacity;
    }

    public void Go_park(ArrayList<Car>cars, Park pr1, Park pr2){

      /*  for(int i=1;i<6;i++)
            new Car(sem1,i).start();*/
        Semaphore sem1 = new Semaphore(pr1.capacity);
        Semaphore sem2 = new Semaphore(pr2.capacity);
        for (Car car1: cars
             ) {
            if(pr1.now_car<=pr1.capacity){
                car1.number_park=1;
                pr1.now_car++;
                car1.semExp=sem1;
                car1.start();
            }
            else{
                car1.number_park=2;
                pr2.now_car++;
                car1.semExp=sem2;
                car1.start();
            }


       }
    }
}
