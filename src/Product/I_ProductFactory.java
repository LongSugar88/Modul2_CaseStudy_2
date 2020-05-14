package Product;

import PoductManagerment.ProductType;
import Product.Product;

public interface I_ProductFactory {
    public Product creatProduct(ProductType productType);
}
