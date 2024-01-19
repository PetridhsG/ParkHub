package gr.aueb.parkhub.views.homepage;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.domain.ParkedUser;
import gr.aueb.parkhub.domain.SearchingUser;
import gr.aueb.parkhub.domain.SpotReservation;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.views.util.ProfileFragment;
import gr.aueb.parkhub.views.pBucksRenewal.PBucksRenewalActivity;
import gr.aueb.parkhub.views.rating.RatingActivity;
import gr.aueb.parkhub.views.spotDeclaration.SpotDeclarationActivity;
import gr.aueb.parkhub.views.spotReservation.SpotReservationActivity;

import gr.aueb.parkhub.views.viewProfile.ViewProfileActivity;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class HomepageActivity extends AppCompatActivity implements HomepageView {

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_activity);

        HomepagePresenter presenter = new HomepagePresenter(this,new AccountDAOMemory());


        findViewById(R.id.homepage_viewProfile_button).setOnClickListener(v -> presenter.onViewProfile());

        findViewById(R.id.homepage_addPBucks_button).setOnClickListener(v -> presenter.onAddPBucks());

        findViewById(R.id.homepage_declareSpot_button).setOnClickListener(v -> presenter.onDeclareSpot());

        findViewById(R.id.homepage_reserveSpot_button).setOnClickListener(v -> presenter.onReserveSpot());

        findViewById(R.id.homepage_exchangeSpot_button).setOnClickListener(v -> presenter.onExchangeSpot());

        findViewById(R.id.homepage_falseSpot_button).setOnClickListener(v -> presenter.onReportFalseSpot());

        findViewById(R.id.homepage_viewStatistics_button).setOnClickListener(v -> presenter.onViewStatistics());
    }

    /**
     * Θέτει το περιεχόμενο για τον συνδεδεμένο χρήστη
     * avάλογα ποιας κλάσης instance είναι
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
            getSupportFragmentManager().beginTransaction().replace(R.id.homepage_profilefragment, fragment).commit();
        }

        if (user instanceof SearchingUser){
            SpotReservation sp = ((SearchingUser) user).getSpotReservation();
            ((TextView)findViewById(R.id.homepage_spot_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.homepage_address_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.homepage_time_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.homepage_username_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.homepage_vehicle_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.homepage_spot_text)).setText("You have reserved the following spot:");
            ((TextView)findViewById(R.id.homepage_address_text)).setText(sp.getParkingSpot().getAddress().toString());
            ((TextView)findViewById(R.id.homepage_time_text)).setText("Time: " + sp.getArrivalTime().toString() );
            ((TextView)findViewById(R.id.homepage_username_text)).setText("User Name: " + sp.getParkingSpot().getUser().getName() + " " + sp.getParkingSpot().getUser().getSurname());
            ((TextView)findViewById(R.id.homepage_vehicle_text)).setText("Vehicle Info: " + sp.getParkingSpot().getUser().getVehicle().toString());
        }
        else if (user instanceof ParkedUser) {
            ((TextView)findViewById(R.id.homepage_spot_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.homepage_address_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.homepage_time_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.homepage_username_text)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.homepage_vehicle_text)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.homepage_spot_text)).setText("You have declared the following spot:");
            ((TextView)findViewById(R.id.homepage_address_text)).setText(((ParkedUser)user).getParkingSpot().getAddress().toString());
            ((TextView)findViewById(R.id.homepage_time_text)).setText("Time: " + ((ParkedUser)user).getParkingSpot().getTime().toString() );
        }
        else{
            ((TextView)findViewById(R.id.homepage_spot_text)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.homepage_address_text)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.homepage_time_text)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.homepage_username_text)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.homepage_vehicle_text)).setVisibility(View.INVISIBLE);
        }

    }

    /**
     * Επιστρέφει το Id του συνδεδεμένου χρήστη
     * @return το Id του συγκεκριμένου χρήστη
     */
    @Override
    public Integer getAttachedUserID() {
        return this.getIntent().hasExtra("userid") ? this.getIntent().getExtras().getInt("userid") : 9; // edw to 8 na ginei null
    }

    /**
     * Η ροή μεταφέρεται στο ViewProfileActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    @Override
    public void viewProfile(Integer userID) {
        Intent intent = new Intent(this, ViewProfileActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);

    }

    /**
     * Η ροή μεταφέρεται στο PBucksRenewalActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    @Override
    public void addPBucks(Integer userID){
        Intent intent = new Intent(this, PBucksRenewalActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Η ροή μεταφέρεται στο SpotDeclaationActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    @Override
    public void declareSpot(Integer userID) {
        Intent intent = new Intent(this, SpotDeclarationActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Η ροή μεταφέρεται στο SpotReservationActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    @Override
    public void reserveSpot(Integer userID) {
        Intent intent = new Intent(this, SpotReservationActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);

    }

    /**
     * Πραγματοποιείται η διαδικασία ανταλλαγής θέσης
     */
    @Override
    public void exchangeSpot(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Η ροή μεταφέρεται στο RatingActivity
     * @param userID το Id του συνδεδεμένου χρήστη
     */
    @Override
    public void reportFalseSpot(Integer userID) {
        Intent intent = new Intent(this, RatingActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);

    }

    /**
     * Η ροή μεταφέρεται στο StatisticsProfile
     */
    @Override
    public void viewStatistics(Integer userID) {


    }

    /**
     * Tο μύνημα που εμφανίζεται σε περίπτωση error
     * @param title ο τίτλος του μυνήματος
     * @param message το περιεχόμενο του μυνήματος
     */
    @Override
    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(HomepageActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK",null).create().show();
    }

    /**
     * Tο Toast μύνημα που εμφανίζεται
     * @param message το περιεχόμενο του μυνήματος
     */
    @Override
    public void showToastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
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

