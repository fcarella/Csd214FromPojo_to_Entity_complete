package csd214_fall2025.entites;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "product_entity")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id")
    private String productId;

    public ProductEntity(UUID uuid) {
        setProductId(uuid.toString());
    }

    public ProductEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}