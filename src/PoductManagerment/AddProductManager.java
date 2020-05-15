package PoductManagerment;
import PoductManagerment.InterFace.I_Command;
import Product.Product;

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
                String nameAdd = product.getName().toUpperCase();
                String name = this.manager.get(i).getName().toUpperCase();
                String idAdd = product.getId().substring(0,4).toUpperCase();
                String id = this.manager.get(i).getId().substring(0,4).toUpperCase();
                if (id.equals(idAdd) && name.equals(nameAdd)) {
                    isAddAvailable = false;
                }
            }
        }
        if(isAddAvailable)
            this.manager.add(product);
    }
}
