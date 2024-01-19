package gr.aueb.parkhub.views.viewProfile;

import gr.aueb.parkhub.domain.User;

/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public interface ViewProfileView {

    /**
     * Επιστρέφει στην αρχική σελίδα
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void homePage(Integer userID);

    /**
     * Η ροή μεταφέρεται στο EditProfileActivity
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void editProfile(Integer userID);

    /**
     * Επιστρέφει το id του συνδεδεμένου χρήστη
     * @return το id του συνδεδεμένου χρήστη
     */
    Integer getAttachedUserID();

    /**
     * Θέτει τα στοιχεία που θα εμφανιστούν
     * για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    void setContent(User user);

    /**
     * Εμφανίζει μύνημα error σε περίπτωση
     * που ο χρήστης προσπαθήσει να αλλαξει τα στοιχεια
     * του ενώ εχει κάποια κράτηση
     * @param message το περιεχόμενο του μυνήματος
     */
    void showErrorMessage(String message);


}
