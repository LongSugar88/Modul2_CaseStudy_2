package PoductManagerment;

import Product.Product;

import java.io.FileNotFoundException;

public interface I_ProductManager {
    void add(Product product);
    void edit(int index) throws FileNotFoundException;
    Product remove(int index);
    Product get(int index);
}
