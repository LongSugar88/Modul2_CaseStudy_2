package PoductManagerment;

import Product.Product;

public interface I_ProductManager {
    boolean add();
    boolean edit();
    Product remove();
    int size();
}
