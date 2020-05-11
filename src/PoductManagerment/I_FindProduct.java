package PoductManagerment;

public interface I_FindProduct {
    boolean findByName(String name);
    boolean findByID(String id);
    void findByExactlyPrice(int price);
    boolean findByPrice(int lowestPrice, int highestPrice);
}
