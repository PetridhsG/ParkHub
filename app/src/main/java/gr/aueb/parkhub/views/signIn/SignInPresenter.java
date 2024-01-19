package gr.aueb.parkhub.views.signIn;

import java.util.Objects;
import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.domain.User;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SignInPresenter {

    private SignInView view;

    private AccountDAO accountDAO ;

    /**
     * Αρχικοποιεί τον presenter
     * @param view Ένα instance του view
     * @param accountDAO Ένα instance του AccountDAO
     */
    public SignInPresenter(SignInView view,AccountDAO accountDAO){
        this.accountDAO = accountDAO;
        this.view = view;
    }

    /**
     * Αν ο χρήστης εισάγει έγκυρα στοιχεία,η ροή μεταφέρεται στο
     * HomepageActivity αλλιώς
     * εμφανίζεται κατάλληλο μύνημα λάθους
     */
    public void onHomePage(){
        String email = view.getEmail();
        String password = view.getPassword();
        User user = accountDAO.findUserByEmail(email);
        if (user != null) {
            if(Objects.equals(password, user.getPassword())) {
                view.homePage(user.getId());
            } else {
                view.showErrorMessage("Wrong password.");
            }
        } else {
            view.showErrorMessage("This email is not associated with an account.");

        }

    }

    /**
     * Η ροή μεταφέρεται στο SignUpPersonalActivity
     */
    public void onSignUpPersonal(){ view.signUpPersonal();}

}
