package gr.aueb.parkhub.views.editProfile;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.views.viewProfile.ViewProfileActivity;

/**
 * @author Χριστουλακης Ιωσηφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class EditProfileActivity extends AppCompatActivity implements EditProfileView {
    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile_activity);

        final EditProfilePresenter presenter = new EditProfilePresenter(this,new AccountDAOMemory());
        findViewById(R.id.editprofile_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onBack();
            }
        });

        findViewById(R.id.editprofile_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onFinish();
            }
        });

    }

    /**
     * Θέτει τα στοιχεία που θα εμφανιστούν
     * για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    @Override
    public void setContent(User user){

        ((EditText)findViewById(R.id.editprofile_name_text)).setText(user.getName());
        ((EditText)findViewById(R.id.editprofile_surname_text)).setText(user.getSurname());
        ((EditText)findViewById(R.id.editprofile_email_text)).setText(user.getEmail());
        ((EditText)findViewById(R.id.editprofile_password_text)).setText(user.getPassword());
        ((EditText)findViewById(R.id.editprofile_phonenumber_text)).setText(user.getTelephone());
        ((EditText)findViewById(R.id.editprofile_brand_text)).setText(user.getVehicle().getBrand());
        ((EditText)findViewById(R.id.editprofile_model_text)).setText(user.getVehicle().getModel());
        ((EditText)findViewById(R.id.editprofile_color_text)).setText(user.getVehicle().getColor());
        ((EditText)findViewById(R.id.editprofile_licenseplate_text)).setText(user.getVehicle().getLicensePlate());
        ((EditText)findViewById(R.id.editprofile_size_text)).setText(((Double.toString( user.getVehicle().getSize()))));
    }


    /**
     * Η ροή μεταφέρεται στο ViewProfileActivity
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void homePage(Integer userID) {
        Intent intent = new Intent(this, ViewProfileActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Η ροή μεταφέρεται στο ViewProfileActivity
     * και ενημερώνει τον χρήστη πως οι αλλαγές αποθηκεύτηκαν επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void finish(Integer userID){
        Intent intent = new Intent(this, ViewProfileActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
        Toast.makeText(this,"Edits saved",Toast.LENGTH_LONG).show();
    }

    /**
     * Επιστρέφει το id του συνδεδεμένου χρήστη
     * @return το id του συνδεδεμένου χρήστη
     */
    @Override
    public Integer getAttachedUserID() {
        return this.getIntent().hasExtra("userid") ? this.getIntent().getExtras().getInt("userid") : 8;
    }

    /**
     * Εμφανίζει μύνημα σε περίπτωση λάθος τιμής εισαγωγής
     * @param message το περιεχόμενο του μυνήματος
     */
    @Override
    public void showErrorMessage(String message) {
        new AlertDialog.Builder(EditProfileActivity.this)
                .setCancelable(true)
                .setTitle("Input Error")
                .setMessage(message)
                .setPositiveButton("OK",null).create().show();
    }

    /**
     * Επιστρέφει το όνομα
     * @return το όνομα
     */
    @Override
    public String getName() {
        return ((EditText)findViewById(R.id.editprofile_name_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το επώνυμο
     * @return το επώνυμο
     */
    @Override
    public String getSurname() {
        return ((EditText)findViewById(R.id.editprofile_surname_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το email
     * @return το email
     */
    @Override
    public String getEmail() {
        return ((EditText)findViewById(R.id.editprofile_email_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει τον κωδικό
     * @return τον κωδικό
     */
    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.editprofile_password_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το τηλέφωνο
     * @return το τηλέφωνο
     */
    @Override
    public String getTelephone() {
        return ((EditText)findViewById(R.id.editprofile_phonenumber_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει τη μάρκα του αυτοκινήτου
     * @return τη μάρκα του αυτοκινήτου
     */
    @Override
    public String getBrand() {
        return ((EditText)findViewById(R.id.editprofile_brand_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το μοντέλο του αυτοκινήτου
     * @return το μοντέλο του αυτοκινήτου
     */
    @Override
    public String getModel() {
        return ((EditText)findViewById(R.id.editprofile_model_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το χρώμα του αυτοκινήτου
     * @return το χρώμα του αυτοκινήτου
     */
    @Override
    public String getColor() {
        return ((EditText)findViewById(R.id.editprofile_color_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει τη πινακίδα του αυτοκινήτου
     * @return τη πινακίδα του αυτοκινήτου
     */
    @Override
    public String getLicensePlate() {
        return ((EditText)findViewById(R.id.editprofile_licenseplate_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει το μέγεθος του αυτοκινήτου
     * @return το μέγεθος του αυτοκινήτου
     */
    @Override
    public String getSize() {
        return ((EditText)findViewById(R.id.editprofile_size_text)).getText().toString().trim();
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
     * Απενεργοποίηση της λειτουργίας πίσω
     * από το navigation menu του android
     */
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }

}
