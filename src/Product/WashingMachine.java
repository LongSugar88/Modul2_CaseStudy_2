package Product;

public class WashingMachine extends Product {
    private String type;

    WashingMachine(){

    }
    WashingMachine(String id, String name,String brand, int price,String type){
        super(id, name, brand, price);
        this.type = type;
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
