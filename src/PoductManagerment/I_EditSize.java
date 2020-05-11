package PoductManagerment;

import Product.ProductType;

public interface I_EditSize {
    boolean editSize(String id, double newSize, ProductType productType);
}
