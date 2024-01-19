package gr.aueb.parkhub.dao;

import java.util.List;

import gr.aueb.parkhub.domain.User;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public  interface AccountDAO {

    /**
     * Διαγράφει ένα χρήστη
     * @param user ο χρήστης
     */
    void delete(User user);

    /**
     * Αποθηκέυει ένα χρήστη
     * @param user ο χρήστης
     */
    void save(User user);

    /**
     * Επιστρέφει όλους του χρήστες
     * @return λίστα με χρήστες
     */
    List<User> findAll();

    /**
     * Βρίσκει ένα χρήστη με βάση το ID του
     * @param userId το ID του χρήστη προς αναζήτηση
     * @return τον χρήστη που βρέθηκε
     */
    User find(int userId);

    /**
     * Βρίσκει ένα χρήστη με βάση του email του
     * @param email το email του χρήστη προς αναζήτηση
     * @return τον χρήστη που βρέθηκε
     */
    User findUserByEmail(String email);

    /**
     * Ελέγχει αν ο χρήστης είναι εξουσιοδοτημένος
     * @param id το ID του χρήστη
     * @return αν ο χρήστης είναι εξουσιοδοτημένος
     */
    boolean authorized(int id);

    /**
     * Προσθέτει νέο εξουσιοδοτημένο χρήστη
     * @param id το ID του εξουσιοδοτημένοy xρήστη
     */
    void addAuthorizedID(int id);
}
