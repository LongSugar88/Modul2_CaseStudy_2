package Product;

public class Laptop extends Product {
    private String color;
    private double size;

    public Laptop(){

    }
    Laptop(String id, String name,String brand, int price,String link, String color, double size){
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return null;
    }
}
