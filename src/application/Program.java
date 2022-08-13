package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1, "Boooks");
        Seller seller = new Seller(1, "Bob", "bob@email.com", new Date(), 2000.0, obj);

        SellerDAO sellerDAO = DaoFactory.createSellerDao();

        System.out.println(obj);
        System.out.println(seller);
    }
}
