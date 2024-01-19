public class ParkedUser extends User{
    
    private ParkingSpot parkingSpot;
    public ParkedUser(String name, String surname, String email, String password, String telephone,Vehicle vehicle) {
        super(name, surname, email, password,telephone,vehicle);
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingspot) {
        this.parkingSpot = parkingspot;
    }

    public void declareParkingSpot(Time time, Address address){
        this.parkingSpot=new ParkingSpot(time,address,this);
    }

}
