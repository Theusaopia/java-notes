package hashCodeAndEquals.application;

import hashCodeAndEquals.entities.Client;

public class Program {
    public static void main(String[] args) {
        Client c1 = new Client("Maria", "Maria@gmail.com");
        Client c2 = new Client("Alex", "Maria@gmail.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));

        System.out.println(c1 == c2); //will return false because it compares objects through the position in heap memory
        //this will not occur if declared in literal way
        //String x = "bla bla" will compare by content
        //String x = new String("bla bla") will compare by heap position
    }
}
