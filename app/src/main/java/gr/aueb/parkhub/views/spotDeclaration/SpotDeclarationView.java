package gr.aueb.parkhub.views.spotDeclaration;

import gr.aueb.parkhub.domain.Time;
import gr.aueb.parkhub.domain.User;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public interface SpotDeclarationView {

    /**
     * Επιστρέφει την οδό της διέθυνσης
     * @return την οδό της διέθυνσης
     */
    String getStreet();

    /**
     * Επιστρέφει τον αριθμό οδού της διέθυνσης
     * @return τον αριθμό οδού της διέθυνσης
     */
    String getStNumber();

    /**
     * Επιστρέφει την πόλη της διέθυνσης
     * @return την πόλη της διέθυνσης
     */
    String getCity();

    /**
     * Επιστρέφει την περιοχή διέθυνσης
     * @return την περιοχή της διέθυνσης
     */
    String getRegion();

    /**
     * Επιστρέφει την ώρα που θα είναι διαθέσιμη η θέση
     * @return η ώρα που θα είναι διαθέσιμη η θέση
     */
    Time getTime();

    /**
     * Επιστρέφει το Id του συνδεδεμένου χρήστη
     * @return το Id του συγκεκριμένου χρήστη
     */
    Integer getAttachedUserID() ;

    /**
     * Επιστρέφει στην αρχική σελίδα
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void back(Integer userID);

    /**
     * Δημιουργεί μία καινούργια θέση και επιστρέφει στην αρχική οθόνη
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void declare(Integer userID);

    /**
     * Θέτει την οδό της διέθυνσης
     * @param street Το όνομα της οδού
     */

    void setStreet(String street);

    /**
     * Θέτει τον αριθμό οδόύ της διέθυνσης
     * @param stNumber Ο αριθμός της οδού
     */
    void setStNumber(int stNumber);

    /**
     * Θέτει την πόλη της διέθυνσης
     * @param city Το όνομα της πόλης
     */
    void setCity(String city);

    /**
     * Θέτει την περιοχή της διέθυνσης
     * @param region Το όνομα της πόλης
     */
    void setRegion(String region);

    /**
     * Θέτει την ώρα που θα είναι διαθέσιμη η θέση
     * @param time Η ώρα που θα είναι διαθέσιμη η θέση
     */
    void setTime(Time time);

    /**
     * Θέτει το περιεχόμενο για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    void setContent(User user);

    /**
     * Tο μύνημα που εμφανίζεται σε περίπτωση error
     * @param message το περιεχόμενο του μυνήματος
     */
    void showErrorMessage(String message);


}
