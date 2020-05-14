package PoductManagerment;

import Product.Product;

public class RemoveProductByIndexManager extends Manager implements I_Command {
    int index;
    Product product;
    public RemoveProductByIndexManager(ProductManagerment manager) {
        super(manager);
    }
    public RemoveProductByIndexManager(ProductManagerment manager, int index){
        super(manager);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() {
        this.product = this.manager.get(index);
        this.manager.remove(index);
    }
}
