package gr.aueb.parkhub.domain;

import java.util.Objects;

/**
 * @author Χριστουλακης Ιωσηφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class ParkingSpot {
    public static int uid = 0;
    private int id;
    private Time time;
    private boolean availability;
    private Address address;
    private User user;

    public ParkingSpot(Time time, Address address, User user){
        this.id = uid;
        uid++;
        this.time = time;
        this.availability = true;
        this.address = address;
        this.user=user;

    }

    /**
     * Επιστρέφει τον χρήστη που έχει δηλώσει
     * την συγκεκριμένη θέση
     * @return ο χρήστης
     */
    public User getUser() {
        return user;
    }

    /**
     * Θέτει τον χρήστη που έχει δηλώσει
     * την συγκεκριμένη θέση
     * @param user ο χρήστης
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Επιστρέφει το ID της θέσης
     * @return το ID
     */
    public int getId(){
        return this.id;
    }

    /**
     * Επιστρέφει την ώρα της θέσης
     * @return η ώρα της θέσης
     */
    public Time getTime() {
        return time;
    }

    /**
     * Θέτει την ώρα της θέσης
     * @param time η ώρα της θέσης
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Επιστρέφει την διαθεσιμότητα της θέσης
     * @return την διαθεσιμότητα
     */
    public boolean isAvailability() {
        return availability;
    }

    /**
     * Θέτει την διαθεσιμόητα της θέσης
     * @param availability η διαθεσιμότητα
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * Επιστρέφει την διεύθυνση της θέσης
     * @return η διεύθυνση
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Θέτει την διεύθυνση της θέσης
     * @param address η διεύθυνση
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Ελέγχει την ισότητα δύο αντικειμένων τύπου ParkingSpot
     * @param o ένα αντικείμενο τύπου address
     * @return αν είναι ίσα τα αντικείμενα
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return Objects.equals(time, that.time) && Objects.equals(address, that.address) && Objects.equals(user, that.user);
    }

}