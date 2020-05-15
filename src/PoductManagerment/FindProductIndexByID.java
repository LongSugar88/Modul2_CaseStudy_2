package PoductManagerment;

import Product.Product;

public class FindProductIndexByID extends Manager implements I_Command {
    int index;
    String id;
    Product product;

    public FindProductIndexByID(ProductManagerment manager) {
        super(manager);
    }
    public FindProductIndexByID(ProductManagerment manager, String id){
        super(manager);
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getIndex() {
        excute();
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
        for(int i=0; i<this.manager.getSize(); i++ ){
            if(this.manager.get(i).getId().equalsIgnoreCase(id)){
                this.index = i;
            }
        }
    }
}
