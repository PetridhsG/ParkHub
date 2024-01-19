package gr.aueb.parkhub.viewtests.signInTest;

import gr.aueb.parkhub.views.signIn.SignInView;
import gr.aueb.parkhub.views.signIn.SignInPresenter;


/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SignInStub implements SignInView {

    private SignInPresenter presenter;

    private String errorMessage;
    private String email;
    private String password;
    private int SignUpPersonalClicks;
    private int HomepageClicks;

    private int userID;



    @Override
    public void homePage(Integer userID) {
        this.userID = userID;
        HomepageClicks++;
    }

    public int getHomepageClicks(){
        return HomepageClicks;
    }

    @Override
    public void signUpPersonal() {
        SignUpPersonalClicks++;
    }

    public int getSignUpPersonalClicks(){
        return SignUpPersonalClicks;
    }


    @Override
    public void showErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
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
}