package Product;

import PoductManagerment.Enum.ProductType;

public interface I_ProductFactory {
    public Product creatProduct(ProductType productType);
}
