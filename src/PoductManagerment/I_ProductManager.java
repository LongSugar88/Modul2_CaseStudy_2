package PoductManagerment;

import Product.Product;

public interface I_ProductManager {
    void add(Product product);
    void edit(int index);
    Product remove(int index);
}
