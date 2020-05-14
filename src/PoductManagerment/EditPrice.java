package PoductManagerment;

import Product.Product;
import SourceProductInformation.SaveProductInformation;

public class EditPrice extends Manager implements I_Command {
    String id;
    int newPrice;
    Product product;
    FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, this.id);
    public EditPrice(ProductManagerment manager) {
        super(manager);
    }
    public EditPrice(ProductManagerment manager, int newPrice, String id){
        super(manager);
        this.newPrice = newPrice;
        this.id = id;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
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
        this.manager.get(index).setPrice(newPrice);
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }
}
