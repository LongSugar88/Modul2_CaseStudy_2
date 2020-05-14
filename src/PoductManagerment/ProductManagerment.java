package PoductManagerment;
import Product.Product;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductManagerment implements I_ProductManager, I_FindProduct, I_EditProduct, I_EditType, I_EditColor, I_EditSize {
    private ArrayList<Product> myProduct = new ArrayList<>();

    @Override
    public void add(Product element) {
        AddProductManager addProduct = new AddProductManager(this, element);
        addProduct.excute();
    }
    @Override
    public void edit(int index) throws FileNotFoundException {
        EditProduct editProduct = new EditProduct(this);
        editProduct.excute();
    }

    @Override
    public Product remove(int index) {
        Product token = myProduct.get(index);
        myProduct.remove(index);
        return token;
    }
    public int getSize(){
        return myProduct.size();
    }

    @Override
    public Product get(int index) {
        return myProduct.get(index);
    }

    @Override
    public void editColor(String newColor, String id, ProductType productType) {
        EditColor editColor = new EditColor(this, newColor, id , productType );
        editColor.excute();
    }

    @Override
    public void editName(String newName, String id) {
        EditName editName = new EditName(this, newName, id );
        editName.excute();
    }

    @Override
    public void editID(String newID, String id) {
        EditID editID = new EditID(this, newID, id);
        editID.excute();
    }

    @Override
    public void editPrice(int newPrice, String id) {
        EditPrice editPrice = new EditPrice(this, newPrice, id);
        editPrice.excute();
    }

    @Override
    public void editSize(String newSize, String id, ProductType productType) {
        EditSize editSize = new EditSize(this, newSize, id , productType );
        editSize.excute();
    }

    @Override
    public void editType(String newType, String id, ProductType productType) {
        EditType editType = new EditType(this, newType, id , productType );
        editType.excute();
    }

    @Override
    public void findByName(String name) {
        FindByName findByName = new FindByName(this, name);
        findByName.excute();
    }

    @Override
    public void findByID(String id) {
        FindByID findByID = new FindByID(this, id);
        findByID.excute();
    }

    @Override
    public void findByExactlyPrice(int price) {
        FindByExactlyPrice findByExactlyPrice = new FindByExactlyPrice(this, price);
        findByExactlyPrice.excute();
    }

    @Override
    public void findByPrice(int lowPrice, int hightPrice) throws FileNotFoundException {
        FindByPrice findByPrice = new FindByPrice(this, lowPrice, hightPrice);
        findByPrice.excute();
    }
}
