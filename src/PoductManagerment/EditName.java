package PoductManagerment;

import Product.Product;
import SourceProductInformation.SaveProductInformation;

public class EditName extends Manager implements I_Command{
    String id;
    String newName;
    Product product;
    FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, this.id);
    public EditName(ProductManagerment manager) {
        super(manager);
    }
    public EditName(ProductManagerment manager, String newName, String id){
        super(manager);
        this.newName = newName;
        this.id = id;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() {
        int index = findProductIndexByID.getIndex();
        this.manager.get(index).setName(newName);
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }
}
