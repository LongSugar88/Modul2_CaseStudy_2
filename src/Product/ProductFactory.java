package Product;
import PoductManagerment.I_Command;
import PoductManagerment.Manager;
import PoductManagerment.ProductManagerment;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ProductFactory implements I_ProductFactory {
//public void readFileText(String linkFileText) throws Exception {
//    try {
//        File file = new File(linkFileText);
//        if(!file.exists()){
//            throw new FileNotFoundException("File not found");
//        }
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line;
//        while ((line = bufferedReader.readLine()) != null){
//            String[] content = line.split(",");
//            System.out.println(content[0]);
//            System.out.println(content[1]);
//            System.out.println(content[2]);
//            System.out.println(content[3]);
//            System.out.println(content[4]);
//        }
//        bufferedReader.close();
//    }
//    catch (IOException e){
//        e.printStackTrace();
//    }
//}
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
