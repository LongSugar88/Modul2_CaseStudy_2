package PoductManagerment;
import Product.Product;
import Product.Laptop;
import Product.MobilePhone;
import SourceProductInformation.SaveProductInformation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EditColor extends Manager implements I_Command {    ProductType productType;
    String id;
    String newColor;
    Product product;
    FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, this.id);
    public EditColor(ProductManagerment manager) {
        super(manager);
    }
    public EditColor(ProductManagerment manager, String newColor, String id, ProductType productType){
        super(manager);
        this.newColor = newColor;
        this.id = id;
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getNewColor() {
        return newColor;
    }

    public void setNewColor(String newColor) {
        this.newColor = newColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void excute() {
        int index = findProductIndexByID.getIndex();
        this.manager.get(index).setName(newColor);
        switch (productType){
            case WASHINGMACHINE:
                ((Laptop) this.manager.get(index)).setColor(newColor);
                break;
            case LAPTOP:
                ((Laptop) this.manager.get(index)).setColor(newColor);
                break;
            default:
                throw new NotImplementedException();
        }
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }

}
