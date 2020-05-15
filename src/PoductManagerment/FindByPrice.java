package PoductManagerment;
import MainRun.MainMenu;
import Product.Product;
import Product.MobilePhone;
import Product.WashingMachine;
import Product.Laptop;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class FindByPrice extends Manager implements I_Command {
    ArrayList<Product> myList = new ArrayList<>() ;
    int lowestPrice ;
    int highestPrice ;
    Product product;

    public FindByPrice(ProductManagerment manager) {
        super(manager);
    }
    public FindByPrice(ProductManagerment manager, int lowestPrice, int highestPrice) {
        super(manager);
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
    }

    public int getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public int getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(int highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    private void buildList(Class classes){
        for(int i=0; i< this.manager.getSize(); i++ ){
            product = this.manager.get(i);
            boolean listCondition = product.getClass() == classes && product.getPrice() >= lowestPrice && product.getPrice() <= highestPrice;
            if(listCondition){
                myList.add(this.product);
            }
        }
    }
    @Override
    public void excute() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int key = -1;
        while (key != 0){
            System.out.println("Choose a number to use these function below: ");
            System.out.println("0. Back");
            System.out.println("1. Máy giặt");
            System.out.println("2. Điện thoại");
            System.out.println("3. Laptop");
            int num = scan.nextInt();
            scan.nextLine();
            switch (num) {
                case 0:
                    CallMethod callFindProduct = new CallMethod(new FindProduct(this.manager));
                    callFindProduct.runMethod();
                case 1:
                    buildList(WashingMachine.class);
                    break;
                case 2:
                    buildList(MobilePhone.class);
                    break;
                case 3:
                    buildList(Laptop.class);
                    break;
                default:
                    System.out.println("not available");
            }
            LowToHightComparator myCompare = new LowToHightComparator();
            Collections.sort(myList, myCompare);
            System.out.println("List found: ");
            System.out.println("*****************************************************");
            Locale locale = new Locale("en", "EN");
            NumberFormat numberFormat = NumberFormat.getInstance(locale);
            for (int i = 0; i < myList.size(); i++) {
                product = this.myList.get(i);
                String price = numberFormat.format(product.getPrice());
//                System.out.println("No: " + (i + 1) + " price: " + price + "VNĐ, product: " + product.getName() + ", link: " + product.getLink());
                System.out.println(product.toString());
            }
            System.out.println("*****************************************************");
        }
    }
}
