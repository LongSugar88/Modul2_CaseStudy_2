package PoductManagerment;

import Product.Product;
import SourceProductInformation.SaveProductInformation;

public class AddProductManager extends Manager implements I_Command {
    private Product product;

    public AddProductManager(ProductManagerment manager) {
        super(manager);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() {
        this.manager.add(product);
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }
}
