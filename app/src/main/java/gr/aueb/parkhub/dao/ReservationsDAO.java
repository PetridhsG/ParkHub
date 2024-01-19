package gr.aueb.parkhub.dao;

import java.util.List;

import gr.aueb.parkhub.domain.SpotReservation;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public interface ReservationsDAO {

    /**
     * Διαγράφει μια κράτηση
     * @param spotReservation η κράτηση
     */
    void delete(SpotReservation spotReservation);

    /**
     * Αποθηκέυει μια κράτηση
     * @param spotReservation  η κράτηση
     */
    void save(SpotReservation spotReservation);

    /**
     * Επιστρέφει όλες τις κρατήσεις
     * @return λίστα με τις κρατήσεις
     */
    List<SpotReservation> findAll();

    /**
     * Βρίσκει μια κράτηση με βάση του Id της
     * @param spotReservationId το Id της κράτησης
     * @return την κράτηση με το συγκεκριμένο Id
     */
    SpotReservation find(int spotReservationId);
}
