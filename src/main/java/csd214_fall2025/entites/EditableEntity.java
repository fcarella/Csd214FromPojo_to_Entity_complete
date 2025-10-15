package csd214_fall2025.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "editable_entity")
public class EditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}