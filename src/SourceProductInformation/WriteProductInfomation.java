package SourceProductInformation;

import Product.Product;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteProductInfomation {
    public static String splitPrice(String price){
        if(price.length() > 11){
            price = price.substring(8, 18);
        }
        price = price.replaceAll("\\.", "");
        price = price.replaceAll("₫", "");
        return price;
    }
    public static String filterBrand(String name){
        name = name.toUpperCase();
        if(name.contains("SAM")){
            return "Samsung";
        }
        else if(name.contains("PANA")){
            return "Panasonic";
        }
        else if(name.contains("LG")){
            return "LG";
        }
        else if(name.contains("ELEC")){
            return "Electrolux";
        }
        else if(name.contains("AQUA")){
            return "Aqua";
        }
        else if(name.contains("TOSHI")){
            return "Toshiba";
        }
        return "";
    }

    public static void getProductInformation(String linkContent, String linkFileText, String type){
        try{
            URL url = new URL(linkContent);
            File file = new File(linkFileText);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Scanner scan = new Scanner(url.openStream());
            scan.useDelimiter("\\Z");
            String content = scan.next();
            content = content.replaceAll("\n", "");
            Pattern patternSourceLinkProduct = Pattern.compile("</div><h6><a href=\"(.+?)\">");
            Pattern patternNameAndPriceProduct = Pattern.compile(".html\">(.+?)</a></h6><div class=\"(.+?)\">" +
                    "<span(.+?)class=\"price\">(.+?)</span>");
            Matcher link = patternSourceLinkProduct.matcher(content);
            Matcher NameAndPrice = patternNameAndPriceProduct.matcher(content);
            int count = 0;
            while (link.find() && NameAndPrice.find()){
                count++;
                System.out.println(count + "|" + NameAndPrice.group(1)+ "|" + NameAndPrice.group(4)+ "|" + link.group(1));
                String productInformation = "PicoW00"+count+"|"+type+"|"+NameAndPrice.group(1)+ "|" +filterBrand(NameAndPrice.group(1))+"|"+ splitPrice(NameAndPrice.group(4))+ "|" + link.group(1)+"|"+"normal";
                fileOutputStream.write(productInformation.getBytes());
                fileOutputStream.write("\n".getBytes());
            }
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void convertInformation(Product product){

    }
    public static void main(String[] args) {
        getProductInformation("https://pico.vn/may-giat-nhom-72.html", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine");
    }
}
