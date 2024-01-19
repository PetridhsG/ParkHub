package gr.aueb.parkhub.views.spotDeclaration;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.dao.SpotsDAO;
import gr.aueb.parkhub.domain.Address;
import gr.aueb.parkhub.domain.ParkedUser;
import gr.aueb.parkhub.domain.User;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SpotDeclarationPresenter {

    private SpotDeclarationView view;
    private SpotsDAO spots;
    private AccountDAO accounts;
    private User attachedUser;


    /**
     * Αρχικοποιεί τον presenter έτσι ώστε
     * να προστεθεί καινούργια θέση
     * @param view Ένα instance του view
     * @param accounts Ένα instance του AccountDAO
     * @param spots Ένα instance του SpotsDAO
     */
    public SpotDeclarationPresenter(SpotDeclarationView view,AccountDAO accounts,SpotsDAO spots){
        this.accounts = accounts;
        this.spots = spots;
        this.view = view;

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
     * Αφού ελέγξει την εγκυρότητα των τιμών,
     * δημιουργεί μια νέα θέση και ενά καινούργιο
     * χρήστη instance του ParkedUser και τέλος
     * επιστρέφει στην αρχική οθόνη
     */
    public void onDeclare(){
        String street = view.getStreet();
        String stNumber = view.getStNumber();
        String city = view.getCity();
        String region = view.getRegion();

        if(!street.matches("^[^\\d]*$") || street.length() == 0 ){
            view.showErrorMessage("Please use only letters in the street text.");
        }
        else if(!stNumber.matches("^[^a-zA-Z]*$")|| stNumber.length() == 0){
            view.showErrorMessage("Please use only numbers in the street number text.");
        }
        else if(!city.matches("^[^\\d]*$")|| city.length() == 0){
            view.showErrorMessage("Please use only letters in the city text.");
        }
        else if(!region.matches("^[^\\d]*$") || region.length() == 0){
            view.showErrorMessage("Please use only letters in the region text.");
        }
        else{
            int previousID = this.attachedUser.getId();
            ParkedUser user = new ParkedUser(this.attachedUser);
            user.declareParkingSpot(view.getTime(),new Address(street,Integer.parseInt(stNumber),city,region));
            spots.save(user.getParkingSpot());
            accounts.save(user);
            if (accounts.authorized(previousID)){
                accounts.addAuthorizedID(user.getId());
            }
            view.declare(user.getId());
        }

    }

}
