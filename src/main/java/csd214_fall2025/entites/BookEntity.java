package csd214_fall2025.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "BookEntity{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                ", isbn_10='" + isbn_10 + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookEntity that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getPrice(), that.getPrice()) == 0 && getCopies() == that.getCopies() && Objects.equals(getAuthor(), that.getAuthor()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getIsbn_10(), that.getIsbn_10()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAuthor(), getTitle(), getPrice(), getCopies(), getIsbn_10(), getDescription());
    }

    public BookEntity() {
    }

    public BookEntity(
            String title,
            double price,
            int copies,
            String isbn_10,
            String description,
            String author) {
        super(title, price, copies, isbn_10, description);
        this.author = author;
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

    @Override
    public void sellCopy() {

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

    @Override
    public void edit() {

    }

    @Override
    public void initialize() {

    }
}