package gr.aueb.parkhub.views.spotReservation;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import gr.aueb.parkhub.R;
import gr.aueb.parkhub.domain.ParkingSpot;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class ParkingSpotAdapter extends RecyclerView.Adapter<ParkingSpotAdapter.ViewHolder> implements Filterable {

    private List<ParkingSpot> parkingSpots;
    private List<ParkingSpot> filteredParkingSpots;
    private Context context;
    private Integer parkingSpotID ;

    /**
     * Αρχικοποίηση των αντικειμένων του adapter
     * @param context το activity που περιέχεται
     * @param parkingSpots οι θέσεις που περιέχει
     */
    public ParkingSpotAdapter(Context context, List<ParkingSpot> parkingSpots) {
        this.context = context;
        this.parkingSpots = parkingSpots;
        this.filteredParkingSpots = new ArrayList<>(parkingSpots);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parking_spot_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ParkingSpot spot = filteredParkingSpots.get(position);
        holder.textView.setText(spot.getAddress().toString() +" "+ spot.getTime());


        holder.itemView.setOnClickListener(v -> showReservationConfirmationPopup(spot));
    }

    @Override
    public int getItemCount() {
        return filteredParkingSpots.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.parking_spot_item_text);
        }
    }

    /**
     * Εμφανίζει popup παράθυρο περιμένοντας
     * την απάντηση του χρήστη
     * @param spot η συγκεκριμένη θέση
     */
    private void showReservationConfirmationPopup(ParkingSpot spot) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Select Spot");
        builder.setMessage("Are you sure you want to select:\n" + spot.getAddress().toString() + " "
                + spot.getTime().toString() + "\nFrom user:"
                + "\nName: " + spot.getUser().getName()
                + "\nSurname: " + spot.getUser().getSurname()
                + "\nAverageDelayTime: " + spot.getUser().getAverageDelayTime()
                + "\nRating: " + + spot.getUser().getRating()
        );

        builder.setPositiveButton("Yes", (dialog, which) -> { handleReservationConfirmation(spot);});

        builder.setNegativeButton("No", (dialog, which) -> {dialog.dismiss();});

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Όταν ο χρήστης απαντήσει θετικά
     * @param spot
     */
    private void handleReservationConfirmation(ParkingSpot spot) {
        this.parkingSpotID = spot.getId();
    }

    /**
     * Επιστρέφει το ID της επιλεγμένης θέσης
     * @return το ID της επιλεγμένης θέσης
     */
    public Integer getParkingSpotID(){
        return this.parkingSpotID;
    }

    /**
     * Επιστρέφει το φίλτρο
     * @return το φίλτρο
     */
    @Override
    public Filter getFilter() {
        return new Filter() {

            /**
             * Εφαρμόζει το φίλτρο βάσει του constraint
             * @param constraint ο περιορισμός για το φίλτρο
             * @return οι φιλτραρισμένες θέσεις
             */
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String filterPattern = constraint.toString().toLowerCase().trim();
                int regionIndex = constraint.toString().indexOf("Region:");
                int timeIndex = constraint.toString().indexOf("Time:");

                String regionSubstring = constraint.toString().substring(regionIndex + "Region:".length(), timeIndex);
                String timeSubstring = constraint.toString().substring(timeIndex + "Time:".length());

                regionSubstring = regionSubstring.toLowerCase().trim();
                timeSubstring = timeSubstring.trim();

                Log.d("SplitRegionAndTime", "Region: " + regionSubstring);

                String[] parts = timeSubstring.split(":");

                String hour = parts[0].trim();
                String minutes = parts[1].trim();


                List<ParkingSpot> filteredList = new ArrayList<>();

                if (TextUtils.isEmpty(filterPattern)) {
                    filteredList.addAll(parkingSpots);
                } else {
                    for (ParkingSpot spot : parkingSpots) {
                        if (spot.getAddress().getRegion().toLowerCase().contains(regionSubstring) &&
                                spot.getTime().getHour() >= Integer.parseInt(hour)-1 &&
                                spot.getTime().getHour() <= Integer.parseInt(hour)+1 &&
                                spot.isAvailability()
                        ) {
                            filteredList.add(spot);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            /**
             * Εφαρμόζει το φίλτρο στο recycler
             * @param constraint ο περιορισμός για το φίλτρο
             * @param results οι φιλτραρισμένες θέσεις
             *
             */
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredParkingSpots.clear();
                filteredParkingSpots.addAll((List<ParkingSpot>) results.values);
                notifyDataSetChanged();
            }
        };
    }
}

