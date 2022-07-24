package boundedWildcard.application;

import java.util.ArrayList;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        //COVARIÂNCIA
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(5);

        List<? extends Number> list = intList;

        Number x = list.get(0);

        //list.add(20); Erro de compilação

        //-------------------------------------------------------


        //CONTRAVARIÂNCIA
        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");

        List<? super Number> myNums = myObjs;

        myNums.add(10);
        myNums.add(3.14);

        //Number y = myNums.get(0); Erro de compilação, o tipo do valor pode ser uma superclasse de Number e não Number
    }
}
