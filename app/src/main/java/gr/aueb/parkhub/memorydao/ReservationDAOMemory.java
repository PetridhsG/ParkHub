package gr.aueb.parkhub.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.parkhub.dao.ReservationsDAO;
import gr.aueb.parkhub.domain.SpotReservation;

public class ReservationDAOMemory implements ReservationsDAO {

    protected static ArrayList<SpotReservation> spotReservations = new ArrayList<SpotReservation>();

    /**
     * Διαγράφει μια κράτηση
     * @param spotReservation η κράτηση
     */
    @Override
    public void delete(SpotReservation spotReservation) {
        spotReservations.remove(spotReservation);
    }

    /**
     * Αποθηκέυει μια κράτηση
     * @param spotReservation  η κράτηση
     */
    @Override
    public void save(SpotReservation spotReservation) {
        spotReservations.add(spotReservation);
    }

    /**
     * Επιστρέφει όλες τις κρατήσεις
     * @return λίστα με τις κρατήσεις
     */
    @Override
    public List<SpotReservation> findAll() {
        ArrayList<SpotReservation> result = new ArrayList<SpotReservation>();
        result.addAll(spotReservations);
        return result;
    }

    /**
     * Βρίσκει μια κράτηση με βάση του Id της
     * @param spotReservationId το Id της κράτησης
     * @return την κράτηση με το συγκεκριμένο Id ή null
     */
    @Override
    public SpotReservation find(int spotReservationId) {
        for(SpotReservation spotReservation : spotReservations)
            if(spotReservation.getId() == spotReservationId)
                return spotReservation;

        return null;
    }
}
