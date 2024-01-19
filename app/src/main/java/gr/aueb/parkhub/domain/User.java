package gr.aueb.parkhub.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class User{
    protected static int uid=0;
    protected int id;
    protected String name;
    protected String surname;
    protected String email;
    protected String password;
    protected String telephone;
    protected int PBucks;
    protected double averageDelayTime;
    protected double rating;
    protected ArrayList<Rating> ratings;
    protected Vehicle vehicle;
    protected int delay;

    public User(String name, String surname, String email, String password, String telephone, Vehicle vehicle) {
        this.id=uid;
        uid++;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.PBucks= 100;
        this.vehicle=vehicle;
        this.averageDelayTime = 0 ;
        this.rating = 0 ;
        this.ratings = new ArrayList<>();
    }

    /**
     * Copy constructor
     * @param other ένας χρήστης
     */
    public User(User other) {
        this.id=uid;
        uid++;
        this.name = other.name;
        this.surname = other.surname;
        this.email = other.email;
        this.password = other.password;
        this.telephone = other.telephone;
        this.PBucks = other.PBucks;
        this.averageDelayTime = other.averageDelayTime;
        this.rating = other.rating;
        this.ratings = new ArrayList<>(other.ratings);
        this.vehicle = new Vehicle(other.vehicle);
        this.delay = other.delay;
    }

    /**
     * Επιστρέφει την καθυστέρηση του χρήστη
     * @return η καθυστέρηση
     */
    public int getDelay() {
        return delay;
    }

    /**
     * Θέτει την καθυστέρηση του χρήστη
     * @param delay η καθυστέρηση
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * Επιστρέφει το UID της κλάσης
     * @return το UID
     */
    public int getUid(){
        return uid;
    }

    /**
     * Επιστρέφει το ID του χρήστη
     * @return το ID
     */
    public int getId() {
        return id;
    }

    /**
     * Επιστρέφει το όνομα του χρήστη
     * @return το όνομα
     */
    public String getName() {
        return name;
    }

    /**
     * Θέτει το όνομα του χρήστη
     * @param name το όνομα
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Επιστρέφει το επίθετο του χρήστη
     * @return το επίθετο
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Θέτει το επίθετο του χρήστη
     * @param surname το επίθετο
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Επιστρέφει το email του χρήστη
     * @return το email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Θέτει το email του χρήστη
     * @param email το email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Επιστρέφει τον κωδικό του χρήστη
     * @return ο κωδικός
     */
    public String getPassword() {
        return password;
    }

    /**
     * Θέτει τον κωδικό του χρήστη
     * @param password ο κωδικός
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Επιστρέφει το τηλέφωνο του χρήστη
     * @return το τηλέφωνο
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Θέτει το τηλέφωνο του χρήστη
     * @param telephone το τηλέφωνο
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Επιστρέφει τα PBucks του χρήστη
     * @return τα PBucks
     */
    public int getPBucks() {
        return PBucks;
    }

    /**
     * Θέτει τα PBucks του χρήστη
     * @param PBucks τα PBucks
     */
    public void setPBucks(int PBucks) {
        this.PBucks = PBucks;
    }

    /**
     * Προσθέτει αξιολόγηση στον χρήστη
     * @param rating η αξιολόγηση
     */
    public void addRating(Rating rating){
        this.ratings.add(rating);
        int s = 0;
        for(Rating rat: ratings){
            s += rat.getRating();
        }
        this.rating = s/ratings.size();
    }

    /**
     * Επιστρέφει τις αξιολογήσεις του χρήστη
     * @return οι αξιολογήσεις
     */
    public ArrayList<Rating> getRatings() {
        return this.ratings;
    }

    /**
     * Θέτει τις αξιολογήσεις του χρήστη
     * @param ratings οι αξιολογήσεις
     */
    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    /**
     * Επιστρέφει τo όχημα του χρήστη
     * @return το όχημα
     */
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    /**
     * Θέτει τo όχημα του χρήστη
     * @param vehicle το όχημα
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Επιστρέφει τo μέσο χρόνο καθυστέρησης του χρήστη
     * @return ο μέσος χρόνος καθυστέρησης
     */
    public double getAverageDelayTime() {
        return this.averageDelayTime;
    }

    /**
     * Θέτει τo μέσο χρόνο καθυστέρησης του χρήστη
     * @param averageDelayTime ο μέσος χρόνος καθυστέρησης
     */
    public void setAverageDelayTime(double averageDelayTime) {
        this.averageDelayTime = averageDelayTime;
    }

    /**
     * Επιστρέφει την αξιολόγηση του χρήστη
     * @return η αξιολόγηση
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * Θέτει την αξιολόγηση του χρήστη
     * @param rating η αξιολόγηση
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Προσθέτει PBucks στον χρήστη
     * @param choice το πακέτο που επέλεξε
     */
    public void PBucksRenewal(int choice){
        switch(choice){
            case 1:
                this.PBucks += 10;
                break;
            case 2:
                this.PBucks += 30;
                break;
            case 3:
                this.PBucks += 100;
                break;
        }
    }

    /**
     * Ελέγχει την ισότητα δύο αντικειμένων τύπου user
     * @param o ένα αντικείμενο τύπου user
     * @return αν είναι ίσα τα αντικείμενα
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o ;
        return Objects.equals(email, user.email);
    }
}