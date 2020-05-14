package PoductManagerment;

import Product.Product;
import SourceProductInformation.SaveProductInformation;

public class AddProductManager extends Manager implements I_Command {
    private Product product;

    public AddProductManager(ProductManagerment manager) {
        super(manager);
    }

    public AddProductManager(ProductManagerment manager, Product product) {
        super(manager);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() {
        boolean isAddAvailable = true;
        if (this.manager.getSize() > 0) {
            for (int i = 0; i < this.manager.getSize(); i++) {
                String nameAdd = product.getName();
                String name = this.manager.get(i).getName();
                if (name.equalsIgnoreCase(nameAdd)) {
                    isAddAvailable = false;
                }
            }
        }
        if(isAddAvailable)
            this.manager.add(product);
    }
}
