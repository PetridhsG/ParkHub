package gr.aueb.parkhub.domaintest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import gr.aueb.parkhub.domain.Address;
import gr.aueb.parkhub.domain.ParkedUser;
import gr.aueb.parkhub.domain.ParkingSpot;
import gr.aueb.parkhub.domain.Time;
import gr.aueb.parkhub.domain.Vehicle;

public class ParkedUserTest {


    @Test
    public void ParkedUserConstructorTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser user = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        assertEquals(100,user.getPBucks());
        assertEquals("Alexis",user.getName());
        assertEquals("Kefalas",user.getSurname());
        assertEquals("qwerty12",user.getPassword());
        assertEquals("akefalas@gmail.com",user.getEmail());
        assertEquals("6975431238",user.getTelephone());
        assertEquals(user.getUid()-1,user.getId());
        assertEquals(vehicle, user.getVehicle());
    }

    @Test
    public void ParkedUserSettersTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser user = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        ParkingSpot parkingSpot = new ParkingSpot(new Time(14,40),new Address("Pathsiwn",76,"Athens","Kypseli"),user);
        user.setParkingSpot(parkingSpot);
        assertEquals(parkingSpot, user.getParkingSpot());
    }

    @Test
    public void ParkedUserDeclareParkingSpotTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser user = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Time time = new Time(11,40);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        ParkingSpot parkingSpot = new ParkingSpot(time,address,user);
        user.declareParkingSpot(time,address);
        assertEquals(parkingSpot, user.getParkingSpot());
    }

}
