package csd214_fall2025;

import csd214_fall2025.entites.BookEntity;
import csd214_fall2025.entites.PublicationEntity;
import jakarta.persistence.*;

import java.util.List;

public class App {
    private EntityManagerFactory emf;
    public void run(){
        // Create the EntityManagerFactory using the persistence unit name from persistence.xml
        emf = Persistence.createEntityManagerFactory("product-pu");
        populateDatabase();
    }

    public void populateDatabase() {
        // EntityManager is used to interact with the persistence context
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin(); // Start a transaction

            System.out.println("Populating database with products...");
            BookEntity b = new BookEntity("String author", "String title", 29.99, 10, "String isbn_10", "String description");

            em.persist(b);

            tx.commit(); // Commit the transaction
            System.out.println("Population complete.");
            listAllEditableItems(em);
        } catch (Exception e) {
            // If anything goes wrong, roll back the transaction
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // Always close the EntityManager
            em.close();
        }
    }

    /**
     * Queries the database for all entities that are part of the PublicationEntity
     * inheritance hierarchy. Because PublicationEntity extends EditableEntity, this
     * effectively retrieves all editable items.
     *
     * @param em The EntityManager to use for the query.
     * @return A list of all PublicationEntity instances (including Books, Magazines, etc.).
     */
    public List<PublicationEntity> listAllEditableItems(EntityManager em) {
        System.out.println("\n--- Querying for all editable publications ---");

        // 1. The JPQL query is written against the root @Entity class, not the @MappedSuperclass.
        //    JPA will automatically fetch all subclasses (like BookEntity).
        String jpql = "SELECT p FROM PublicationEntity p";

        // 2. We create a TypedQuery to ensure the results are cast to the correct base type.
        TypedQuery<PublicationEntity> query = em.createQuery(jpql, PublicationEntity.class);

        // 3. Execute the query to get the list of results.
        List<PublicationEntity> results = query.getResultList();

        System.out.println("Found " + results.size() + " items.");
        for(PublicationEntity p : results){
            System.out.println(p);
        }
        return results;
    }

}
