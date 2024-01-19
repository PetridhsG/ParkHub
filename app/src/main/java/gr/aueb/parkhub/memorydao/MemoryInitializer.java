package gr.aueb.parkhub.memorydao;

import gr.aueb.parkhub.dao.*;
import gr.aueb.parkhub.domain.*;

public class MemoryInitializer extends Initializer {

    /**
     * Διαγράφει τα αποθηκευμένα δεδομένα.
     */
    @Override
    protected void eraseData() {

        for(User user : getAccountDAO().findAll()) {
            getAccountDAO().delete(user);
        }

        for(ParkingSpot parkingSpot : getSpotsDAO().findAll()) {
            getSpotsDAO().delete(parkingSpot);
        }

        for(SpotReservation spotReservation : getReservationsDAO().findAll()) {
            getReservationsDAO().delete(spotReservation);
        }

    }

    /**
     * Επιστρέφει το DAO των χρηστών
     * @return Το DAO των χρηστών
     */
    @Override
    public AccountDAO getAccountDAO() {
        return new AccountDAOMemory() ;
    }

    /**
     * Επιστρέφει το DAO των κρατήσεων
     * @return Το DAO των κρατήσεων
     */
    @Override
    public ReservationsDAO getReservationsDAO() {
        return new ReservationDAOMemory() ;
    }

    /**
     * Επιστρέφει το DAO των θέσεων
     * @return Το DAO των θέσεων
     */
    @Override
    public SpotsDAO getSpotsDAO() {
        return new SpotsDAOMemory() ;
    }
}
