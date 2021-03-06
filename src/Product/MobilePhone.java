package Product;

public class MobilePhone extends Product {
    private String color;

    public MobilePhone(){

    }
    public MobilePhone(String id, String name,String brand, int price,String link, String color){
        super(id, name, brand, price, link);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String productInformation = super.toString() +" | Color: " +getColor() ;
        return productInformation;
    }
}
