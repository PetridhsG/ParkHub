package gr.aueb.parkhub.views.util;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.domain.Vehicle;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class ProfileFragment extends Fragment {

    User user;

    AccountDAO accounts;

    /**
     * Δημιουργεί to layout και αρχικοποιεί
     * το fragment.
     * @param savedInstanceState το Instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        accounts = new AccountDAOMemory();
        super.onCreate(savedInstanceState);
    }

    /**
     * Αρχικοποιήση του περιεχομένου του fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int userID = 0;
        View inf = inflater.inflate(R.layout.fragment_profile, container, false);
        Bundle args = getArguments();
        if(args!=null){
            userID = args.getInt("userid");
        }

        User user = accounts.find(userID);
        Vehicle v = user.getVehicle();
        ((TextView) inf.findViewById(R.id.name_surname_text)).setText(user.getName() + " " + user.getSurname());
        ((TextView) inf.findViewById(R.id.vehicle_info_text)).setText(v.getBrand() + " " + v.getModel() + ", " + v.getColor() + ", " + v.getLicensePlate());
        ((TextView) inf.findViewById(R.id.pbucks_text)).setText(Integer.toString(user.getPBucks()));
        ((TextView) inf.findViewById(R.id.name_starter_text)).setText(user.getName().substring(0, 1));

        return inf ;
    }

    /**
     * Θέτει τον χρήστη που περιέχει το fragment
     * @param user ο χρήστης του fragment
     */
    public void setUser(User user){
        this.user = user;
    }

}