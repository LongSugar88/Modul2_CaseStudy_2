package PoductManagerment;

import MainRun.MainMenu;
import Product.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindProduct extends Manager implements I_Command {
    Product product;

    public FindProduct(ProductManagerment manager) {
        super(manager);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int key = -1;
        while (key != 0) {
            System.out.println("0. Back");
            System.out.println("1. Find product by name");
            System.out.println("2. Find product by brand");
            System.out.println("3. Find product by ID");
            System.out.println("4. Find product by price");
            System.out.println("5. Find product by exactly price ");
            int num = scan.nextInt();
            scan.nextLine();
            switch (num) {
                case 0:
                    MainMenu.menu();
                case 1:
                    System.out.println("Enter name to find: ");
                    String name = scan.nextLine();
                    CallMethod callFindByName = new CallMethod(new FindByName(this.manager, name));
                    callFindByName.runMethod();
                    break;
                case 2:
                    System.out.println("Enter brand to find: ");
                    String brand = scan.nextLine();
                    CallMethod callFindByBrand = new CallMethod(new FindByBrand(this.manager, brand));
                    callFindByBrand.runMethod();
                    break;
                case 3:
                    System.out.println("Enter ID to find: ");
                    String id = scan.nextLine();
                    CallMethod callFindByID = new CallMethod(new FindByID(this.manager, id));
                    callFindByID.runMethod();
                    break;
                case 4:
                    System.out.println("Enter lowest price to find: ");
                    int lowest = scan.nextInt();
                    System.out.println("Enter hightest price to find: ");
                    int highest = scan.nextInt();
                    scan.nextLine();
                    CallMethod callFindByPrice = new CallMethod(new FindByPrice(this.manager, lowest, highest));
                    callFindByPrice.runMethod();
                    break;
                case 5:
                    System.out.println("Enter a exactly price to find: ");
                    int priceToFindExactly = scan.nextInt();
                    scan.nextLine();
                    CallMethod callFindByExactlyPrice = new CallMethod(new FindByExactlyPrice(this.manager, priceToFindExactly));
                    callFindByExactlyPrice.runMethod();
                    break;
                default:
                    System.out.println("not available");
            }
        }
    }
}
