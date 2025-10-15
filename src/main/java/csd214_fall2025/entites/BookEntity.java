package csd214_fall2025.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class BookEntity extends PublicationEntity {
    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "copies", nullable = false)
    private int copies;

    @Column(name = "isbn_10")
    private String isbn_10;

    @Column(name = "description")
    private String description;

    @Column(name = "product_id")
    private String productId;

    public BookEntity(String stringAuthor, String stringTitle, double v, int i, String stringIsbn10, String stringDescription) {
        super(stringTitle, v,i, stringIsbn10, stringDescription);
        setAuthor(stringAuthor);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                ", isbn_10='" + isbn_10 + '\'' +
                ", description='" + description + '\'' +
                ", productId='" + productId + '\'' +
                "} " + super.toString();
    }

    public BookEntity() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getIsbn_10() {
        return isbn_10;
    }

    public void setIsbn_10(String isbn_10) {
        this.isbn_10 = isbn_10;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}