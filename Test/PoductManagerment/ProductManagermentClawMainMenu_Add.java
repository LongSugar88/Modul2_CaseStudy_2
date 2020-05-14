package PoductManagerment;
import Product.Product;
import Product.WashingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductManagermentClawMainMenu_Add {
    ProductManagerment productManagerment;
    @BeforeEach
    void setup(){
        productManagerment = new ProductManagerment();
    }
    @Test
    public void add() {
        Product newProduct = new WashingMachine("PicoW001", "Máy Giặt Panasonic 8kg NAF80VS9GRV", "Panasonic", 5190000, "https://pico.vn/33710/may-giat-panasonic-naf80vs9grv--80kg.html","normal");
        productManagerment.add(newProduct);
        String id =  productManagerment.get(0).getId();
        String name = productManagerment.get(0).getName();
        String brand = productManagerment.get(0).getBrand();
        int price = productManagerment.get(0).getPrice();
        String link = productManagerment.get(0).getLink();
        String expect = "PicoW001|Máy Giặt Panasonic 8kg NAF80VS9GRV|Panasonic|5190000|https://pico.vn/33710/may-giat-panasonic-naf80vs9grv--80kg.html";
        String result = id + "|" + name + "|" + brand + "|" + price + "|" + link;
        assertEquals(expect, result);
    }
}