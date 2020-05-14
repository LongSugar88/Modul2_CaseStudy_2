package PoductManagerment;
import Product.Product;
import Product.WashingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagermentClawMainMenu_Remove {
    ProductManagerment productManagerment;
    @BeforeEach
    void setup(){
        productManagerment = new ProductManagerment();
    }
    @Test
    public void remove() {
        Product newProduct = new WashingMachine("PicoW001", "Máy Giặt Panasonic 8kg NAF80VS9GRV", "Panasonic", 5190000, "https://pico.vn/33710/may-giat-panasonic-naf80vs9grv--80kg.html","normal");
        productManagerment.add(newProduct);
        Product product = productManagerment.remove(0);
        String id =  product.getId();
        String name = product.getName();
        String brand = product.getBrand();
        int price = product.getPrice();
        String link = product.getLink();
        String expect = "PicoW001|Máy Giặt Panasonic 8kg NAF80VS9GRV|Panasonic|5190000|https://pico.vn/33710/may-giat-panasonic-naf80vs9grv--80kg.html";
        String result = id + "|" + name + "|" + brand + "|" + price + "|" + link;
        assertEquals(expect, result);
    }
}