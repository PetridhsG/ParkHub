import org.junit.jupiter.api.*;

public class SpotReservationTest {

    @Test
    public void SpotReservationConstructorTest(){
        Time arrivaltime = new Time(23,45);
        Time time = new Time(23,40);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        ParkingSpot parkingSpot= new ParkingSpot(time,address,user);
        SpotExchange spotExchange = new SpotExchange();
        SpotReservation spotReservation= new SpotReservation(arrivaltime,parkingSpot,spotExchange);
        Assertions.assertTrue(spotReservation.getArrivalTime().equals(arrivaltime));
        Assertions.assertTrue(spotReservation.getParkingSpot().equals(parkingSpot));
        Assertions.assertTrue(spotReservation.getSpotexchange().equals(spotExchange));
        Assertions.assertEquals(spotReservation.uid-1,spotReservation.getId());
    }

    @Test
    public void SpotReservationSettersTest(){
        Time arrivaltime = new Time(23,45);
        Time time = new Time(23,40);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        ParkingSpot parkingSpot= new ParkingSpot(time,address,user);
        SpotExchange spotExchange = new SpotExchange();
        SpotReservation spotReservation= new SpotReservation(arrivaltime,parkingSpot,spotExchange);
        Time arrivaltime2 = new Time(12,23);
        Time time2 = new Time(12,24);
        Address address2 = new Address("Xaniwn",13,"Thessalonikh","Kamara");
        Vehicle vehicle2 = new Vehicle("green",4.5,"Mazda","B2500","KBK5432");
        User user2 = new User("Giwrgos","Gewrgiadhs","gxrisoupoli@gmail.com","1234567","6943545678",vehicle2);
        ParkingSpot parkingSpot2= new ParkingSpot(time2,address2,user2);
        SpotExchange spotExchange2 = new SpotExchange();
        spotReservation.setArrivalTime(arrivaltime2);
        spotReservation.setParkingSpot(parkingSpot2);
        spotReservation.setSpotExchange(spotExchange2);

    }
}