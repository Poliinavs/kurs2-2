package Park;

import java.util.concurrent.Semaphore;

public class Car  extends Thread  {
   public int number_car;
    public int number_park;
    public Semaphore semExp;
    public Semaphore sem1;
    public Semaphore sem2;
   public int time_wait;

   public Park pr1;
   public Park pr2;
   public int time_need;
    public Car(int number_car, int time, int tmWait,Semaphore sem1, Semaphore sem2, Park pr1, Park pr2 ) {
        this.number_car = number_car;
        this.time_need = time;
        this.time_wait = tmWait;
        this.sem1=sem1;
        this.sem2=sem2;
        this.pr1=pr1;
        this.pr2=pr2;
    }


    @Override
    public String toString() {
        return "Car{" +
                "number_car=" + number_car +
                ", time_wait=" + time_wait +
                ", time_need=" + time_need +
                '}';
    }

    public void run()
    {
        try
        {

                //Запрашиваем у семафора разрешение на выполнение

                this.semExp.acquire();
            System.out.println ("Машина " +  this.number_car+" на парковке "+number_park );

                // машина заняла парковку
                sleep(time_need);
                System.out.println ("Машина " + this.number_car+" уехала c пакровки "+ number_park);
                if(number_park==1)
                    --pr1.now_car;
                else
                    --pr2.now_car;
            semExp.release();

        }
        catch(InterruptedException e)
        {

        }
    }

}
