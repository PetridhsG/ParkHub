package gr.aueb.parkhub.domain;

/**
 * @author Κεφαλάς Δημήτρης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class SearchingUser extends User {

    private SpotReservation spotReservation;

    public SearchingUser(String name, String surname, String email, String password, String telephone, Vehicle vehicle) {
        super(name, surname, email, password, telephone, vehicle);
    }

    /**
     * Copy constructor
     * @param user ένας χρήστης
     */
    public SearchingUser(User user){
        super(user);
    }

    /**
     * Επιστρέφει την κράτηση που έχει κάνει ο χρήστης
     * @return η κράτηση
     */
    public SpotReservation getSpotReservation() {
        return spotReservation;
    }

    /**
     * Θέτει την κράτηση που έχει κάνει ο χρήστης
     * @param spotReservation η κράτηση
     */
    public void setSpotReservation(SpotReservation spotReservation) {
        this.spotReservation = spotReservation;
    }

    /**
     * Πραγματοποιεί την διαδικάσια κράτησης θέσης
     * @param agreement αν αποδέχτηκε ο σταθμευμένος χρήστης
     * @param arrivalTime η ώρα άφιξης του χρήστη που αναζητά
     * @param parkingSpot η θέση προς κράτηση
     * @return την επιτυχία την κράτησης
     */
    public boolean reserveParkingSpot(boolean agreement, Time arrivalTime, ParkingSpot parkingSpot) {
        if (agreement){                                      // if the parked user agrees
            SpotExchange spotexchange = new SpotExchange();
            parkingSpot.setAvailability(false);
            this.spotReservation = new SpotReservation(arrivalTime, parkingSpot,spotexchange);
            return true;
        }
        return false;
    }

    /**
     * Καταχωρεί την ψευδή δήλωση θέσης
     */
    public void declareFalseSpot(){
        this.spotReservation.getSpotexchange().setValidity(false);
        this.spotReservation.getSpotexchange().setSuccess(false);
    }

    /**
     * Πραγματοποιεί την διαδικασία της ανταλλαγής
     * @return την επιτυχία της ανταλλαγής
     */
    public boolean exchange(){
        this.spotReservation.getSpotexchange().setValidity(true);
        if(this.spotReservation.getParkingSpot().getUser().getDelay()>10){
            this.spotReservation.getSpotexchange().setSuccess(false);
            return false;
        }else if(this.getDelay()>10){
            this.spotReservation.getSpotexchange().setSuccess(false);
            this.setPBucks(this.getPBucks()-10);
            this.spotReservation.getParkingSpot().getUser().setPBucks(spotReservation.getParkingSpot().getUser().getPBucks() +10);
            return false;
        }else{
            this.setPBucks(this.getPBucks()-10);
            this.spotReservation.getParkingSpot().getUser().setPBucks(spotReservation.getParkingSpot().getUser().getPBucks() +10);
            this.spotReservation.getSpotexchange().setSuccess(true);
            return true;
        }
    }
}
