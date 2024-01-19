package gr.aueb.parkhub.domain;

/**
 * @author Χριστουλακης Ιωσηφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class ParkedUser extends User {
    
    private ParkingSpot parkingSpot;
    public ParkedUser(String name, String surname, String email, String password, String telephone, Vehicle vehicle) {
        super(name, surname, email, password,telephone,vehicle);
    }

    /**
     * Copy constructor
     * @param user ένας χρήστης
     */
    public ParkedUser(User user){
        super(user);
    }

    /**
     * Επιστρέφει την θέση που έχει δηλώσει ο χρήστης
     * @return η θέση που έχει δηλώσει ο χρήστης
     */
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    /**
     * Θέτει την θέση που έχει δηλώσει ο χρήστης
     * @param parkingspot η θέση που έχει δηλώσει ο χρήστης
     */
    public void setParkingSpot(ParkingSpot parkingspot) {
        this.parkingSpot = parkingspot;
    }

    /**
     * Δημιουργέι μία νέα δήλωση θέσης
     * @param time η ώρας της θέσης
     * @param address η διεύθυνση της θέσης
     */
    public void declareParkingSpot(Time time, Address address){
        this.parkingSpot=new ParkingSpot(time,address,this);
    }

}
