package PoductManagerment;

import Product.Product;
import SourceProductInformation.SaveProductInformation;

public class EditID extends Manager implements I_Command {
    String id;
    String newID;
    Product product;
    FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, this.id);
    public EditID(ProductManagerment manager) {
        super(manager);
    }
    public EditID(ProductManagerment manager, String newID, String id){
        super(manager);
        this.newID = newID;
        this.id = id;
    }

    public String getNewID() {
        return newID;
    }

    public void setNewID(String newID) {
        this.newID = newID;
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
            this.manager.get(index).setId(newID);
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }
}
