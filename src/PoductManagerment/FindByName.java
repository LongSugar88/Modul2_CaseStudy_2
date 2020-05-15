package PoductManagerment;

import Product.Product;

public class FindByName extends Manager implements I_Command {
    boolean isFound = false;
    String name;
    Product product;
    public FindByName(ProductManagerment manager) {
        super(manager);
    }
    public FindByName(ProductManagerment manager, String name) {
        super(manager);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public boolean isFound() {
        return isFound;
    }
    public void setFound(boolean found) {
        isFound = found;
    }

    @Override
    public void excute() {
        name = name.toUpperCase();
        System.out.println("List found: ");
        System.out.println("*****************************************************");
        if(this.manager.getSize() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i< this.manager.getSize(); i++ ){
            product = this.manager.get(i);
            String productName = product.getName().toUpperCase();
            if(productName.contains(name)){
                System.out.println(product.toString());
                isFound = true;
            }
        }
        System.out.println("*****************************************************");
    }
}
