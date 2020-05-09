package SourceProductInformation;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteProductInfomation {
    public String splitPrice(String price){
        if(price.length() > 11){
            price = price.substring(8, 18);
            return price;
        }
        else
            return price;
    }

    public void getProductInformation(String linkContent, String linkFileText){
        try{
            URL url = new URL(linkContent);
            File file = new File(linkFileText);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Byte[] bytes = new Byte[2048];
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
                System.out.println(count + "," + NameAndPrice.group(1)+ "," + NameAndPrice.group(4)+ "," + link.group(1));
                String productInformation = NameAndPrice.group(1)+ "," + splitPrice(NameAndPrice.group(4))+ "," + link.group(1);
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

//    public static void main(String[] args) {
//        getProductInformation("https://pico.vn/may-giat-nhom-72.html", "D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Pico\\Washing_Machine.txt");
//    }
}
