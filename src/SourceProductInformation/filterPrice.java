package SourceProductInformation;

import Product.Product;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class filterPrice {
    static int count = 0;
    public static String splitPrice(String price){
        if(price.length() > 11){
            price = price.substring(8, 18);
        }
        price = price.replaceAll("\\.", "");
        price = price.replaceAll("₫", "");
        return price;
    }
    public static String filterColor(String name){
        name = name.toUpperCase();
        if(name.contains("RED")){
            return "red";
        }
        else if(name.contains("YELLOW")){
            return "Yellow";
        }
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
        else if(name.contains("NOKIA")){
            return "Nokia";
        }
        else if(name.contains("OPPO")){
            return "Oppo";
        }
        else if(name.contains("IPHON")){
            return "iPhone";
        }
        else if(name.contains("HUAW")){
            return "Huawei";
        }
        else if(name.contains("HP")){
            return "HP";
        }
        else if(name.contains("DELL")){
            return "Dell";
        }
        else if(name.contains("ASUS")){
            return "Asus";
        }
        else if(name.contains("LENOVO")){
            return "Lenovo";
        }
        else if(name.contains("ACER")){
            return "Acer";
        }
        else if(name.contains("MACBOOK")){
            return "Apple Macbook";
        }
        return "No brand";
    }
    public static void writeProductInformation(String content, String linkFileText){
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(linkFileText, true);
            byte[] product = content.getBytes();
            outputStream.write(product);
            outputStream.write("\n".getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String toStringProductInformation(String beginCode, String name, String brand, String price, String link, boolean color,boolean type, boolean size){
        String result = beginCode + count ;
        if(color)
            result += "|" + filterColor(name);
        if(type){
            if( Integer.parseInt(price) >= 7000000){
                result += "|" + "up door";
            }
            else {
                result += "|" + "front door";
            }
        }
        if(size){
            brand = brand.toUpperCase();
            if( brand.contains("APPLE")){
                result += "|" + "13.3'";
            }
            else
                result += "|" + "14'";
        }
        result += "|"+ name +"|"+ brand + "|" + price + "|" + link;
        return result;
    }
    // Pico
    Pattern patternSourceLinkProduct = Pattern.compile("</div><h6><a href=\"(.+?)\">");
    Pattern patternNameAndPriceProduct = Pattern.compile(".html\">(.+?)</a></h6><div class=\"(.+?)\">" +
            "<span(.+?)class=\"price\">(.+?)</span>");
    //Mediamart
    Pattern nameAndLink = Pattern.compile("\">\\s+<a href=\"(.+?)\" title=\"(.+?)\" target=\"_blank\">");
    Pattern price = Pattern.compile("pbuy\">\\s+(.+?)<span>đ</span>");

    public static void getPicoProductInformation(String linkContent, String linkFileText, String productType,String beginCode, boolean color,boolean type, boolean size){
        try{
            URL url = new URL(linkContent);
            Scanner scan = new Scanner(url.openStream());
            scan.useDelimiter("\\Z");
            String content = scan.next();
            content = content.replaceAll("\n", "");
            Pattern patternNameProduct = Pattern.compile(".html\">(.+?)</a></h6><div class=\"(.+?)\">" +
                    "<span(.+?)class=\"price\">(.+?)</span>");
            Pattern patternPriceProduct = Pattern.compile(".html\">(.+?)</a></h6><div class=\"(.+?)\">" +
                    "<span(.+?)class=\"price\">(.+?)</span>");
            Pattern patternLinkProduct = Pattern.compile("</div><h6><a href=\"(.+?)\">");
            Matcher nameProduct = patternNameProduct.matcher(content);
            Matcher priceProduct = patternPriceProduct.matcher(content);
            Matcher linkProduct = patternLinkProduct.matcher(content);
            String productInformation;
            while (linkProduct.find() && nameProduct.find() && priceProduct.find()){
                count++;
                String name = nameProduct.group(1);
                String price = priceProduct.group(4);
                String link = linkProduct.group(1);
                String brand = filterBrand(name);
                productInformation = toStringProductInformation(beginCode, name, brand, price, link, color, type, size );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getMediamartProductInformation(String linkContent, String linkFileText, String type){
        try {
            String location = "https://mediamart.vn";
            OutputStream outputStream = new FileOutputStream(new File(linkFileText), true);
            URL url = new URL(linkContent);
            Scanner scan = new Scanner(url.openStream());
            scan.useDelimiter("\\Z");
            String content = scan.next();
            content = content.replaceAll("\n", "");
            Pattern nameAndLink = Pattern.compile("\">\\s+<a href=\"(.+?)\" title=\"(.+?)\" target=\"_blank\">");
            Pattern price = Pattern.compile("pbuy\">\\s+(.+?)<span>đ</span>");
            Matcher matcherNameAndLink = nameAndLink.matcher(content);
            Matcher matcherPrice = price.matcher(content);
            while (matcherNameAndLink.find() && matcherPrice.find()){
                count++;
                System.out.println(matcherNameAndLink.group(2)+","+ matcherPrice.group(1)+","+location+matcherNameAndLink.group(1));
                String productInformation ="MediaMart00"+ count +"|"+ type +"|" + matcherNameAndLink.group(2)+"|"+ filterBrand(matcherNameAndLink.group(2))+"|"+ matcherPrice.group(1)+"|"+location+matcherNameAndLink.group(1);
                outputStream.write(productInformation.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void convertInformation(Product product){

    }
    public static void main(String[] args) {
        getPicoProductInformation("https://pico.vn/may-giat-nhom-72.html", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine");
        getPicoProductInformation("https://pico.vn/may-giat-nhom-72.html?&pageIndex=2", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine");
        getPicoProductInformation("https://pico.vn/may-giat-nhom-72.html?&pageIndex=3", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine");
        getPicoProductInformation("https://pico.vn/dien-thoai-di-dong-nhom-75.html", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone");
        getPicoProductInformation("https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=2", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone");
        getPicoProductInformation("https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=3", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone");
        getPicoProductInformation("https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=4", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone");
        getPicoProductInformation("https://pico.vn/may-tinh-xach-tay-nhom-58.html", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop");
        getPicoProductInformation("https://pico.vn/may-tinh-xach-tay-nhom-58.html?&pageIndex=2", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop");
        getPicoProductInformation("https://pico.vn/may-tinh-xach-tay-nhom-58.html?&pageIndex=3", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop");
    }
}
