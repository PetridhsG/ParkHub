package gr.aueb.parkhub.views.rating;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.domain.SearchingUser;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.domain.Vehicle;
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
public class RatingActivity extends AppCompatActivity implements RatingView{

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_activity);

        RatingPresenter presenter = new RatingPresenter(this,new AccountDAOMemory(),new SpotsDAOMemory());

        findViewById(R.id.rating_back_button).setOnClickListener(v12 -> presenter.onBack());

        findViewById(R.id.rating_submit_button).setOnClickListener(v1 -> presenter.onSubmit());
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
            getSupportFragmentManager().beginTransaction().replace(R.id.rating_profilefragment, fragment).commit();
        }

        SearchingUser searchingUser = (SearchingUser) user ;
        User u = searchingUser.getSpotReservation().getParkingSpot().getUser();
        Vehicle v = u.getVehicle();

        ((TextView)findViewById(R.id.rating_username_text)).setText("User Name: " + u.getName() + " " + u.getSurname());
        ((TextView)findViewById(R.id.rating_vehicle_text)).setText("Vehicle Info: " + v.toString());

        Spinner dropdown = findViewById(R.id.rating_spinner);
        String[] items = new String[]{"0.5","1","1.5","2.0","2.5","3.0","3.5","4.0","4.5","5.0"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
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
     * Καταχωρεί την αξιολόγηση στο σύστημα
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void submit(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
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
     * Θέτει τα σχόλια για την αξιολόγηση
     * @param comments τα σχόλια
     */
    @Override
    public void setComments(String comments) {
        ((EditText)findViewById(R.id.rating_comments)).setText(comments);
    }

    /**
     * Θέτει την βαθμολογία της αξιολόγηση
     * @param rating η βαθμολογία
     */
    @Override
    public void setRating(double rating) {

    }

    /**
     * Επιστρέφει τα σχόλια της αξιολόγησης
     * @return τα σχόλια
     */
    @Override
    public String getComments() {
        return ((EditText)findViewById(R.id.rating_comments)).getText().toString();
    }

    /**
     * Επιστρέφει την βαθμολογία της αξιολόγησης
     * @return η βαθμολογία
     */
    @Override
    public double getRating() {
        return Double.parseDouble(((Spinner)findViewById(R.id.rating_spinner)).getSelectedItem().toString());
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
