package gr.aueb.parkhub.views.signIn;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.views.homepage.HomepageActivity;
import gr.aueb.parkhub.views.signUpPersonal.SignUpPersonalActivity;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SignInActivity extends AppCompatActivity implements SignInView {

    private static boolean initialized = false;

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        if (!initialized) {
            new MemoryInitializer().prepareData();
            initialized = true;
        }

        final SignInPresenter presenter = new SignInPresenter(this, new AccountDAOMemory());

        findViewById(R.id.signIn_signIn_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onHomePage();
            }
        });

        findViewById(R.id.signIn_signUp_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onSignUpPersonal();
            }
        });
    }

    /**
     * Η ροή μεταφέρεται στο HomepageActivity
     * @param userID το Id του χρήστη που συνδέεται
     */
    @Override
    public void homePage(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Η ροή μεταφέρεται στο SignUpPersonalActivity
     */
    public void signUpPersonal() {
        Intent intent = new Intent(this, SignUpPersonalActivity.class);
        startActivity(intent);
    }

    /**
     * Tο μύνημα που εμφανίζεται σε περίπτωση error
     * @param message το περιεχόμενο του μυνήματος
     */
    @Override
    public void showErrorMessage(String message) {
        new AlertDialog.Builder(SignInActivity.this)
                .setCancelable(true)
                .setTitle("Input Error")
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }

    /**
     * Επιστρέφει το Email που συμπληρώνει ο χρήστης
     * @return το Email που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getEmail() {
        return ((EditText)findViewById(R.id.signIn_email_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Password που συμπληρώνει ο χρήστης
     * @return το Password που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.signIn_password_text)).getText().toString().trim();
    }

    /**
     * Απενεργοποίηση της λειτουργίας πίσω
     * από το navigation menu του android
     */
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }
}