package gr.aueb.parkhub.views.signUpVehicle;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public interface SignUpVehicleView {

    /**
     * Η ροή μεταφέρεται στο SignInActivity
     */
    void signUpComplete();

    /**
     * Η ροή μεταφέρεται στο SignUpPersonalActivity
     */
    void signUpPersonal();

    /**
     * Tο μύνημα που εμφανίζεται σε περίπτωση error
     * @param message το περιεχόμενο του μυνήματος
     */
    void showErrorMessage(String message);

    /**
     * Επιστρέφει το Name που συμπληρώνει ο χρήστης
     * @return το Name που συμπληρώνεται από τον χρήστη
     */
    String getName();

    /**
     * Επιστρέφει το Surname που συμπληρώνει ο χρήστης
     * @return το Surname που συμπληρώνεται από τον χρήστη
     */
    String getSurname();

    /**
     * Επιστρέφει το Email που συμπληρώνει ο χρήστης
     * @return το Email που συμπληρώνεται από τον χρήστη
     */
    String getEmail();

    /**
     * Επιστρέφει το Password που συμπληρώνει ο χρήστης
     * @return το Password που συμπληρώνεται από τον χρήστη
     */
    String getPassword();

    /**
     * Επιστρέφει το Telephone που συμπληρώνει ο χρήστης
     * @return το Telephone που συμπληρώνεται από τον χρήστη
     */
    String getTelephone();

    /**
     * Επιστρέφει το Brand που συμπληρώνει ο χρήστης
     * @return το Brand που συμπληρώνεται από τον χρήστη
     */
    String getBrand();

    /**
     * Επιστρέφει το Model που συμπληρώνει ο χρήστης
     * @return το Model που συμπληρώνεται από τον χρήστη
     */
    String getModel();

    /**
     * Επιστρέφει το Color που συμπληρώνει ο χρήστης
     * @return το Color που συμπληρώνεται από τον χρήστη
     */
    String getColor();

    /**
     * Επιστρέφει το LicensePlate που συμπληρώνει ο χρήστης
     * @return το LicensePlate που συμπληρώνεται από τον χρήστη
     */
    String getLicensePlate();

    /**
     * Επιστρέφει το Size που συμπληρώνει ο χρήστης
     * @return το Size που συμπληρώνεται από τον χρήστη
     */
    String getSize();
}
