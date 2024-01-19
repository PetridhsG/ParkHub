package gr.aueb.parkhub.views.spotReservation;

import gr.aueb.parkhub.domain.Time;
import gr.aueb.parkhub.domain.User;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public interface SpotReservationView {

    /**
     * Επιστρέφει στην αρχική σελίδα
     * @param userID Το userID του συνδεδεμένου χρήστη
     */
    void back(Integer userID);

    /**
     * Εφαρμόζει φίλτρο στην αναζήτηση
     * @param constraint ο περιορισμός για το φίλτρο
     */
    void apply(String constraint);

    /**
     * Επιβεβαιώνει την κράτηση μίας θέσης
     * @param userID το Id του συγκεκριμένου χρήστη
     */
    void confirm(Integer userID);

    /**
     * Θέτει το περιεχόμενο για τον συνδεδεμένο χρήστη
     * @param user ο συνδεδεμένος χρήστης
     */
    void setContent(User user);

    /**
     * Επιστρέφει την ώρα άφιξης του χρήστη
     * @return η ώρα άφιξης του χρήστη
     */
    Time getTime();

    /**
     * Θέτει την ώρα άφιξης του χρήστη
     * @param time η ώρα άφιξης του χρήστη
     */
    void setTime(Time time);

    /**
     * Επιστρέφει την περιοχή αναζήτησης
     * @return η περιοχή αναζήτησης
     */
    String getRegion();

    /**
     * Θέτει την περιοχή αναζήτησης
     * @param region η περιοχή αναζήτησης
     */
    void setRegion(String region);

    /**
     * Θέτει το ID για την συγκεκριμένη θέση
     * @param parkingSpotID το ID της θέσης
     */
    void setParkingSpotID(Integer parkingSpotID);

    /**
     * Επιστρέφει το ID της συγκεκριμένης θέσης
     * @return το ID της θέσης
     */
    Integer getParkingSpotID();


    /**
     * Επιστρέφει το Id του συνδεδεμένου χρήστη
     * @return το Id του συγκεκριμένου χρήστη
     */
    Integer getAttachedUserID() ;

    /**
     * Εμφανίζει μύνημα στο χρήστη
     * @param title ο τίτλος του μυνήματος
     * @param message το περιεχόμενο του μυνήματος
     */
    void showMessage(String title,String message);

    /**
     * Εμφανίζει μύνημα στο χρήστη
     * @param toastMessage το περιεχόμενο του μυνήματος
     */
    void showToast(String toastMessage);

}
