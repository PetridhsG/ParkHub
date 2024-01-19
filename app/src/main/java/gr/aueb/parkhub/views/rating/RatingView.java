package gr.aueb.parkhub.views.rating;

import gr.aueb.parkhub.domain.User;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public interface RatingView {

    /**
     * Επιστρέφει στην αρχική οθόνη
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void back(Integer userID);

    /**
     * Καταχωρεί την αξιολόγηση στο σύστημα
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void submit(Integer userID);

    /**
     * Θέτει το περιεχόμενο για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    void setContent(User user);

    /**
     * Επιστρέφει το Id του συνδεδεμένου χρήστη
     * @return το Id του συγκεκριμένου χρήστη
     */
    Integer getAttachedUserID() ;

    /**
     * Θέτει τα σχόλια για την αξιολόγηση
     * @param comments τα σχόλια
     */
    void setComments(String comments);

    /**
     * Θέτει την βαθμολογία της αξιολόγησης
     * @param rating η βαθμολογία
     */
    void setRating(double rating);

    /**
     * Επιστρέφει τα σχόλια της αξιολόγησης
     * @return τα σχόλια
     */
    String getComments();

    /**
     * Επιστρέφει την βαθμολογία της αξιολόγησης
     * @return η βαθμολογία
     */
    double getRating();

    /**
     * Tο Toast μύνημα που εμφανίζεται
     * @param message το περιεχόμενο του μυνήματος
     */
    void showToastMessage(String message);


}
