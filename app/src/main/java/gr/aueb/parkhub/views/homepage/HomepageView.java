package gr.aueb.parkhub.views.homepage;

import gr.aueb.parkhub.domain.User;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public interface HomepageView {

    /**
     * Επιστρέφει το Id του συνδεδεμένου χρήστη
     * @return το Id του συγκεκριμένου χρήστη
     */
    Integer getAttachedUserID() ;

    /**
     * Η ροή μεταφέρεται στο ViewProfileActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    void viewProfile(Integer userID);

    /**
     * Η ροή μεταφέρεται στο PBucksRenewalActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    void addPBucks(Integer userID);

    /**
     * Η ροή μεταφέρεται στο SpotDeclaationActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    void declareSpot(Integer userID);

    /**
     * Η ροή μεταφέρεται στο SpotReservationActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    void reserveSpot(Integer userID);

    /**
     * Πραγματοποιείται η διαδικασία ανταλλαγής θέσης
     */
    void exchangeSpot(Integer userID);

    /**
     * Η ροή μεταφέρεται στο RatingActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    void reportFalseSpot(Integer userID);

    /**
     * Προβάλει τα στατιστικά στην οθόνη
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    void viewStatistics(Integer userID);

    /**
     * Tο μύνημα που εμφανίζεται σε περίπτωση error
     * @param title ο τίτλος του μυνήματος
     * @param message το περιεχόμενο του μυνήματος
     */
    void showErrorMessage(String title, String message);

    /**
     * Θέτει το περιεχόμενο για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    void setContent(User user);

    /**
     * Tο Toast μύνημα που εμφανίζεται
     * @param message το περιεχόμενο του μυνήματος
     */
    void showToastMessage(String message);


}
