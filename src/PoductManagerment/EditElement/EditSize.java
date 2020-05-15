package PoductManagerment.EditElement;

import PoductManagerment.*;
import PoductManagerment.Enum.ProductType;
import PoductManagerment.FindElement.FindProductIndexByID;
import PoductManagerment.InterFace.I_Command;
import Product.Product;
import Product.Laptop;
import SourceProductInformation.SaveProductInformation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EditSize extends Manager implements I_Command {    ProductType productType;
    String id;
    String newSize;
    Product product;

    public EditSize(ProductManagerment manager) {
        super(manager);
    }
    public EditSize(ProductManagerment manager, String newSize, String id, ProductType productType){
        super(manager);
        this.newSize = newSize;
        this.id = id;
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getNewSize() {
        return newSize;
    }

    public void setNewSize(String newSize) {
        this.newSize = newSize;
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
        FindProductIndexByID findProductIndexByID = new FindProductIndexByID(this.manager, this.id);
        int index = findProductIndexByID.getIndex();
        product = this.manager.get(index);
        switch (productType){
            case LAPTOP:
                ((Laptop) product).setSize(newSize);
                break;
            default:
                throw new NotImplementedException();
        }
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }

}
