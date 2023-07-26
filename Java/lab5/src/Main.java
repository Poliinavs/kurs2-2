import Shower.*;
import Park.*;
import Shower.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Park park1= new Park(1,1);
        Park park2= new Park(2,4);
        Semaphore sem1 = new Semaphore(park1.capacity);
        Semaphore sem2 = new Semaphore(park2.capacity);

        Car car1=new Car(1,2000,15,sem1,sem2,park1, park2 );
        Car car2=new Car(2,3000,10,sem1,sem2,park1, park2);
        Car car3=new Car(3,700,7,sem1,sem2,park1, park2);
        Car car4=new Car(4,8000,3,sem1,sem2,park1, park2);
        Car car5=new Car(5,11000,10,sem1,sem2,park1, park2);
        Car car6=new Car(6,1200 ,20,sem1,sem2,park1, park2);




        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);

        park1.Go_park(cars, park1, park2);
        Thread.sleep(13000);
        /////

        Shower shower1 = new Shower(3);
        Person pr1= new Person ("Анна", 20, Person.GenderType.WOMAN);
        Person pr2= new Person ("Егор", 10, Person.GenderType.MAN);
        Person pr3= new Person ("Антон", 15, Person.GenderType.MAN);
        Person pr4= new Person ("Лиза", 15, Person.GenderType.WOMAN);
        Person pr5= new Person ("Ксюша", 13, Person.GenderType.WOMAN);
        Person pr6= new Person ("Андрей", 30, Person.GenderType.MAN);
        Person pr7= new Person ("Анна", 30, Person.GenderType.WOMAN);
        Person pr8= new Person ("Дима", 10, Person.GenderType.MAN);
        Person pr9= new Person ("Дима", 5, Person.GenderType.MAN);

        shower1.pr.add(pr1);
        shower1.pr.add(pr2);
        shower1.pr.add(pr3);
        shower1.pr.add(pr4);
        shower1.pr.add(pr5);
        shower1.pr.add(pr6);
        shower1.pr.add(pr7);
        shower1.pr.add(pr8);
        shower1.pr.add(pr9);

       var Man= shower1.pr.stream()
                .filter(s->s.gn==Person.GenderType.MAN)
               .sorted((o1, o2) -> o1.time - o2.time)
               .collect(Collectors.toList());
        var Woman= shower1.pr.stream()
                .filter(s->s.gn==Person.GenderType.WOMAN)
                .sorted((o1, o2) -> o1.time - o2.time)
                .collect(Collectors.toList());
    ////////////////////////////////////////
try{
      Shower.TakeShower(Man,Woman);
}
catch (Exception ex){

}


        /////////////////////////////2




    }
}