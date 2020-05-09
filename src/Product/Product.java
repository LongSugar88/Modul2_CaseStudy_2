package Product;

public abstract class Product {
    private String id;
    private String name;
    private int price;
    private String brand;

    public Product(){

    }
    public Product(String id, String name,String brand, int price){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public abstract String getId();

    public abstract void setId(String id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getPrice();

    public abstract void setPrice(int price);

    public abstract String getBrand();

    public abstract void setBrand(String brand);

    public abstract String toString();
}
