package gr.aueb.parkhub.domain;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class SpotReservation {
    private int id;
    public static int uid = 0;
    private Time arrivalTime;
    private ParkingSpot parkingSpot;
    private SpotExchange spotExchange;

    public SpotReservation(Time arrivalTime, ParkingSpot parkingSpot, SpotExchange spotExchange) {
        this.id = uid;
        uid++;
        this.arrivalTime = arrivalTime;
        this.parkingSpot = parkingSpot;
        this.spotExchange= spotExchange;
    }

    /**
     * Επιστρέφει το ID της κράτησης
     * @return το ID
     */
    public int getId() {
        return id;
    }

    /**
     * Επιστρέφει το χρόνο άφιξης
     * @return ο χρόνος άφιξης
     */
    public Time getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Θέτει το χρόνο άφιξης
     * @param arrivalTime ο χρόνος άφιξης
     */
    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Επιστρέφει την κρατημένη θέση
     * @return η θέση
     */
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    /**
     * Θέτει την κρατημένη θέση
     * @param parkingSpot  η θέση
     */
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    /**
     * Επιστρέφει την ανταλλαγή της θέσης
     * @return η ανταλλαγή της θέσης
     */
    public SpotExchange getSpotexchange() {
        return spotExchange;
    }

    /**
     * Θέτει την ανταλλαγή της θέσης
     * @param spotExchange η ανταλλαγή
     */
    public void setSpotExchange(SpotExchange spotExchange) {
        this.spotExchange = spotExchange;
    }

}