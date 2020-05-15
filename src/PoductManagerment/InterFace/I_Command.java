package PoductManagerment.InterFace;

import Product.Product;

import java.io.FileNotFoundException;

public interface I_Command {
    void excute() throws FileNotFoundException;
}
