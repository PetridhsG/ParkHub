package gr.aueb.parkhub.views.pBucksRenewal;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.domain.User;

/**
 * @author Χριστουλακης Ιωσηφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class PBucksRenewalPresenter {

    private PBucksRenewalView view;
    private AccountDAO accounts;
    private User attachedUser;

    /**
     * Αρχικοποιεί τον presenter
     * ώστε ο χρήστης να προσθέσει P-Bucks στον λογαριασμό του
     * @param view Ένα instance του view
     * @param accountDAO Ένα instance του AccountDAO
     */
    public PBucksRenewalPresenter(PBucksRenewalView view, AccountDAO accountDAO){
        this.view=view;
        this.accounts=accountDAO;
        Integer attachedUserID = view.getAttachedUserID();
        if (attachedUserID == null) {
            attachedUser = null;
        } else {
            attachedUser = accounts.find(attachedUserID);
        }

        if (attachedUser !=null){
            view.setContent(attachedUser);
        }
    }

    /**
     * Επιστρέφει στην αρχική οθόνη
     */
    public void onBack(){
        view.homePage(attachedUser.getId());
    }

    /**
     * Προσθέτει 10 P-Bucks στον λογαριασμό και
     * επιστρέφει στην αρχική οθόνη
     */
    public void onPack10(){
        this.attachedUser.setPBucks(this.attachedUser.getPBucks()+10);
        view.pack10(attachedUser.getId());}

    /**
     * Προσθέτει 20 P-Bucks στον λογαριασμό και
     * επιστρέφει στην αρχική οθόνη
     */
    public void onPack20(){
        this.attachedUser.setPBucks(this.attachedUser.getPBucks()+20);
        view.pack20(attachedUser.getId());}

    /**
     * Προσθέτει 50 P-Bucks στον λογαριασμό και
     * επιστρέφει στην αρχική οθόνη
     */
    public void onPack50(){
        this.attachedUser.setPBucks(this.attachedUser.getPBucks()+50);
        view.pack50(attachedUser.getId());}

    /**
     * Προσθέτει 100 P-Bucks στον λογαριασμό και
     * επιστρέφει στην αρχική οθόνη
     */
    public void onPack100(){
        this.attachedUser.setPBucks(this.attachedUser.getPBucks()+100);
        view.pack100(attachedUser.getId());
    }

}
