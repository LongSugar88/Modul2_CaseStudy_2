package Product;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Product {
    private String id;
    private String name;
    private int price;
    private String brand;
    private String link;

    public Product(){

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Product(String id, String name, String brand, int price, String link){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toString(){
        Locale locale = new Locale("en", "EN");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        String productPrice = numberFormat.format(getPrice());
        String productInformation = " Name: " +getName() + " | Price: " +
                productPrice +"VNĐ | Link: "+ getLink() +" | Brand: " + getBrand() + " | ID: " + getId();
        return productInformation;
    };
}
