package gr.aueb.parkhub.views.viewProfile;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.views.util.ProfileFragment;
import gr.aueb.parkhub.views.editProfile.EditProfileActivity;
import gr.aueb.parkhub.views.homepage.HomepageActivity;

/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class ViewProfileActivity extends AppCompatActivity implements ViewProfileView{

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewprofile_activity);

        final ViewProfilePresenter presenter = new ViewProfilePresenter(this,new AccountDAOMemory());

        findViewById(R.id.viewprofile_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onHomePage();
            }
        });

        findViewById(R.id.viewprofile_edit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onEditProfile();
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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int userId = bundle.getInt("userid");
            ProfileFragment fragment = new ProfileFragment();
            Bundle args = new Bundle();
            args.putInt("userid",userId);
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.viewprofile_profilefragment, fragment).commit();
        }

        ((TextView)findViewById(R.id.viewprofile_name_text)).setText(user.getName());
        ((TextView)findViewById(R.id.viewprofile_surname_text)).setText(user.getSurname());
        ((TextView)findViewById(R.id.viewprofile_email_text)).setText(user.getEmail());
        ((TextView)findViewById(R.id.viewprofile_password_text)).setText(user.getPassword());
        ((TextView)findViewById(R.id.viewprofile_phonenumber_text)).setText(user.getTelephone());
        ((TextView)findViewById(R.id.viewprofile_brand_text)).setText(user.getVehicle().getBrand());
        ((TextView)findViewById(R.id.viewprofile_model_text)).setText(user.getVehicle().getModel());
        ((TextView)findViewById(R.id.viewprofile_color_text)).setText(user.getVehicle().getColor());
        ((TextView)findViewById(R.id.viewprofile_licenseplate_text)).setText(user.getVehicle().getLicensePlate());
        ((TextView)findViewById(R.id.viewprofile_size_text)).setText(((Double.toString( user.getVehicle().getSize()))));
        ((TextView)findViewById(R.id.viewprofile_rating_stars_text)).setText(((Double.toString( user.getRating()))));
        ((TextView)findViewById(R.id.viewprofile_avgdelaytime_text)).setText(((Double.toString( user.getDelay()))));

    }

    /**
     * Επιστρέφει στην αρχική σελίδα
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void homePage(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Η ροή μεταφέρεται στο EditProfileActivity
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void editProfile(Integer userID) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Επιστρέφει το id του συνδεδεμένου χρήστη
     * @return το id του συνδεδεμένου χρήστη
     */
    @Override
    public Integer getAttachedUserID() {
        if (this.getIntent().hasExtra("userid")) {
            return Objects.requireNonNull(this.getIntent().getExtras()).getInt("userid");
        } else {
            return 8;
        }

    }

    /**
     * Εμφανίζει μύνημα error σε περίπτωση
     * που ο χρήστης προσπαθήσει να αλλαξει τα στοιχεια
     * του ενώ εχει κάποια κράτηση
     * @param message το περιεχόμενο του μυνήματος
     */
    public void showErrorMessage(String message) {
        new AlertDialog.Builder(ViewProfileActivity.this)
                .setCancelable(true)
                .setTitle("Access Error")
                .setMessage(message)
                .setPositiveButton("OK",null).create().show();
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
