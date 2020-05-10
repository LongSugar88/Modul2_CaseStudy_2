package PoductManagerment;

import Product.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagerment implements I_ProductManager, I_FindProduct, I_EditProduct {
    ArrayList<Product> myProduct = new ArrayList<>();
    final int MYLIST_SIZE = myProduct.size();

    @Override
    public void add(Product element) {
        int index = myProduct.size()-1;
        if(myProduct.size() == 0){
            myProduct.add(element);
        }
        else {
            myProduct.add(index, element);
        }
    }

    @Override
    public boolean edit(int index) {
        System.out.println("Index's product: "+ index+ " "+ myProduct.get(index).toString());
        int key = 0;
        while (key != 0){
            System.out.println("Choose a number to use these function below: ");
            System.out.println("1. Edit ID's product");
            System.out.println("2. Edit name's product");
            System.out.println("3. Edit price's product");
            System.out.println("4. Edit brand's product");
            System.out.println("5. Edit color's product");
            System.out.println("6. Edit type's product");
            System.out.println("7. Edit size's product");
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            scan.nextLine();
            switch (num){
                case 1:

            }
        }

    }

    @Override
    public Product remove(int index) {

        return null;
    }


    @Override
    public void findByName(String name) {
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getName().contains(name)){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
            }
        }
    }

    @Override
    public void findByID(String id) {
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getId().contains(id)){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
            }
        }
    }
    public void findByBrand(String brand){
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getBrand().contains(brand)){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
            }
        }
    }
    @Override
    public void findByExactlyPrice(int price) {
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getPrice() == price){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
            }
        }
    }

    @Override
    public void findByPrice(int lowestPrice, int highestPrice) {
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getPrice() >= lowestPrice && myProduct.get(i).getPrice() <= highestPrice){
                System.out.println("Index's product: "+ i+ " "+ myProduct.get(i).toString());
            }
        }
    }
    private int findIndexProductByName(String name){
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    private int findIndexProductByID(String id){
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }
    private int findIndexProductByBrand(String brand){
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getBrand().equalsIgnoreCase(brand)){
                return i;
            }
        }
        return -1;
    }
    private int findIndexProductByPrice(int price){
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getPrice() == price){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean editName(String name) {
        int index = findIndexProductByName(name);
        if(index < 0)
            return false;
        myProduct.get(index).setName(name);
        return true;
    }

    @Override
    public boolean editID(String id) {
        int index = findIndexProductByID(id);
        if(index < 0)
            return false;
        myProduct.get(index).setId(id);
        return true;
    }
    public boolean editBrand(String brand) {
        int index = findIndexProductByID(brand);
        if(index < 0)
            return false;
        myProduct.get(index).setId(brand);
        return true;
    }
    @Override
    public boolean editPrice(int price) {
        int index = findIndexProductByPrice(price);
        if(index < 0)
            return false;
        myProduct.get(index).setPrice(price);
        return true;
    }
}
