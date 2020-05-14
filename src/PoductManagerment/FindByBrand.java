package PoductManagerment;

import Product.Product;

public class FindByBrand extends Manager implements I_Command {
    boolean isFound = false;
    String brand;
    Product product;
    public FindByBrand(ProductManagerment manager) {
        super(manager);
    }
    public FindByBrand(ProductManagerment manager, String brand) {
        super(manager);
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
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
        brand = brand.toUpperCase();
        if(this.manager.getSize() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i< this.manager.getSize(); i++ ){
            product = this.manager.get(i);
            String productName = product.getName().toUpperCase();
            if(productName.contains(brand)){
                System.out.println(product.toString());
            }
        }
    }
}
