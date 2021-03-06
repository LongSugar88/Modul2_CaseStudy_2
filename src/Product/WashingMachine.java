package Product;

import java.io.*;
import java.util.ArrayList;

public class WashingMachine extends Product {
    private String type;

    WashingMachine(){

    }
    public WashingMachine(String id, String name, String brand, int price, String link, String type){
        super(id, name, brand, price, link);
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
        String productInformation = super.toString() +" | Type: " +getType();
        return productInformation;
    }

}
