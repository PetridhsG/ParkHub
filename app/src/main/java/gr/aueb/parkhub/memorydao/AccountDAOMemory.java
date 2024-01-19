package gr.aueb.parkhub.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.domain.User;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */


public class AccountDAOMemory implements AccountDAO {

    protected static ArrayList<Integer> authorizedIDS = new ArrayList<>();;
    protected static ArrayList<User> users = new ArrayList<User>();

    /**
     * Αρχικοποιεί τα εξουσιοδοτημένα ID
     */
    public AccountDAOMemory(){
        authorizedIDS.add(7);
        authorizedIDS.add(8);
        authorizedIDS.add(9);
    }

    /**
     * Διαγράφει ένα χρήστη
     * @param user ο χρήστης
     */
    @Override
    public void delete(User user) {
        users.remove(user);
    }

    /**
     * Αποθηκέυει ένα χρήστη
     * @param user ο χρήστης
     */
    @Override
    public void save(User user) {
        users.add(user);
    }

    /**
     * Επιστρέφει όλους του χρήστες
     * @return λίστα με χρήστες
     */
    @Override
    public List<User> findAll() {
        ArrayList<User> result = new ArrayList<User>();
        result.addAll(users);
        return result;
    }

    /**
     * Βρίσκει ένα χρήστη με βάση το ID του
     * @param userId το ID του χρήστη προς αναζήτηση
     * @return τον χρήστη που βρέθηκε ή null
     */
    @Override
    public User find(int userId) {
        for(User user : users)
            if(user.getId() == userId)
                return user;

        return null;
    }

    /**
     * Βρίσκει ένα χρήστη με βάση του email του
     * @param email το email του χρήστη προς αναζήτηση
     * @return τον χρήστη που βρέθηκε ή null
     */
    @Override
    public User findUserByEmail(String email) {
        for(User author : users)
            if(author.getEmail().equals(email))
                return author;

        return null;
    }

    /**
     * Ελέγχει αν ο χρήστης είναι εξουσιοδοτημένος
     * @param id το ID του χρήστη
     * @return αν ο χρήστης είναι εξουσιοδοτημένος
     */
    @Override
    public boolean authorized(int id) {
        return authorizedIDS.contains(id);
    }

    /**
     * Προσθέτει νέο εξουσιοδοτημένο χρήστη
     * @param id το ID του εξουσιοδοτημένου χρήστη
     */
    @Override
    public void addAuthorizedID(int id) {
        authorizedIDS.add(id);
    }



}
