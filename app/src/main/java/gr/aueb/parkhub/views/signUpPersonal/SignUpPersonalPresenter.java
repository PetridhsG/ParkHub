package gr.aueb.parkhub.views.signUpPersonal;

import static gr.aueb.parkhub.views.signUpPersonal.SignUpPersonalActivity.isValidEmail;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SignUpPersonalPresenter {


    private SignUpPersonalView view;

    /**
     * Αρχικοποιεί τον presenter
     * @param view Ένα instance του view
     */
    public SignUpPersonalPresenter(SignUpPersonalView view) {
        this.view=view;
    }

    /**
     * Αν ο χρήστης εισάγει έγκυρα στοιχεία,η ροή μεταφέρεται στο
     * SignUpVehicleActivity αλλιώς
     * εμφανίζεται κατάλληλο μύνημα λάθους
     */
    public void onSignUpVehicle() {
        String name = view.getName();
        String surname= view.getSurname();
        String email = view.getEmail();
        String password = view.getPassword();
        String phonenumber = view.getTelephone();

        if(!name.matches("^[^\\d]*$") || name.length() == 0 ){
            view.showErrorMessage("Please only use letters in the name text.");
        }
        else if(!surname.matches("^[^\\d]*$") || surname.length() == 0 ){
            view.showErrorMessage("Please only use letters in the surname text.");
        }
        else if(!(isValidEmail(email)) || email.length() == 0 ){
            view.showErrorMessage("Please enter a valid email address.");
        }
        else if(password.length() == 0 ){
            view.showErrorMessage("Please fill the password text.");
        }
        else if(!phonenumber.matches("^[^a-zA-Z]*$") || phonenumber.length() != 10 ){
            view.showErrorMessage("Please only use numbers in the phone number text and make sure they are 10.");
        } else{
            view.signUpVehicle();
        }
    }

    /**
     * Η ροή μεταφέρεται στο SignInActivity
     */
    public void onSignIn() {view.signIn();}


}
