package PoductManagerment.FindElement;

import PoductManagerment.InterFace.I_Command;
import PoductManagerment.Manager;
import PoductManagerment.ProductManagerment;
import Product.Product;

public class FindByID extends Manager implements I_Command {
    boolean isFound = false;
    String id;
    Product product;

    public FindByID(ProductManagerment manager) {
        super(manager);
    }
    public FindByID(ProductManagerment manager, String id) {
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

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    @Override
    public void excute() {
        int count = 1;
        id = id.toUpperCase();
        System.out.println("List found: ");
        System.out.println("*****************************************************");
        if(this.manager.getSize() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i< this.manager.getSize(); i++ ){
            product = this.manager.get(i);
            String productID = product.getId().toUpperCase();
            if(productID.contains(id)){
                System.out.println("No: " + count + " |" +   product.toString());
                count++;
                isFound = true;
            }
        }
        System.out.println("*****************************************************");
    }
}
