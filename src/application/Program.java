package application;

import entities.Product;
import util.UpperCaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        Function<Product, String> func = product -> product.getName().toUpperCase();


        //List<String> uppercase = list.stream().map(new UpperCaseName()).collect(Collectors.toList()); interface implementation
        //List<String> uppercase = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList()); static method reference
        //List<String> uppercase = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList()); non-static method reference
        //List<String> uppercase = list.stream().map(func).collect(Collectors.toList()); declared lambda expression
        List<String> uppercase = list.stream().map(product -> product.getName().toUpperCase()).collect(Collectors.toList());

        uppercase.forEach(System.out::println);
    }
}
