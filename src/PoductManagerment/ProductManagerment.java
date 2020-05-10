package PoductManagerment;

import Product.Product;

import java.util.ArrayList;

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
        return false;
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
                System.out.println(myProduct.get(i));
            }
        }
    }

    @Override
    public void findByID(String id) {
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getId().contains(id)){
                System.out.println(myProduct.get(i));
            }
        }
    }
    public void findByBrand(String brand){
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getBrand().contains(brand)){
                System.out.println(myProduct.get(i));
            }
        }
    }
    @Override
    public void findByExactlyPrice(int price) {
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getPrice() == price){
                System.out.println(myProduct.get(i));
            }
        }
    }

    @Override
    public void findByPrice(int lowestPrice, int highestPrice) {
        if(MYLIST_SIZE == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<MYLIST_SIZE; i++ ){
            if(myProduct.get(i).getPrice() >= lowestPrice && myProduct.get(i).getPrice() <= highestPrice){
                System.out.println(myProduct.get(i));
            }
        }
    }

    @Override
    public boolean editName(String name) {
        return false;
    }

    @Override
    public boolean editID(String id) {
        return false;
    }

    @Override
    public boolean editPrice(String name) {
        return false;
    }
}
