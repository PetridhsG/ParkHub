public class SearchingUser extends User {

    private SpotReservation spotReservation;

    public SearchingUser(String name, String surname, String email, String password, String telephone, Vehicle vehicle) {
        super(name, surname, email, password, telephone, vehicle);
    }

    public SpotReservation getSpotReservation() {
        return spotReservation;
    }

    public void setSpotReservation(SpotReservation spotReservation) {
        this.spotReservation = spotReservation;
    }

    public boolean reserveParkingSpot(boolean agreement,Time arrivalTime, ParkingSpot parkingSpot) {
        if (agreement){                                      // if the parked user agrees
            SpotExchange spotexchange = new SpotExchange();
            parkingSpot.setAvailability(false);
            this.spotReservation = new SpotReservation(arrivalTime, parkingSpot,spotexchange);
            return true;
        }
        return false;
    }

    public void declareFalseSpot(){
        this.spotReservation.getSpotexchange().setValidity(false);
        this.spotReservation.getSpotexchange().setSuccess(false);
    }

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
