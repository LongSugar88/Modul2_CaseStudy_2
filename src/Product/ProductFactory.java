package Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
public class ProductFactory implements I_ProductFactory{
    @Override
    public Product creatProduct(ProductType productType) {
        switch (productType){
            case MOBILEPHONE:
                return new MobilePhone();
            case LAPTOP:
                return new Laptop();
            case WASHINGMACHINE:
                return new WashingMachine();
            default:
                throw new NotImplementedException();
        }
    }
}
