package ex2;

import java.util.LinkedList;

public class name {
    public static LinkedList<String> names= new LinkedList<>();
    public static synchronized  void addname(String name){
        names.add(name);
    }
}
