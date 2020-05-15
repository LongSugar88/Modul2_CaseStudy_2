package PoductManagerment.EditElement;
import PoductManagerment.*;
import PoductManagerment.Enum.ProductType;
import PoductManagerment.FindElement.FindProductIndexByID;
import PoductManagerment.InterFace.I_Command;
import Product.Product;
import Product.Laptop;
import Product.MobilePhone;
import SourceProductInformation.SaveProductInformation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EditColor extends Manager implements I_Command {    ProductType productType;
    String id;
    String newColor;
    Product product;
    public EditColor(ProductManagerment manager) {
        super(manager);
    }
    public EditColor(ProductManagerment manager, String newColor, String id, ProductType productType){
        super(manager);
        this.newColor = newColor;
        this.id = id;
        this.productType = productType;
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
            case MOBILEPHONE:
                ((MobilePhone) product).setColor(newColor);
                break;
            case LAPTOP:
                ((Laptop) product).setColor(newColor);
                break;
            default:
                throw new NotImplementedException();
        }
        SaveProductInformation saveProduct = new SaveProductInformation(this.manager);
        saveProduct.excute();
    }

}
