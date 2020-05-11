package PoductManagerment;

public interface I_EditProduct {
    boolean editName(String id, String newName);
    boolean editID(String id, String newID);
    boolean editPrice(String id,  int newPrice);
}
