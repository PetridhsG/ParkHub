package gr.aueb.parkhub.views.pBucksRenewal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.views.homepage.HomepageActivity;

/**
 * @author Χριστουλακης Ιωσηφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class PBucksRenewalActivity extends AppCompatActivity implements PBucksRenewalView {

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το activity.
     * @param savedInstanceState το Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pbucksrenewal_activity);

        final PBucksRenewalPresenter presenter  = new PBucksRenewalPresenter(this, new AccountDAOMemory());

        findViewById(R.id.pbucksrenewal_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onBack();
            }
        });

        findViewById(R.id.pbucksrenewal_10pack_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onPack10();
            }
        });

        findViewById(R.id.pbucksrenewal_20pack_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onPack20();
            }
        });

        findViewById(R.id.pbucksrenewal_50pack_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onPack50();
            }
        });

        findViewById(R.id.pbucksreanewal_100pack_buton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                presenter.onPack100();
            }
        });
    }

    /**
     * Θέτει τον αριθμό των P-Bucks που θα εμφανιστούν
     * για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    public void setContent(User user){
        ((TextView)findViewById(R.id.pbucksreanewal_showpbucks_text)).setText(Integer.toString(user.getPBucks()));
    }

    /**
     * Η ροή μεταφέρεται στο HomepageActivity
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void homePage(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
    }

    /**
     * Η ροή μεταφέρεται στο HomePageActivity
     * και ενημερώνει τον χρήστη πως προστέθηκαν
     * 10 P-Bucks στον λογαριασμό του επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void pack10(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
        Toast.makeText(this,"Adding 10 P-Bucks to your balance",Toast.LENGTH_LONG).show();

    }

    /**
     * Η ροή μεταφέρεται στο HomePageActivity
     * και ενημερώνει τον χρήστη πως προστέθηκαν
     * 20 P-Bucks στον λογαριασμό του επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void pack20(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
        Toast.makeText(this,"Adding 20 P-Bucks to your balance",Toast.LENGTH_LONG).show();
    }

    /**
     * Η ροή μεταφέρεται στο HomePageActivity
     * και ενημερώνει τον χρήστη πως προστέθηκαν
     * 50 P-Bucks στον λογαριασμό του επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void pack50(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
        Toast.makeText(this,"Adding 50 P-Bucks to your balance",Toast.LENGTH_LONG).show();
    }

    /**
     * Η ροή μεταφέρεται στο HomePageActivity
     * και ενημερώνει τον χρήστη πως προστέθηκαν
     * 100 P-Bucks στον λογαριασμό του επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    @Override
    public void pack100(Integer userID) {
        Intent intent = new Intent(this, HomepageActivity.class);
        intent.putExtra("userid",userID);
        startActivity(intent);
        Toast.makeText(this,"Adding 100 P-Bucks to your balance",Toast.LENGTH_LONG).show();
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
     * Απενεργοποίηση της λειτουργίας πίσω
     * από το navigation menu του android
     */
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }


}