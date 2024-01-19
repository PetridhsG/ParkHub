package gr.aueb.parkhub.views.viewProfile;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.domain.ParkedUser;
import gr.aueb.parkhub.domain.SearchingUser;
import gr.aueb.parkhub.domain.User;

/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class ViewProfilePresenter {

    private AccountDAO accountDAO;

    private User attachedUser;

    private ViewProfileView view;

    /**
     * Αρχικοποιεί τον presenter
     * ώστε να εμφανιστούν τα στοιχεία του χρήστη
     * @param view Ένα instance του view
     * @param accountDAO Ένα instance του AccountDAO
     */
    public ViewProfilePresenter(ViewProfileView view,AccountDAO accountDAO) {
        this.view=view;
        this.accountDAO = accountDAO;

        Integer attachedUserID = view.getAttachedUserID();
        if (attachedUserID == null) {
            attachedUser = null;
        } else {
            attachedUser = accountDAO.find(attachedUserID);
        }

        if (attachedUser !=null){
            view.setContent(attachedUser);
        }

    }

    /**
     * Επιστρέφει στην αρχική οθόνη
     */
    public void onHomePage(){
        view.homePage(attachedUser.getId());}

    /**
     * Η ροή μεταφέρεται στο EditProfileActivity
     * αν δεν έχει κάνει κάποια κράτηση ταυτόχρονα
     */
    public void onEditProfile() {
        if (attachedUser instanceof SearchingUser || attachedUser instanceof ParkedUser) {
            view.showErrorMessage("You can't edit your profile while you are having a spot" +
                    "reserved or declared!");
        } else {
            view.editProfile(attachedUser.getId());
        }
    }

}
