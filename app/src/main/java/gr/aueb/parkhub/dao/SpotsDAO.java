package gr.aueb.parkhub.dao;

import java.util.List;

import gr.aueb.parkhub.domain.ParkingSpot;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public interface SpotsDAO {

    /**
     * Διαγράφει μια θέση
     * @param parkingSpot η θέση
     */
    void delete(ParkingSpot parkingSpot);

    /**
     * Αποθηκεύει μια θέση
     * @param parkingSpot η θέση
     */
    void save(ParkingSpot parkingSpot);

    /**
     * Επιστρέφει όλες τις θέσεις
     * @return λίστα με τις θέσεις
     */
    List<ParkingSpot > findAll();


    /**
     * Βρίσκει μία θέση με βάση του ID της
     * @param parkingSpotId το Id της θέσης
     * @return την θέση με συγκεκριμένο Id
     */
    ParkingSpot find(int parkingSpotId);
}
