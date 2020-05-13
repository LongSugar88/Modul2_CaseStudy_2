package PoductManagerment;
import Product.Product;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReadFileText extends AddProductManager{
    SetterProduct setterProduct = new SetterProduct();

    public ReadFileText(ProductManagerment manager) {
        super(manager);
    }

    public void ReadFile(String linkFileText) {
        try {
//            InputStream inputStream = new FileInputStream(linkFileText);
//            byte[] bytes = new byte[2048];
//            int length;
//            while ((length = inputStream.read(bytes)) > 0){
//                String line = new String (bytes, StandardCharsets.UTF_8);
//                String[] content = line.split(",");
//                setterProduct.setProductInformation(content);
//                setterProduct.excute();
//                Product product = setterProduct.getProduct();
//                this.manager.add(product);
//            }
//            inputStream.close();
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
                Product product = setterProduct.getProduct();
                this.manager.add(product);
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
