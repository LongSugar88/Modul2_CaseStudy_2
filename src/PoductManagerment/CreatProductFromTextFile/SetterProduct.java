package PoductManagerment.CreatProductFromTextFile;
import PoductManagerment.Enum.ProductType;
import PoductManagerment.InterFace.I_Command;
import Product.MobilePhone;
import Product.Laptop;
import Product.WashingMachine;
import Product.Product;
import Product.ProductFactory;

public class SetterProduct implements I_Command {
    private Product product ;
    private String[] productInformation;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String[] getProductInformation() {
        return productInformation;
    }
    public void setProductInformation(String[] productInformation) {
        this.productInformation = productInformation;
    }
    @Override
    public void excute(){
        String id ;
        String name ;
        String brand ;
        int price ;
        String link ;
        if(productInformation[5].equalsIgnoreCase("MobilePhone")){
            ProductFactory productFactory = new ProductFactory(ProductType.MOBILEPHONE);
            productFactory.excute();
            this.product = productFactory.getProduct();
            String color = productInformation[6];
            ((MobilePhone) product).setColor(color);
        }
        else if(productInformation[5].equalsIgnoreCase("Laptop")){
            ProductFactory productFactory = new ProductFactory(ProductType.LAPTOP);
            productFactory.excute();
            this.product = productFactory.getProduct();
            String color = productInformation[6];
            String size = productInformation[7];
            ((Laptop) product).setSize(size);
            ((Laptop) product).setColor(color);
        }
        else if(productInformation[5].equalsIgnoreCase("WashingMachine")){
            ProductFactory productFactory = new ProductFactory(ProductType.WASHINGMACHINE);
            productFactory.excute();
            this.product = productFactory.getProduct();
            String type = productInformation[6];
            ((WashingMachine) product).setType(type);
        }
        id = productInformation[0];
        name = productInformation[1];
        brand = productInformation[2];
        price = Integer.parseInt(productInformation[3]);
        link = productInformation[4];
        product.setId(id);
        product.setName(name);
        product.setBrand(brand);
        product.setPrice(price);
        product.setLink(link);
    }
}
