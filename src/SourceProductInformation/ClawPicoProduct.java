package SourceProductInformation;

import Product.Product;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClawPicoProduct extends Thread {
    private String linkSource;
    private String linkFileText;
    private String productType;
    private String beginCode;
    private boolean color;
    private boolean type;
    private boolean size;
    static int count = 0;

    public ClawPicoProduct(){

    }
    public ClawPicoProduct(String link, String linkFileText, String productType, String beginCode, boolean color, boolean type, boolean size){
        this.linkSource = link;
        this.linkFileText = linkFileText;
        this.productType = productType;
        this.beginCode = beginCode;
        this.color = color;
        this.type = type;
        this.size = size;
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
    public synchronized static String toStringProductInformation(String beginCode, String productType, String name, String brand, String price, String link, boolean color,boolean type, boolean size){
        String result = beginCode + count ;
        result += "," + name +","+ brand + "," + price + "," + link + "," + productType;
        if(color){
            result += "," + Fillter.filterColor(name, link);
        }
        if(type){
            result += Fillter.filterType(price, name);
        }
        if(size){
            result += Fillter.filterSize(brand, name);
        }
        return result;
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
                String price = Fillter.splitPrice(priceProduct.group(4));
                String link = linkProduct.group(1);
                String brand = Fillter.filterBrand(name);
                productInformation = toStringProductInformation(beginCode, productType, name, brand, price, link, color, type, size );
                writeProductInformation(productInformation, linkFileText );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
