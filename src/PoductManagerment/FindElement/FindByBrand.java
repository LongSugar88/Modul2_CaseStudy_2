package PoductManagerment.FindElement;

import PoductManagerment.InterFace.I_Command;
import PoductManagerment.Manager;
import PoductManagerment.ProductManagerment;
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
        int count = 1;
        brand = brand.toUpperCase();
        System.out.println("List found: ");
        System.out.println("*****************************************************");
        if(this.manager.getSize() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i< this.manager.getSize(); i++ ){
            product = this.manager.get(i);
            String productBrand = product.getBrand().toUpperCase();
            if(productBrand.contains(brand)){
                System.out.println("No: " + count + " |" +   product.toString());
                count++;
            }
        }
        System.out.println("*****************************************************");
    }
}
