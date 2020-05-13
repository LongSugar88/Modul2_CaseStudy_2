import PoductManagerment.ProductManagerment;
import Product.ProductFactory;

public class Run {
    public static void main(String[] args) throws Exception {
        ProductManagerment productManagerment = new ProductManagerment();
        ProductFactory productFactory = new ProductFactory();
        productFactory.readFileText("D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt");
        System.out.println(productManagerment.getSize());
    }
}
