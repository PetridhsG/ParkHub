package gr.aueb.parkhub.views.signUpPersonal;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public interface SignUpPersonalView {

    /**
     * Η ροή μεταφέρεται στο SignUpVehicleActivity
     */
    void signUpVehicle();

    /**
     * Η ροή μεταφέρεται στο SignInActivity
     */
    void signIn();

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

}
