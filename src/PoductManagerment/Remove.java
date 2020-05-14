package PoductManagerment;

import Product.Product;
import SourceProductInformation.SaveProductInformation;

public class Remove extends Manager implements I_Command {
    String id;
    Product product;
    FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, this.id);

    public Remove(ProductManagerment manager) {
        super(manager);
    }
    public Remove(ProductManagerment manager, String id){
        super(manager);
        this.id = id;
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
        this.manager.remove(index);
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }
}
