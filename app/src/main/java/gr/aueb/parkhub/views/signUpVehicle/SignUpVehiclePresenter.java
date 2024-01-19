package gr.aueb.parkhub.views.signUpVehicle;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.domain.Vehicle;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SignUpVehiclePresenter {

    private AccountDAO accounts;
    private SignUpVehicleView view;

    /**
     * Αρχικοποιεί τον presenter
     * @param view Ένα instance του view
     * @param accounts Ένα instance tou AccountDAO
     */
    public SignUpVehiclePresenter(SignUpVehicleView view, AccountDAO accounts){
        this.view = view;
        this.accounts = accounts;
    }

    /**
     * Αν ο χρήστης εισάγει έγκυρα στοιχεία, δημιουργείται ο λογαριασμός του χρήστη
     * και η ροή μεταφέρεται στο SignInActivity αλλιώς
     * εμφανίζεται κατάλληλο μύνημα λάθους
     */
    public void onSignUpComplete(){
        String name = view.getName();
        String surname = view.getSurname();
        String email = view.getEmail();
        String password = view.getPassword();
        String telephone = view.getTelephone();
        String brand = view.getBrand();
        String model = view.getModel();
        String color = view.getColor();
        String licenseplate = view.getLicensePlate();
        String size = view.getSize();


        if(!brand.matches("^[^\\d]*$") || brand.length() == 0 ){
            view.showErrorMessage("Please only use letters in the brand text.");
        }
        else if(!model.matches("[a-zA-Z0-9]+") || model.length() == 0 ){
            view.showErrorMessage("Please only use letters and numbers in the model text.");
        }
        else if(!color.matches("^[^\\d]*$") || color.length() == 0 ){
            view.showErrorMessage("Please only use letters in the color text.");
        }
        else if(!licenseplate.matches("[a-zA-Z0-9Α-Ωα-ω]+") || licenseplate.length() == 0 ){
            view.showErrorMessage("Please only use letters and numbers in the license plate text.");
        }
        else if(!size.matches("^[^a-zA-Z]*$") || size.length() == 0 ){
            view.showErrorMessage("Please only use numbers in the size text.");
        }else {
            accounts.save(new User(name, surname, email, password, telephone, new Vehicle(brand, Double.parseDouble(size), model, color, licenseplate)));
            view.signUpComplete();
        }
    }

    /**
     * Η ροή μεταφέρεται στο SignUpPersonalActivity
     */
    public void onSignUpPersonal(){view.signUpPersonal();}

}
