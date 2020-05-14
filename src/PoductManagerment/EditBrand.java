package PoductManagerment;

import Product.Product;
import SourceProductInformation.SaveProductInformation;

public class EditBrand extends Manager implements I_Command {
    String id;
    String newBrand;
    Product product;
    FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, this.id);
    public EditBrand(ProductManagerment manager) {
        super(manager);
    }
    public EditBrand(ProductManagerment manager, String newBrand, String id){
        super(manager);
        this.newBrand = newBrand;
        this.id = id;
    }

    public String getNewBrand() {
        return newBrand;
    }

    public void setNewBrand(String newBrand) {
        this.newBrand = newBrand;
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
        this.manager.get(index).setBrand(newBrand);
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }
}
