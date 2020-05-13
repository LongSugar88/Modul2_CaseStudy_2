package PoductManagerment;
import Product.MobilePhone;
import Product.Laptop;
import Product.WashingMachine;
import Product.Product;
import Product.ProductFactory;
import Product.ProductType;

public class SetterProduct implements I_Command {
    ProductFactory productFactory = new ProductFactory();
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
        if(productInformation[2].equalsIgnoreCase("MobilePhone")){
            this.product = productFactory.creatProduct(ProductType.MOBILEPHONE);
            String id = productInformation[0];
            String name = productInformation[3];
            String brand = productInformation[4];
            int price = Integer.parseInt(productInformation[5]);
            String link = productInformation[6];
            String color = productInformation[1];
            product.setId(id);
            product.setName(name);
            product.setBrand(brand);
            product.setPrice(price);
            product.setLink(link);
            ((MobilePhone) product).setColor(color);
        }
        else if(productInformation[3].equalsIgnoreCase("Laptop")){
            this.product = productFactory.creatProduct(ProductType.LAPTOP);
            String id = productInformation[0];
            String name = productInformation[4];
            String brand = productInformation[5];
            int price = Integer.parseInt(productInformation[6]);
            String link = productInformation[7];
            String color = productInformation[1];
            String size = productInformation[2];
            product.setId(id);
            product.setName(name);
            product.setBrand(brand);
            product.setPrice(price);
            product.setLink(link);
            ((Laptop) product).setSize(size);
            ((Laptop) product).setColor(color);
        }
        else if(productInformation[2].equalsIgnoreCase("WashingMachine")){
            this.product = productFactory.creatProduct(ProductType.WASHINGMACHINE);
            String id = productInformation[0];
            String name = productInformation[3];
            String brand = productInformation[4];
            int price = Integer.parseInt(productInformation[5]);
            String link = productInformation[6];
            String type = productInformation[1];
            product.setId(id);
            product.setName(name);
            product.setBrand(brand);
            product.setPrice(price);
            product.setLink(link);
            ((WashingMachine) product).setType(type);
        }
    }
}
