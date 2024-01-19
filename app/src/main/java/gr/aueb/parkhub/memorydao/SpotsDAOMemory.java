package gr.aueb.parkhub.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.parkhub.dao.SpotsDAO;
import gr.aueb.parkhub.domain.ParkingSpot;

public class SpotsDAOMemory implements SpotsDAO {

    protected static ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();

    /**
     * Διαγράφει μια θέση
     * @param parkingSpot η θέση
     */
    @Override
    public void delete(ParkingSpot parkingSpot) {
        parkingSpots.remove(parkingSpot);
    }

    /**
     * Αποθηκεύει μια θέση
     * @param parkingSpot η θέση
     */
    @Override
    public void save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    /**
     * Επιστρέφει όλες τις θέσεις
     * @return λίστα με τις θέσεις
     */
    @Override
    public List<ParkingSpot> findAll() {
        ArrayList<ParkingSpot> result = new ArrayList<ParkingSpot>();
        result.addAll(parkingSpots);
        return result;
    }

    /**
     * Βρίσκει μία θέση με βάση του ID της
     * @param parkingSpotId το Id της θέσης
     * @return την θέση με συγκεκριμένο Id ή null
     */
    @Override
    public ParkingSpot find(int parkingSpotId) {
        for(ParkingSpot parkingSpot : parkingSpots)
            if(parkingSpot.getId() == parkingSpotId)
                return parkingSpot;

        return null;
    }
}
