package gr.aueb.parkhub.views.signUpVehicle;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.views.signIn.SignInActivity;
import gr.aueb.parkhub.views.signUpPersonal.SignUpPersonalActivity;

public class SignUpVehicleActivity extends AppCompatActivity implements SignUpVehicleView {

    /**
     * @author Δημήτρης Κεφαλάς
     *
     * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupvehicle_activity);
        final SignUpVehiclePresenter presenter = new SignUpVehiclePresenter(this, new AccountDAOMemory());
        findViewById(R.id.signUp_vehicle_finish_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSignUpComplete();
            }
        });

        findViewById(R.id.signUp_vehicle_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSignUpPersonal();
            }
        });
    }

    /**
     * Η ροή μεταφέρεται στο SignInActivity
     */
    public void signUpComplete() {
        Intent intent2 = new Intent(this, SignInActivity.class);
        startActivity(intent2);
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
        new AlertDialog.Builder(SignUpVehicleActivity.this)
                .setCancelable(true)
                .setTitle("Input Error")
                .setMessage(message)
                .setPositiveButton("OK", null).create().show();
    }

    /**
     * Επιστρέφει το Name που συμπληρώνει ο χρήστης
     * @return το Name που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getName() {
        return getIntent().getStringExtra("name");
    }

    /**
     * Επιστρέφει το Surname που συμπληρώνει ο χρήστης
     * @return το Surname που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getSurname() {
        return getIntent().getStringExtra("surname");
    }

    /**
     * Επιστρέφει το Email που συμπληρώνει ο χρήστης
     * @return το Email που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getEmail() {
        return getIntent().getStringExtra("email");
    }

    /**
     * Επιστρέφει το Password που συμπληρώνει ο χρήστης
     * @return το Password που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getPassword() {
        return getIntent().getStringExtra("password");
    }

    /**
     * Επιστρέφει το Telephone που συμπληρώνει ο χρήστης
     * @return το Telephone που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getTelephone() {
        return getIntent().getStringExtra("phoneNumber");
    }

    /**
     * Επιστρέφει το Brand που συμπληρώνει ο χρήστης
     * @return το Brand που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getBrand() {
        return ((EditText) findViewById(R.id.signUpVehicle_brand_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Model που συμπληρώνει ο χρήστης
     * @return το Model που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getModel() {
        return ((EditText) findViewById(R.id.signUpVehicle_model_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Color που συμπληρώνει ο χρήστης
     * @return το Color που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getColor() {
        return ((EditText) findViewById(R.id.signUpVehicle_color_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το LicensePlate που συμπληρώνει ο χρήστης
     * @return το LicensePlate που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getLicensePlate() {
        return ((EditText) findViewById(R.id.signUpVehicle_LicensePlate_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Size που συμπληρώνει ο χρήστης
     * @return το Size που συμπληρώνεται από τον χρήστη
     */
    @Override
    public String getSize() {
        return ((EditText) findViewById(R.id.signUpVehicle_Size_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το Intent
     * @return το Intent
     */
    @Override
    public Intent getIntent() {
        return super.getIntent();
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