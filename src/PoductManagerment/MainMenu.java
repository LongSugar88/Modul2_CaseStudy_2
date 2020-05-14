package PoductManagerment;

import PoductManagerment.*;
import Product.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainMenu {
    public static void menu() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int key = -1;
        while (key != 0){
            ProductManagerment productManagerment = new ProductManagerment();
            ReadFileText readFileText = new ReadFileText(productManagerment, "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt");
            CalledByMethod callReadFileText = new CalledByMethod(readFileText);
            callReadFileText.runMethod();
            System.out.println(productManagerment.getSize());
            System.out.println("Choose a number to use these function below: ");
            System.out.println("0. Exit");
            System.out.println("1. Edit product's information");
            System.out.println("2. Find product by name");
            System.out.println("3. Find product by brand");
            System.out.println("4. Find product by ID");
            System.out.println("5. Find product by price");
            System.out.println("6. Find product by exactly price ");
            System.out.println("7. Find cheapest product by name");
            System.out.println("8. Find expensivest product by name");
            int num = scan.nextInt();
            scan.nextLine();
            switch (num){
                case 0:
                    System.exit(0);
                case 1:
                    CalledByMethod callEditProduct = new CalledByMethod(new EditProduct(productManagerment));
                    callEditProduct.runMethod();
                    break;
                case 2:
                    System.out.println("Enter name to find: ");
                    String name = scan.nextLine();
                    CalledByMethod callFindByName = new CalledByMethod(new FindByName(productManagerment, name));
                    callFindByName.runMethod();
                    break;
                case 3:
                    System.out.println("Enter brand to find: ");
                    String brand = scan.nextLine();
                    CalledByMethod callFindByBrand = new CalledByMethod(new FindByBrand(productManagerment, brand));
                    callFindByBrand.runMethod();
                    break;
                case 4:
                    System.out.println("Enter ID to find: ");
                    String id = scan.nextLine();
                    CalledByMethod callFindByID = new CalledByMethod(new FindByID(productManagerment, id));
                    callFindByID.runMethod();
                    break;
                case 5:
                    System.out.println("Enter lowest price to find: ");
                    int lowest = scan.nextInt();
                    System.out.println("Enter hightest price to find: ");
                    int highest = scan.nextInt();
                    scan.nextLine();
                    CalledByMethod callFindByPrice = new CalledByMethod(new FindByPrice(productManagerment, lowest, highest));
                    callFindByPrice.runMethod();
                    break;
                case 6:
                    System.out.println("Enter a exactly price to find: ");
                    int priceToFindExactly = scan.nextInt();
                    scan.nextLine();
                    CalledByMethod callFindByExactlyPrice = new CalledByMethod(new FindByExactlyPrice(productManagerment, priceToFindExactly));
                    callFindByExactlyPrice.runMethod();
                    break;
                case 7:
                    System.out.println("Enter product's name to find: ");
                    String keyToFindCheaperPrice = scan.nextLine();
                    SortProductPriceByLowToHight mySortTool = new SortProductPriceByLowToHight(productManagerment, keyToFindCheaperPrice);
                    mySortTool.excute();
                    break;
                case 8:
                default: System.out.println("not available");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        menu();
    }
}
