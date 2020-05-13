import PoductManagerment.AddProductManager;
import PoductManagerment.ProductManagerment;
import PoductManagerment.ReadFileText;
import Product.Product;

public class Run {
    public static void main(String[] args) throws Exception {
        ProductManagerment productManagerment = new ProductManagerment();
        AddProductManager manager = new AddProductManager(productManagerment);
        ReadFileText readFileText = new ReadFileText(productManagerment);
        readFileText.ReadFile("D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt");
        System.out.println(productManagerment.getSize());
//        for (Product element: productManagerment.getMyProduct()) {
//            System.out.println(element.getName());
//        }
        System.out.println(productManagerment.findByName("Samsung galaxy"));
    }
}
