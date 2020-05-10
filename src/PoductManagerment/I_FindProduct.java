package PoductManagerment;

public interface I_FindProduct {
    void findByName(String name);
    void findByID(String id);
    void findByExactlyPrice(int price);
    void findByPrice(int lowestPrice, int highestPrice);
}
