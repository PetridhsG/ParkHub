package gr.aueb.parkhub.views.editProfile;

import gr.aueb.parkhub.domain.User;

/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public interface EditProfileView {
    /**
     * Θέτει τα στοιχεία που θα εμφανιστούν
     * για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    void setContent(User user);

    /**
     * Η ροή μεταφέρεται στο ViewProfileActivity
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void homePage(Integer userID);

    /**
     * Η ροή μεταφέρεται στο ViewProfileActivity
     * και ενημερώνει τον χρήστη πως οι αλλαγές αποθηκεύτηκαν επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void finish(Integer userID);

    /**
     * Επιστρέφει το id του συνδεδεμένου χρήστη
     * @return το id του συνδεδεμένου χρήστη
     */
    Integer getAttachedUserID();

    /**
     * Εμφανίζει μύνημα σε περίπτωση λάθος τιμής εισαγωγής
     * @param message το περιεχόμενο του μυνήματος
     */
    void showErrorMessage(String message);

    /**
     * Επιστρέφει το όνομα
     * @return το όνομα
     */
    String getName();

    /**
     * Επιστρέφει το επώνυμο
     * @return το επώνυμο
     */
    String getSurname();

    /**
     * Επιστρέφει το email
     * @return το email
     */
    String getEmail();

    /**
     * Επιστρέφει τον κωδικό
     * @return τον κωδικό
     */
    String getPassword();

    /**
     * Επιστρέφει το τηλέφωνο
     * @return το τηλέφωνο
     */
    String getTelephone();

    /**
     * Επιστρέφει τη μάρκα του αυτοκινήτου
     * @return τη μάρκα του αυτοκινήτου
     */
    String getBrand();

    /**
     * Επιστρέφει το μοντέλο του αυτοκινήτου
     * @return το μοντέλο του αυτοκινήτου
     */
    String getModel();

    /**
     * Επιστρέφει το χρώμα του αυτοκινήτου
     * @return το χρώμα του αυτοκινήτου
     */
    String getColor();

    /**
     * Επιστρέφει τη πινακίδα του αυτοκινήτου
     * @return τη πινακίδα του αυτοκινήτου
     */
    String getLicensePlate();

    /**
     * Επιστρέφει το μέγεθος του αυτοκινήτου
     * @return το μέγεθος του αυτοκινήτου
     */
    String getSize();


}
