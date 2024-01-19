package gr.aueb.parkhub.views.signIn;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public interface SignInView {

    /**
     * Η ροή μεταφέρεται στο HomepageActivity
     * @param userID το Id του χρήστη που πρόκειται να συνδεθεί
     */
    void homePage(Integer userID);

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
     * Επιστρέφει το Email που συμπληρώνει ο χρήστης
     * @return το Email που συμπληρώνεται από τον χρήστη
     */
    String getEmail();

    /**
     * Επιστρέφει το Password που συμπληρώνει ο χρήστης
     * @return το Password που συμπληρώνεται από τον χρήστη
     */
    String getPassword();
}
