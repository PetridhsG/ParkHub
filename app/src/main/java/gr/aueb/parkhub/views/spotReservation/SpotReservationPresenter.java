package gr.aueb.parkhub.views.spotReservation;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.dao.ReservationsDAO;
import gr.aueb.parkhub.dao.SpotsDAO;
import gr.aueb.parkhub.domain.ParkingSpot;
import gr.aueb.parkhub.domain.SearchingUser;
import gr.aueb.parkhub.domain.User;
import java.util.Random;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SpotReservationPresenter {

    private SpotReservationView view;
    private ReservationsDAO reservations;
    private AccountDAO accounts;
    private SpotsDAO spots;
    private User attachedUser;

    /**
     * Αρχικοποιεί τον presenter έτσι ώστε
     * να πραγματοποιείται η κράτηση μίας θέσης
     * @param view Ένα instance του view
     * @param accounts Ένα instance του AccountDAO
     * @param spots Ένα instance του SpotsDAO
     * @param reservations Ένα instance του ReservationsDAO
     */
    public SpotReservationPresenter(SpotReservationView view, AccountDAO accounts,SpotsDAO spots,ReservationsDAO reservations){
        this.view = view;
        this.accounts = accounts;
        this.spots = spots;
        this.reservations = reservations;

        Integer attachedUserID = view.getAttachedUserID();
        this.attachedUser = attachedUserID == null ? null : accounts.find(attachedUserID);

        if (attachedUser !=null){
            view.setContent(attachedUser);
        }
    }

    /**
     * Επιστρέφει στην αρχική οθόνη
     */
    public void onBack(){
        view.back(this.attachedUser.getId());
    }

    /**
     * Εφαρμόζει φίλτρο στις θέσεις
     */
    public void onApply(){
        String constraint = "Region:" + view.getRegion() + "Time:" + view.getTime() ;
        view.apply(constraint);
    }

    /**
     * Επιβεβαιώνει την κράτηση μίας θέσης
     */
    public void onConfirm(){
        Integer parkingSpotID = view.getParkingSpotID();
        ParkingSpot parkingSpot = parkingSpotID == null ? null : spots.find(parkingSpotID);

        if(parkingSpot !=null){
            try {
                view.showToast("Waiting for other user response...");
                Thread.sleep(3000);
                Random random = new Random();
                int randomNumber = random.nextInt(2);
                if(randomNumber == 0){
                    view.showMessage("Reservation Rejected",
                            "The other user rejected your request.");
                }
                else{
                    int previousID = this.attachedUser.getId();
                    SearchingUser user = new SearchingUser(this.attachedUser);
                    user.reserveParkingSpot(true,view.getTime(),parkingSpot);
                    reservations.save(user.getSpotReservation());
                    accounts.save(user);
                    if (accounts.authorized(previousID)){
                        accounts.addAuthorizedID(user.getId());
                    }
                    view.showToast("Your resevation was successfull!");
                    view.confirm(user.getId());
                }
            } catch (InterruptedException e) {

            }

        }
        else{
            view.showMessage("Reservation Error",
                    "You don't have a spot selected.");
        }

    }
}
