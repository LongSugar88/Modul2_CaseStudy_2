package Product;

public class MobilePhone extends Product {
    private String color;
    private String type;

    public MobilePhone(){

    }
    public MobilePhone(String id, String name,String brand, int price,String link, String color, String type){
        super(id, name, brand, price, link);
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return null;
    }
}
