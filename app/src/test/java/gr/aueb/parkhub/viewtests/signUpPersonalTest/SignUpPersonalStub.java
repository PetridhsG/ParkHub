package gr.aueb.parkhub.viewtests.signUpPersonalTest;

import gr.aueb.parkhub.views.signUpPersonal.SignUpPersonalView;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SignUpPersonalStub implements SignUpPersonalView {

    private String errorMessage;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String telephone;

    private int SignInClicks;
    private int SignUpVehicleClicks;


    @Override
    public void signUpVehicle() {
        SignUpVehicleClicks++;
    }

    @Override
    public void signIn() {
        SignInClicks++;
    }

    public int getSignInClicks(){
        return SignInClicks;
    }

    public int getSignUpVehicleClicks(){
        return SignUpVehicleClicks;
    }

    @Override
    public void showErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
