package csd214_fall2025.pojos;

import java.io.Serializable;

/**
 * DTO for {@link csd214_fall2025.entites.ProductEntity}
 */
public abstract class Product extends Editable implements Serializable, SaleableItem {
    private String productId;

    public Product(String productId) {
        this.productId = productId;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
