package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDAO sellerDAO = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDAO.findByDepartment(dep);
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDAO.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Matheus", "matheus@email.com", new Date(), 78000.0, dep);
        sellerDAO.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
    }
}
