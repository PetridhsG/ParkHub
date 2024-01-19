import java.util.ArrayList;
import java.util.Objects;

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
    }


    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getUid(){
        return uid;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getPBucks() {
        return PBucks;
    }

    public void setPBucks(int PBucks) {
        this.PBucks = PBucks;
    }
    
    public ArrayList<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getAverageDelayTime() {
        return this.averageDelayTime;
    }

    public void setAverageDelayTime(double averageDelayTime) {
        this.averageDelayTime = averageDelayTime;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(email, user.email);
    }
}