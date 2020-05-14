package Product;

public class Laptop extends Product {
    private String color;
    private String size;

    public Laptop(){

    }
    Laptop(String id, String name,String brand, int price,String link, String color, String size){
        super(id, name, brand, price, link);
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public String toString() {
        String productInformation = "ID: " + getId() + " Name: " +getName() +" Brand: " + getBrand() + " Price: " +
                getPrice() +" Link: "+ getLink() +" Color: " +getColor() +" Size: " + getSize();
        return productInformation;
    }
}
