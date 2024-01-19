
public class SpotReservation {
    private int id;
    public static int uid = 0;
    private Time arrivalTime;
    private ParkingSpot parkingSpot;
    private SpotExchange spotExchange;

    public SpotReservation(Time arrivalTime, ParkingSpot parkingSpot,SpotExchange spotExchange) {
        this.id = uid;
        uid++;
        this.arrivalTime = arrivalTime;
        this.parkingSpot = parkingSpot;
        this.spotExchange= spotExchange;
    }

    public int getId() {
        return id;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public SpotExchange getSpotexchange() {
        return spotExchange;
    }

    public void setSpotExchange(SpotExchange spotExchange) {
        this.spotExchange = spotExchange;
    }

}