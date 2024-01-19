package gr.aueb.parkhub.views.spotDeclaration;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.domain.Time;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.SpotsDAOMemory;
import gr.aueb.parkhub.views.util.ProfileFragment;
import gr.aueb.parkhub.views.homepage.HomepageActivity;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */


public class SpotDeclarationActivity extends AppCompatActivity implements SpotDeclarationView{

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spotdeclaration_activity);

        SpotDeclarationPresenter presenter = new SpotDeclarationPresenter(this,new AccountDAOMemory(),new SpotsDAOMemory());

        findViewById(R.id.spotDeclaration_back_button).setOnClickListener(v -> presenter.onBack());

        findViewById(R.id.spotDeclaration_declare_button).setOnClickListener(v -> presenter.onDeclare());

    }

    /**
     * Θέτει το περιεχόμενο που θα εμφανιστεί
     * για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    @Override
    public void setContent(User user) {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int userId = bundle.getInt("userid");
            ProfileFragment fragment = new ProfileFragment();
            Bundle args = new Bundle();
            args.putInt("userid",userId);
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.spotdeclaration_profilefragment, fragment).commit();
        }

        TimePicker timePicker = (TimePicker) findViewById(R.id.spotDeclaration_TimePicker);
        timePicker.setIs24HourView(true);
    }

    /**
     * Εμφανίζει μύνημα σε περίπτωση error
     * @param message το περιεχόμενο του μυνήματος
     */
    @Override
    public void showErrorMessage(String message)
    {
        new AlertDialog.Builder(SpotDeclarationActivity.this)
                .setCancelable(true)
                .setTitle("Input Error")
                .setMessage(message)
                .setPositiveButton("OK",null).create().show();
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
     * Επιστρέφει στην αρχική οθόνη
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void back(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }


    /**
     * Επιστρέφει στην αρχική οθόνη
     * τυπώνοντας μύνημα επιτυχίας
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void declare(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
        Toast.makeText(this,"Declaration was successful!",Toast.LENGTH_LONG).show();
    }

    /**
     * Θέτει την οδό της διέθυνσης
     * @param street Το όνομα της οδού
     */
    @Override
    public void setStreet(String street) {
        ((EditText)findViewById(R.id.spotDeclaration_street_text)).setText(street);
    }

    /**
     * Θέτει τον αριθμό οδόύ της διέθυνσης
     * @param stNumber Ο αριθμός της οδού
     */
    @Override
    public void setStNumber(int stNumber) {
        ((EditText)findViewById(R.id.spotDeclaration_stnumber_text)).setText(stNumber);
    }

    /**
     * Θέτει την πόλη της διέθυνσης
     * @param city Το όνομα της πόλης
     */
    @Override
    public void setCity(String city) {
        ((EditText)findViewById(R.id.spotDeclaration_city_text)).setText(city);
    }

    /**
     * Θέτει την περιοχή της διέθυνσης
     * @param region Το όνομα της πόλης
     */
    @Override
    public void setRegion(String region) {
        ((EditText)findViewById(R.id.spotDeclaration_region_text)).setText(region);
    }

    /**
     * Θέτει την ώρα που θα είναι διαθέσιμη η θέση
     * @param time Η ώρα που θα είναι διαθέσιμη η θέση
     */
    @Override
    public void setTime(Time time) {

    }

    /**
     * Επιστρέφει την οδό της διέθυνσης
     * @return την οδό της διέθυνσης
     */
    @Override
    public String getStreet() {
       return ((EditText)findViewById(R.id.spotDeclaration_street_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει τον αριθμό οδού της διέθυνσης
     * @return τον αριθμό οδού της διέθυνσης
     */
    @Override
    public String getStNumber() {
        return (((EditText)findViewById(R.id.spotDeclaration_stnumber_text)).getText().toString().trim());
    }

    /**
     * Επιστρέφει την πόλη της διέθυνσης
     * @return την πόλη της διέθυνσης
     */
    @Override
    public String getCity() {
        return ((EditText)findViewById(R.id.spotDeclaration_city_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει την περιοχή διέθυνσης
     * @return την περιοχή της διέθυνσης
     */
    @Override
    public String getRegion() {
        return ((EditText)findViewById(R.id.spotDeclaration_region_text)).getText().toString().trim();
    }

    /**
     * Επιστρέφει την ώρα που θα είναι διαθέσιμη η θέση
     * @return η ώρα που θα είναι διαθέσιμη η θέση
     */
    @Override
    public Time getTime() {
        TimePicker timePicker = (TimePicker) findViewById(R.id.spotDeclaration_TimePicker);
        return new Time(timePicker.getHour(),timePicker.getMinute());
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
