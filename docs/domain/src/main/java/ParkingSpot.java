import java.util.Objects ;

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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId(){
        return this.id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingSpot that)) return false;
        return Objects.equals(time, that.time) && Objects.equals(address, that.address) && Objects.equals(user, that.user);
    }


}