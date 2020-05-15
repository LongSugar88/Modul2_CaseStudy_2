package MainRun;

import PoductManagerment.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainMenu {
    public static void menu() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int key = -1;
        while (key != 0){
            ProductManagerment productManagerment = new ProductManagerment();
            ReadFileText readFileText = new ReadFileText(productManagerment, "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt");
            CallMethod callReadFileText = new CallMethod(readFileText);
            callReadFileText.runMethod();
            System.out.println("Choose a number to use these function below: ");
            System.out.println("0. Exit");
            System.out.println("1. Edit product's information");
            System.out.println("2. Find product's information");
            System.out.println("3. Find cheapest product by name");
            System.out.println("4. Remove product");
            int num = scan.nextInt();
            scan.nextLine();
            switch (num){
                case 0:
                    System.exit(0);
                case 1:
                    CallMethod callEditProduct = new CallMethod(new EditProduct(productManagerment));
                    callEditProduct.runMethod();
                    break;
                case 2:
                    CallMethod callFindProduct = new CallMethod(new FindProduct(productManagerment));
                    callFindProduct.runMethod();
                    break;
                case 3:
                    System.out.println("Enter product's name to find: ");
                    String keyToFindCheaperPrice = scan.nextLine();
                    SortProductPriceByLowToHight mySortTool = new SortProductPriceByLowToHight(productManagerment, keyToFindCheaperPrice);
                    mySortTool.excute();
                    break;
                case 4:
                    System.out.println("Enter product's ID to remove: ");
                    String iDtoRemove = scan.nextLine();
                    Remove remove = new Remove(productManagerment, iDtoRemove);
                    remove.excute();
                    break;
                default: System.out.println("not available");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        menu();
    }
}
