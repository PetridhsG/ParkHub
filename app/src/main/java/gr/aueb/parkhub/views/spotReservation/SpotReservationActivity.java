package gr.aueb.parkhub.views.spotReservation;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.domain.ParkingSpot;
import gr.aueb.parkhub.domain.Time;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.ReservationDAOMemory;
import gr.aueb.parkhub.memorydao.SpotsDAOMemory;
import gr.aueb.parkhub.views.util.ProfileFragment;
import gr.aueb.parkhub.views.homepage.HomepageActivity;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */


public class SpotReservationActivity extends AppCompatActivity implements SpotReservationView {

    private ParkingSpotAdapter adapter;
    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spotreservation_activity);

        final SpotReservationPresenter presenter = new SpotReservationPresenter(
                this,new AccountDAOMemory(),new SpotsDAOMemory(),new ReservationDAOMemory());

        findViewById(R.id.spotReservation_back_button).setOnClickListener(v -> presenter.onBack());

        findViewById(R.id.spotReservation_filter_button).setOnClickListener(v->presenter.onApply());

        findViewById(R.id.spotReservation_confirm_button).setOnClickListener(v->presenter.onConfirm());

    }

    /**
     * Θέτει το περιεχόμενο για τον συνδεδεμένο χρήστη
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
            getSupportFragmentManager().beginTransaction().replace(R.id.spotreservation_profilefragment, fragment).commit();
        }

        TimePicker timePicker = (TimePicker) this.findViewById(R.id.spotReservation_TimePicker);
        timePicker.setIs24HourView(true);

        List<ParkingSpot> parkingSpots = new SpotsDAOMemory().findAll();
        RecyclerView recyclerView = findViewById(R.id.spotReservation_recycler);

        this.adapter = new ParkingSpotAdapter(this, parkingSpots);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Επιστρέφει στην αρχική σελίδα
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void back(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Επιστρέφει την ώρα άφιξης του χρήστη
     * @return η ώρα άφιξης του χρήστη
     */
    @Override
    public Time getTime() {
        TimePicker timePicker = findViewById(R.id.spotReservation_TimePicker);
        return new Time(timePicker.getHour(),timePicker.getMinute());
    }

    /**
     * Θέτει την ώρα άφιξης του χρήστη
     * @param time η ώρα άφιξης του χρήστη
     */
    @Override
    public void setTime(Time time) {

    }

    /**
     * Επιστρέφει την περιοχή αναζήτησης
     * @return η περιοχή αναζήτησης
     */
    @Override
    public String getRegion() {
        return ((EditText)findViewById(R.id.spotReservation_region_text)).getText().toString();
    }

    /**
     * Θέτει την περιοχή αναζήτησης
     * @param region η περιοχή αναζήτησης
     */
    @Override
    public void setRegion(String region) {
        ((EditText)findViewById(R.id.spotReservation_region_text)).setText(region);
    }

    /**
     * Επιστρέφει το Id του συνδεδεμένου χρήστη
     * @return το Id του συγκεκριμένου χρήστη
     */
    @Override
    public Integer getAttachedUserID() {
        return this.getIntent().hasExtra("userid") ? this.getIntent().getExtras().getInt("userid") : 8;
    }

    /**
     * Εφαρμόζει φίλτρο στην αναζήτηση
     * @param constraint ο περιορισμός για το φίλτρο
     */
    @Override
    public void apply(String constraint) {
        this.adapter.getFilter().filter(constraint);
    }

    /**
     * Επιβεβαιώνει την κράτηση μίας θέσης
     * @param userID το Id του συγκεκριμένου χρήστη
     */
    @Override
    public void confirm(Integer userID){
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Θέτει το ID για την συγκεκριμένη θέση
     * @param parkingSpotID το ID της θέσης
     */
    @Override
    public void setParkingSpotID(Integer parkingSpotID) {

    }

    /**
     * Επιστρέφει το ID της συγκεκριμένης θέσης
     * @return το ID της θέσης
     */
    @Override
    public Integer getParkingSpotID() {
        return adapter.getParkingSpotID();
    }


    /**
     * Εμφανίζει μύνημα στο χρήστη
     * @param title ο τίτλος του μυνήματος
     * @param message το περιεχόμενο του μυνήματος
     */
    @Override
    public void showMessage(String title, String message) {
        new AlertDialog.Builder(SpotReservationActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK",null).create().show();
    }

    /**
     * Εμφανίζει μύνημα στο χρήστη
     *
     * @param toastMessage το περιεχόμενο του μυνήματος
     */
    @Override
    public void showToast(String toastMessage) {
        Toast.makeText(this,toastMessage,Toast.LENGTH_LONG).show();
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
