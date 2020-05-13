package Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ProductFactory implements I_ProductFactory{
    private Product setterProduct(String[] productInformation) throws Exception {
        if(productInformation[2].equalsIgnoreCase("MobilePhone")){
            Product product = creatProduct(ProductType.MOBILEPHONE);
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
            return product;
        }
        else if(productInformation[3].equalsIgnoreCase("Laptop")){
            Product product = creatProduct(ProductType.LAPTOP);
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
            return product;
        }
        else if(productInformation[2].equalsIgnoreCase("WashingMachine")){
            Product product = creatProduct(ProductType.WASHINGMACHINE);
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
            return product;
        }
        throw new Exception("Product not available");
    }
    public void readFileText(String linkFileText) throws Exception {
        try {
            InputStream inputStream = new FileInputStream(linkFileText);
            byte[] bytes = new byte[2048];
            int length;
            while ((length = inputStream.read(bytes)) > 0){
                String line = new String (bytes, StandardCharsets.UTF_8);
                String[] content = line.split("\\|");
                setterProduct(content);
            }
            inputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public Product creatProduct(ProductType productType) {
        switch (productType){
            case MOBILEPHONE:
                return new MobilePhone();
            case LAPTOP:
                return new Laptop();
            case WASHINGMACHINE:
                return new WashingMachine();
            default:
                throw new NotImplementedException();
        }
    }
}
