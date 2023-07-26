package Shower;

public class Person {
    public enum GenderType {
        MAN,
        WOMAN
    }
    public String Name;
    public int time;
    public GenderType gn;

  /*  public Woman wm=new Woman();
    public Man mn= new Man();*/

    public Person(String name, int time, GenderType gn) {
        Name = name;
        this.time = time;
        this.gn = gn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", time in shower=" + time +
                ", Gender=" + gn +
                '}'+'\n';
    }




}
