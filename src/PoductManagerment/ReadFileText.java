package PoductManagerment;
import Product.Product;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReadFileText extends Manager implements I_Command{
    String linkFileText;
    Product product;

    SetterProduct setterProduct = new SetterProduct();
    public ReadFileText(ProductManagerment manager) {
        super(manager);
    }
    public ReadFileText(ProductManagerment manager, String linkFileText){
        super(manager);
        this.linkFileText = linkFileText;
    }

    public String getLinkFileText() {
        return linkFileText;
    }

    public void setLinkFileText(String linkFileText) {
        this.linkFileText = linkFileText;
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
        File file = new File(linkFileText);
        if(!file.exists()){
            throw new FileNotFoundException("File not found");
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null){
            String[] content = line.split(",");
                setterProduct.setProductInformation(content);
                setterProduct.excute();
                product = setterProduct.getProduct();
            AddProductManager addProduct = new AddProductManager(this.manager, product);
            addProduct.excute();
        }
        bufferedReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
