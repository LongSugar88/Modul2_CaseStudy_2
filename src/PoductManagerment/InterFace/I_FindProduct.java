package PoductManagerment.InterFace;

import java.io.FileNotFoundException;

public interface I_FindProduct {
    void findByName(String name);
    void findByID(String id);
    void findByExactlyPrice(int price);
    void findByPrice(int lowPrice, int hightPrice) throws FileNotFoundException;
}
