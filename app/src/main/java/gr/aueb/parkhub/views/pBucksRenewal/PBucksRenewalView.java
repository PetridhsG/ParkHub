package gr.aueb.parkhub.views.pBucksRenewal;

import gr.aueb.parkhub.domain.User;

public interface PBucksRenewalView {

    /**
     * Η ροή μεταφέρεται στο HomepageActivity
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void homePage(Integer userID);

    /**
     * Η ροή μεταφέρεται στο HomePageActivity
     * και ενημερώνει τον χρήστη πως προστέθηκαν
     * 10 P-Bucks στον λογαριασμό του επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void pack10(Integer userID);

    /**
     * Η ροή μεταφέρεται στο HomePageActivity
     * και ενημερώνει τον χρήστη πως προστέθηκαν
     * 20 P-Bucks στον λογαριασμό του επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void pack20(Integer userID);

    /**
     * Η ροή μεταφέρεται στο HomePageActivity
     * και ενημερώνει τον χρήστη πως προστέθηκαν
     * 50 P-Bucks στον λογαριασμό του επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void pack50(Integer userID);

    /**
     * Η ροή μεταφέρεται στο HomePageActivity
     * και ενημερώνει τον χρήστη πως προστέθηκαν
     * 100 P-Bucks στον λογαριασμό του επιτυχώς
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void pack100(Integer userID);

    /**
     * Επιστρέφει το Id του συνδεδεμένου χρήστη
     * @return το Id του συγκεκριμένου χρήστη
     */
    Integer getAttachedUserID();

    /**
     * Θέτει τον αριθμό των P-Bucks που θα εμφανιστούν
     * για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    void setContent(User user);


}
