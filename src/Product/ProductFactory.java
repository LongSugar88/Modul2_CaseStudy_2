package Product;
import PoductManagerment.InterFace.I_Command;
import PoductManagerment.Enum.ProductType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ProductFactory implements I_Command {
    private Product product;
    private ProductType productType;

    public ProductFactory(){
    }
    public ProductFactory(ProductType productType){
        this.productType = productType;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductType getProductType() {

        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    @Override
    public void excute() {
        switch (productType) {
            case MOBILEPHONE:
                this.product = new MobilePhone();
                break;
            case LAPTOP:
                this.product = new Laptop();
                break;
            case WASHINGMACHINE:
                this.product = new WashingMachine();
                break;
            default:
                throw new NotImplementedException();
        }
    }
}
