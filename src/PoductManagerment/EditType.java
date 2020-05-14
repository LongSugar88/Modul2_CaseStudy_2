package PoductManagerment;
import Product.Product;
import Product.WashingMachine;
import SourceProductInformation.SaveProductInformation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EditType extends Manager implements I_Command{
    ProductType productType;
    String id;
    String newType;
    Product product;
    FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, this.id);
    public EditType(ProductManagerment manager) {
        super(manager);
    }
    public EditType(ProductManagerment manager, String newType, String id, ProductType productType){
        super(manager);
        this.newType = newType;
        this.id = id;
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
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
        this.manager.get(index).setName(newType);
        switch (productType){
            case WASHINGMACHINE:
                ((WashingMachine) this.manager.get(index)).setType(newType);
                break;
            default:
                throw new NotImplementedException();
        }
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }
}
