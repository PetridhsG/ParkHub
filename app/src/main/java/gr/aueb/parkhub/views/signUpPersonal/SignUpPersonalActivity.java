package gr.aueb.parkhub.views.signUpPersonal;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.util.Patterns;
import android.widget.EditText;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.views.signIn.SignInActivity;
import gr.aueb.parkhub.views.signUpVehicle.SignUpVehicleActivity;

public class SignUpPersonalActivity extends AppCompatActivity implements  SignUpPersonalView{

    /**
     * @author Δημήτρης Κεφαλάς
     *
     * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppersonal_activity);

        final SignUpPersonalPresenter presenter = new SignUpPersonalPresenter(this);

        findViewById(R.id.signUp_personal_next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { presenter.onSignUpVehicle(); }
        });


        findViewById(R.id.signUp_personal_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { presenter.onSignIn(); }
        });
    }

    /**
     * Η ροή μεταφέρεται στο SignUpVehicleActivity
     */
    public void signUpVehicle() {
        Intent intent = new Intent(this, SignUpVehicleActivity.class);
        intent.putExtra("name", getName());
        intent.putExtra("surname", getSurname());
        intent.putExtra("email", getEmail());
        intent.putExtra("password", getPassword());
        intent.putExtra("phoneNumber", getTelephone());
        startActivity(intent);
    }

    /**
     * Η ροή μεταφέρεται στο SignInActivity
     */
    public void signIn() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    /**
     * Ελέγχει αν είναι δεκτής μορφής το email που δώθηκε
     *  @param email το email που δώθηκε
     * @return true αν είναι δεκτό αλλιώς false
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    /**
     * Tο μύνημα που εμφανίζεται σε περίπτωση error
     * @param message το περιεχόμενο του μυνήματος
     */
    @Override
    public void showErrorMessage(String message) {
        new AlertDialog.Builder(SignUpPersonalActivity.this)
                .setCancelable(true)
                .setTitle("Input Error")
                .setMessage(message)
                .setPositiveButton("OK",null).create().show();
    }

    /**
     * Επιστρέφει το Name που συμπληρώνει ο χρήστης
     * @return το Name που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getName() {
        return ((EditText)findViewById(R.id.signUpPersonal_name_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Surname που συμπληρώνει ο χρήστης
     * @return το Surname που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getSurname() {
        return ((EditText)findViewById(R.id.signUpPersonal_lastname_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Email που συμπληρώνει ο χρήστης
     * @return το Email που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getEmail() {
        return ((EditText)findViewById(R.id.signUpPersonal_email_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Password που συμπληρώνει ο χρήστης
     * @return το Password που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.signUpPersonal_password_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Telephone που συμπληρώνει ο χρήστης
     * @return το Telephone που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getTelephone() {
        return ((EditText)findViewById(R.id.signUpPersonal_phonenumber_text)).getText().toString().trim();
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

