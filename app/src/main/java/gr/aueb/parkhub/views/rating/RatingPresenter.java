package gr.aueb.parkhub.views.rating;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.dao.SpotsDAO;
import gr.aueb.parkhub.domain.Rating;
import gr.aueb.parkhub.domain.SearchingUser;
import gr.aueb.parkhub.domain.SpotReservation;
import gr.aueb.parkhub.domain.User;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class RatingPresenter {

    private AccountDAO accounts;
    private SpotsDAO spots;
    private User attachedUser;
    private RatingView view;

    /**
     * Αρχικοποιεί τον presenter
     * @param view Ένα instance του view
     * @param accounts Ένα instance του AccountDAO
     * @param spots Ένα instance του SpotsDAO
     */
    public RatingPresenter(RatingView view,AccountDAO accounts,SpotsDAO spots){
        this.view = view;
        this.accounts = accounts;
        this.spots = spots;

        Integer attachedUserID = view.getAttachedUserID();
        this.attachedUser = attachedUserID == null ? null : accounts.find(attachedUserID);

        if (attachedUser !=null){
            view.setContent(attachedUser);
        }
    }

    /**
     * Επιστρέφει στην αρχική οθόνη
     * θέτοντας την ανταλλαγή ως ανεπιτυχή
     * και απελευθερόνοντας την θέση
     */
    public void onBack(){
        SpotReservation sr = ((SearchingUser) this.attachedUser).getSpotReservation();
        sr.getSpotexchange().setValidity(false);
        sr.getSpotexchange().setSuccess(false);
        spots.delete(sr.getParkingSpot());
        int previousID = this.attachedUser.getId();
        User user = new User(this.attachedUser);
        accounts.save(user);
        if (accounts.authorized(previousID)){
            accounts.addAuthorizedID(user.getId());
        }
        view.back(user.getId());
    }

    /**
     * Καταχωρεί την αξιολόγηση στο σύστημα και
     * επιστρέφει στην αρχική οθόνη
     * θέτοντας την ανταλλαγή ως ανεπιτυχή
     * και απελευθερόνοντας την θέση
     */
    public void onSubmit(){
        double rating = view.getRating();
        String comments = view.getComments();
        Rating rat = new Rating(rating,comments);
        User user =((SearchingUser) this.attachedUser).getSpotReservation().getParkingSpot().getUser();
        user.addRating(rat);
        view.showToastMessage("Rating submited!");
        SpotReservation sr = ((SearchingUser) this.attachedUser).getSpotReservation();
        ((SearchingUser) this.attachedUser).declareFalseSpot();
        spots.delete(sr.getParkingSpot());
        int previousID = this.attachedUser.getId();
        user = new User(this.attachedUser);
        accounts.save(user);
        if (accounts.authorized(previousID)){
            accounts.addAuthorizedID(user.getId());
        }

        view.submit(user.getId());
    }
}
