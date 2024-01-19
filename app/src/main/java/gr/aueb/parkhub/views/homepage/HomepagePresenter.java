package gr.aueb.parkhub.views.homepage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.dao.SpotsDAO;
import gr.aueb.parkhub.domain.ParkedUser;
import gr.aueb.parkhub.domain.SearchingUser;
import gr.aueb.parkhub.domain.SpotReservation;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.ReservationDAOMemory;
import gr.aueb.parkhub.memorydao.SpotsDAOMemory;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class HomepagePresenter {

    private AccountDAO accounts ;
    private User attachedUser;
    private HomepageView view;

    /**
     * Αρχικοποιεί τον presenter
     * @param view Ένα instance του view
     * @param accounts Ένα instance του AccountDAO
     */
    public HomepagePresenter(HomepageView view, AccountDAO accounts){
        this.view = view;
        this.accounts = accounts;

        Integer attachedUserID = view.getAttachedUserID();
        attachedUser = attachedUserID == null ? null : accounts.find(attachedUserID);

        if (attachedUser !=null){

            view.setContent(attachedUser);

        }
    }

    /**
     * Η ροή μεταφέρεται στο ViewProfileActivity
     */
    public void onViewProfile(){
        view.viewProfile(attachedUser.getId());
    }

    /**
     * Η ροή μεταφέρεται στο PBucksRenewalActivity
     */
    public void onAddPBucks(){
        view.addPBucks(attachedUser.getId());
    }

    /**
     * Αν ο χρήστης έχει το δικαιώμα,η ροή μεταφέρεται στο
     * SpotDeclarationActivity αλλιώς
     * εμφανίζεται κατάλληλο μύνημα λάθους
     */
    public void onDeclareSpot() {
        if (attachedUser instanceof SearchingUser){
            view.showErrorMessage("Declaration Error","You can't declare a spot while you are having a spot reserved!");
        }
        else if (attachedUser instanceof ParkedUser){
            view.showErrorMessage("Declaration Error","You can't declare a spot while you are already have a spot declared!");
        }
        else{
            view.declareSpot(attachedUser.getId());
        }

    }

    /**
     * Αν ο χρήστης έχει το δικαιώμα,η ροή μεταφέρεται στο
     * SpotReservationActivity αλλιώς
     * εμφανίζεται κατάλληλο μύνημα λάθους
     */
    public void onReserveSpot() {
        if (attachedUser instanceof SearchingUser){
            view.showErrorMessage("Reservation Error","You can't reserve a spot while you are having a spot reserved!");
        }
        else if (attachedUser instanceof ParkedUser){
            view.showErrorMessage("Reservation Error","You can't reserve a spot while you are having a spot declared!");
        }
        else if (attachedUser.getPBucks() < 10){
            view.showErrorMessage("Reservation Error","You don't have enough PBucks to reserve a spot!");
        }
        else{
            view.reserveSpot(attachedUser.getId());
        }
    }

    /**
     * Αν ο χρήστης έχει το δικαιώμα,
     * πραγματοποιείται ανταλλαγή θέσης αλλιώς
     * εμφανίζεται κατάλληλο μύνημα λάθους
     */
    public void onExchangeSpot() {
        if (attachedUser instanceof SearchingUser){
            Random random = new Random();
            int searchingUserDelay = random.nextInt(20) + 1;
            int parkedUserDelay = random.nextInt(20) + 1;
            attachedUser.setDelay(searchingUserDelay);
            attachedUser.setAverageDelayTime((attachedUser.getAverageDelayTime() +  searchingUserDelay)/5);
            ((SearchingUser) attachedUser).getSpotReservation().getParkingSpot().
                    getUser().setAverageDelayTime( (((SearchingUser) attachedUser).getSpotReservation().getParkingSpot().
                            getUser().getAverageDelayTime() + parkedUserDelay)/5);
            if(searchingUserDelay > 10){
                view.showToastMessage("You were too late!Exchange cancelled...");
                ((SearchingUser) attachedUser).getSpotReservation().getSpotexchange().setMin(searchingUserDelay);
            }
            else if(parkedUserDelay > 10){
                view.showToastMessage("Your reservation was late!Exchange cancelled...");
                ((SearchingUser) attachedUser).getSpotReservation().getSpotexchange().setMin(parkedUserDelay);
            }
            else if(parkedUserDelay <=10 && searchingUserDelay <=10){
                view.showToastMessage("Exchange was successful!");
                ((SearchingUser) attachedUser).getSpotReservation().getSpotexchange().
                        setMin((int)((searchingUserDelay+searchingUserDelay)/2));
            }
            ((SearchingUser) attachedUser).exchange();
            new SpotsDAOMemory().delete(((SearchingUser) attachedUser).getSpotReservation().getParkingSpot());
            int previousID = this.attachedUser.getId();
            this.attachedUser = new User(this.attachedUser);

            if (accounts.authorized(previousID)){
                accounts.addAuthorizedID(this.attachedUser.getId());
            }

            accounts.save(this.attachedUser);
            view.exchangeSpot(attachedUser.getId());
        }
        else if (attachedUser instanceof ParkedUser){
            view.showErrorMessage("Exchange Error","You can't exchange a spot while you are having a declared one!");
        }
        else{
            view.showErrorMessage("Exchange Error","You can't exchange a spot while you are not having a spot reserved!");
        }
    }

    /**
     * Αν ο χρήστης έχει το δικαιώμα,η ροή μεταφέρεται στο
     * RatingActivity αλλιώς
     * εμφανίζεται κατάλληλο μύνημα λάθους
     */
    public void onReportFalseSpot() {
        if (attachedUser instanceof SearchingUser){
            view.reportFalseSpot(attachedUser.getId());
        }
        else if (attachedUser instanceof ParkedUser){
            view.showErrorMessage("Report Error","You can't report a false spot while you are having a declared one");
        }
        else{
            view.showErrorMessage("Report Error","You can't report a spot while you are not having a spot reserved!");
        }
    }

    /**
     * Αν ο χρήστης έχει το δικαιώμα,η ροή μεταφέρεται στο
     * StatisticsActivity αλλιώς
     * εμφανίζεται κατάλληλο μύνημα λάθους
     */
    public void onViewStatistics() {
        if(accounts.authorized(attachedUser.getId())){
            List<SpotReservation> reservations = new ReservationDAOMemory().findAll();
            double averageDelay = 0 ;
            double successfulExchange = 0 ;
            for(SpotReservation sr: reservations){
                averageDelay += sr.getSpotexchange().getMin();
                successfulExchange += sr.getSpotexchange().isSuccess() ? 1 : 0;
            }
            view.showErrorMessage("Statistics","Average Delay Time:" + averageDelay/reservations.size()
            + "\nSuccessful Reservations:" + successfulExchange/reservations.size());
            view.viewStatistics(attachedUser.getId());

        }
        else{
            view.showErrorMessage("Authorization Error","View statistics is only for authorized users!");
        }

    }



}
