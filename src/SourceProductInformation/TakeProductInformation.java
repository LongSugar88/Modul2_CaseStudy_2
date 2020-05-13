package SourceProductInformation;

import Product.Product;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TakeProductInformation extends Thread {
    private String linkSource;
    private String linkFileText;
    private String productType;
    private String beginCode;
    private boolean color;
    private boolean type;
    private boolean size;
    static int count = 0;

    public TakeProductInformation(){

    }
    public TakeProductInformation(String link, String linkFileText, String productType,String beginCode, boolean color, boolean type, boolean size){
        this.linkSource = link;
        this.linkFileText = linkFileText;
        this.productType = productType;
        this.beginCode = beginCode;
        this.color = color;
        this.type = type;
        this.size = size;
    }


    public static String splitPrice(String price){
        if(price.length() > 11){
            price = price.substring(8, 18);
        }
        price = price.replaceAll("\\.", "");
        price = price.replaceAll("₫", "");
        price = price.replaceAll("<", "");
        price = price.replaceAll("/", "");
        return price;
    }
    public static String filterColor(String name, String link){
        name = name.toUpperCase();
        link = link.toUpperCase();
        boolean redCondition = name.contains("RED") || name.contains("ĐỎ") || link.contains("RED") || link.contains("ĐỎ");
        boolean yellowCondition = name.contains("YELLOW") || name.contains("VÀNG") || link.contains("YELLOW") || link.contains("VÀNG");
        boolean silverCondition = name.contains("SILVER") || name.contains("BẠC") || link.contains("SILVER") || link.contains("BẠC");
        boolean blackCondition = name.contains("BLACK") || name.contains("ĐEN") || link.contains("BLACK") || link.contains("ĐEN");
        boolean blueCondition = name.contains("BLUE") || name.contains("XANH") || link.contains("BLUE") || link.contains("XANH");
        boolean whiteCondition = name.contains("WHITE") || name.contains("TRẮNG") || link.contains("WHITE") || link.contains("TRẮNG");
        boolean purpleCondition = name.contains("PURPLE") || name.contains("TÍM") || link.contains("PURPLE") || link.contains("TÍM");
        boolean grayCondition1 = name.contains("GRAY") || link.contains("GRAY");
        boolean grayCondition2 = name.contains("GREY") || name.contains("XÁM") || link.contains("GREY") || link.contains("XÁM");
        boolean pinkCondition = name.contains("PINK") || name.contains("HỒNG") || link.contains("PINK") || link.contains("HỒNG");
        boolean goldCondition = name.contains("GOLD") || link.contains("GOLD");
        boolean greenCondition = name.contains("GREEN") || link.contains("GREEN");
        if(redCondition){
            return "Red";
        }
        else if(yellowCondition){
            return "Yellow";
        }
        else if(silverCondition){
            return "Silver";
        }
        else if(blackCondition){
            return "Black";
        }
        else if(blueCondition){
            return "Blue";
        }
        else if(whiteCondition){
            return "White";
        }
        else if(purpleCondition){
            return "Purple";
        }
        else if(grayCondition1 || grayCondition2){
            return "Grey";
        }
        else if(pinkCondition){
            return "Pink";
        }
        else if(goldCondition){
            return "Gold";
        }
        else if(greenCondition){
            return "Green";
        }
        else
            return "no color";
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
        else if(name.contains("VIVO")){
            return "Vivo";
        }
        else if(name.contains("REALM")){
            return "Realme";
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
    public static String filterSize(String brand, String name){
        String result = null;
        brand = brand.toUpperCase();
        name = name.toUpperCase();
        if( brand.contains("APPLE")){
            result = "," + "13.3'";
        }
        else if(name.contains("ENVY")){
            result = "," + "13'";
        }
        else if(name.contains(" 15-")){
            result = "," + "15'";
        }
        else
            result = "," + "14'";
        return result;
    }
    public static String filterType(String price, String name){
        String result = null;
        name = name.toUpperCase();
        if( name.contains("ĐỨNG")){
            result = "," + "upper door";
        }
        else if(name.contains("NGANG")){
            result = "," + "front door";
        }
        else if( Integer.parseInt(price) >= 7000000){
            result = "," + "front door";
        }
        else {
            result = "," + "upper door";
        }
        return result;
    }
    public synchronized static void writeProductInformation(String content, String linkFileText){
        OutputStream outputStream;
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
    public static String toStringProductInformation(String beginCode, String productType, String name, String brand, String price, String link, boolean color,boolean type, boolean size){
        String result = beginCode + count ;
        if(color){
            result += "," + filterColor(name, link);
        }
        if(type){
            result +=  filterType(price, name);
        }
        if(size){
            result +=  filterSize(brand, name);
        }
        result += "," + productType + ","+ name +","+ brand + "," + price + "," + link;
        return result;
    }
    //Mediamart
    Pattern nameAndLink = Pattern.compile("\">\\s+<a href=\"(.+?)\" title=\"(.+?)\" target=\"_blank\">");
    Pattern price = Pattern.compile("pbuy\">\\s+(.+?)<span>đ</span>");

    public void getPicoProductInformation(){

    }
    public void getMediamartProductInformation(String linkContent, String linkFileText, String type){
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
    @Override
    public void run(){
        try{
            URL url = new URL(this.linkSource);
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
                String name = (nameProduct.group(1)).replaceAll(",", "");
                String price = splitPrice(priceProduct.group(4));
                String link = linkProduct.group(1);
                String brand = filterBrand(name);
                productInformation = toStringProductInformation(beginCode, productType, name, brand, price, link, color, type, size );
                writeProductInformation(productInformation, linkFileText );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

//        getPicoProductInformation( "https://pico.vn/may-giat-nhom-72.html","D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine", "Pico00", false, true, false  );
//        getPicoProductInformation( "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine","Pico00", false, true, false  );
//        getPicoProductInformation( "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine", "Pico00", false, true, false  );
//        getPicoProductInformation( "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone", "Pico00", true, false, false  );
//        getPicoProductInformation( "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone", "Pico00", true, false, false);
//        getPicoProductInformation( "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone", "Pico00", true, false, false);
//        getPicoProductInformation( "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone", "Pico00", true, false, false);
//        getPicoProductInformation( "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop", "Pico00", true, false, true);
//        getPicoProductInformation( "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop", "Pico00", true, false, true);
//        getPicoProductInformation("D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop", "Pico00", true, false, true);
    }
}
