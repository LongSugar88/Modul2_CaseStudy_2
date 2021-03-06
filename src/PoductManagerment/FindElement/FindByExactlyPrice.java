package PoductManagerment.FindElement;

import PoductManagerment.InterFace.I_Command;
import PoductManagerment.Manager;
import PoductManagerment.ProductManagerment;
import Product.Product;

public class FindByExactlyPrice extends Manager implements I_Command {
    int price;
    Product product;

    public FindByExactlyPrice(ProductManagerment manager) {
        super(manager);
    }
    public FindByExactlyPrice(ProductManagerment manager, int price) {
        super(manager);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() {
        int count = 1;
        System.out.println("List found: ");
        System.out.println("*****************************************************");
        if(this.manager.getSize() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i<this.manager.getSize(); i++ ){
            product = this.manager.get(i);
            if(product.getPrice() == price){
                System.out.println("No: " + count + " |" +   product.toString());
                count++;
            }
        }
        System.out.println("*****************************************************");
    }
}
