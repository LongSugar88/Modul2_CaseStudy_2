package PoductManagerment;

import Product.Product;

public class FindByPrice extends Manager implements I_Command {
    int price;
    Product product;

    public FindByPrice(ProductManagerment manager) {
        super(manager);
    }
    public FindByPrice(ProductManagerment manager, int price) {
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
        if(this.manager.getSize() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        int lowestPrice = (int) Math.floor(price*0.8);
        int highestPrice =(int) Math.floor(price*1.2);
        for(int i=0; i<this.manager.getSize(); i++ ){
            if(this.manager.get(i).getPrice() >= lowestPrice && this.manager.get(i).getPrice() <= highestPrice){
                System.out.println("Index's product: "+ i+ " "+ this.manager.get(i).toString());
            }
        }
    }
}