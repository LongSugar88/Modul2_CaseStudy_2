package SourceProductInformation;
import PoductManagerment.I_Command;
import PoductManagerment.Manager;
import PoductManagerment.ProductManagerment;
import Product.Product;
import Product.MobilePhone;
import Product.WashingMachine;
import Product.Laptop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SaveProductInformation extends Manager implements I_Command {
    String linkFileSave = "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt";
    Product product;

    public SaveProductInformation(ProductManagerment manager) {
        super(manager);
    }
    public SaveProductInformation(ProductManagerment manager, String linkFileSave) {
        super(manager);
        this.linkFileSave = linkFileSave;
    }

    public String getLinkFileSave() {
        return linkFileSave;
    }

    public void setLinkFileSave(String linkFileSave) {
        this.linkFileSave = linkFileSave;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() {
        try {
            OutputStream outputStream = new FileOutputStream(linkFileSave);
            byte[] bytes = new byte[2048];
            for (int i = 0; i < this.manager.getSize(); i++) {
                product = this.manager.get(i);
                StringBuilder myString = new StringBuilder();
                myString.append(product.getId());
                myString.append(",");
                myString.append(product.getName());
                myString.append(",");
                myString.append(product.getBrand());
                myString.append(",");
                myString.append(product.getPrice());
                myString.append(",");
                myString.append(product.getLink());
                myString.append(",");
                if (product instanceof MobilePhone) {
                    myString.append("MobilePhone");
                    myString.append(",");
                    myString.append(((MobilePhone) product).getColor());
                } else if (product instanceof WashingMachine) {
                    myString.append("WashingMachine");
                    myString.append(",");
                    myString.append(((WashingMachine) product).getType());
                } else if (product instanceof Laptop) {
                    myString.append("Laptop");
                    myString.append(",");
                    myString.append(((Laptop) product).getColor());
                    myString.append(",");
                    myString.append(((Laptop) product).getSize());
                }
                outputStream.write(myString.toString().getBytes());
                outputStream.write("\n".getBytes());
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
