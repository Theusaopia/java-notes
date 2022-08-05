package application;

import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        Predicate<Product> pred = p -> p.getPrice() >= 100;

        //list.removeIf(new ProductPredicate()); interface implementation
        //list.removeIf(Product::staticProductPredicate); method reference (static)
        //list.removeIf(Product::nonStaticProductPredicate); method reference (non static)
        //list.removeIf(pred); declared lambda expression
        list.removeIf(p -> p.getPrice() >= 100); //lambda expression inline

        for(Product p : list) {
            System.out.println(p);
        }
    }
}
