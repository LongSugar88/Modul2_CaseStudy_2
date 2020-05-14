package PoductManagerment;
import Product.Product;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class SortProductPriceByLowToHight extends Manager implements I_Command {
    ArrayList<Product> myList = new ArrayList<>() ;
    private Product product;
    private String name;

    public SortProductPriceByLowToHight(ProductManagerment managerment){
        super(managerment);
    }
    public SortProductPriceByLowToHight(ProductManagerment managerment, String name){
        super(managerment);
        this.name = name;
    }

    public void setMyList(ArrayList<Product> myList) {
        this.myList = myList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private void buildList(){
        name = name.toUpperCase();
        if(this.manager.getSize() == 0) throw new ArrayIndexOutOfBoundsException("The list is empty");
        for(int i=0; i< this.manager.getSize(); i++ ){
            product = this.manager.get(i);
            String productName = product.getName().toUpperCase();
            if(productName.contains(name)){
                this.product = this.manager.get(i);
                myList.add(this.product);
            }
        }
    }
    @Override
    public void excute(){
        buildList();
        LowToHightComparator myCompare = new LowToHightComparator();
        Collections.sort(myList, myCompare);
        System.out.println("List found: ");
        Locale locale = new Locale("en", "EN");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        for(int i=0; i<myList.size() ; i++){
            product = this.myList.get(i);
            System.out.println(product.toString());
        }
    }
}
