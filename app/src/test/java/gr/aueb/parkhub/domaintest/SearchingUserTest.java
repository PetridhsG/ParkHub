package gr.aueb.parkhub.domaintest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import gr.aueb.parkhub.domain.*;

public class SearchingUserTest {

    @Test
    public void SearchingUserConstructorTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
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
    public void SearchingUserSettersTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser parkedUser = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Vehicle vehicle1 = new Vehicle("green",4.5,"Mazda","B2500","KBK5432");
        SearchingUser searchingUser = new SearchingUser("Giwrgos","Gewrgiadhs","gxrisoupoli@gmail.com","1234567","6943545678",vehicle1);
        Time arrivalTime = new Time(11,45);
        Time spotTime = new Time(11,40);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        ParkingSpot parkingSpot = new ParkingSpot(spotTime,address,parkedUser);
        SpotExchange spotExchange = new SpotExchange();
        SpotReservation spotReservation = new SpotReservation(arrivalTime,parkingSpot,spotExchange);
        searchingUser.setSpotReservation(spotReservation);
        assertEquals(spotReservation, searchingUser.getSpotReservation());
    }

    @Test
    public void SearchingUserReserveParkingSpotTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser parkedUser = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Vehicle vehicle1 = new Vehicle("green",4.5,"Mazda","B2500","KBK5432");
        SearchingUser searchingUser = new SearchingUser("Giwrgos","Gewrgiadhs","gxrisoupoli@gmail.com","1234567","6943545678",vehicle1);
        Time arrivalTime = new Time(11,45);
        Time spotTime = new Time(11,40);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        ParkingSpot parkingSpot = new ParkingSpot(spotTime,address,parkedUser);
        assertFalse(searchingUser.reserveParkingSpot(false,arrivalTime,parkingSpot));
        assertTrue(searchingUser.reserveParkingSpot(true,arrivalTime,parkingSpot));
    }

    @Test
    public void SearchingUserDeclareFalseSpotTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser parkedUser = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Vehicle vehicle1 = new Vehicle("green",4.5,"Mazda","B2500","KBK5432");
        SearchingUser searchingUser = new SearchingUser("Giwrgos","Gewrgiadhs","gxrisoupoli@gmail.com","1234567","6943545678",vehicle1);
        Time arrivalTime = new Time(11,45);
        Time spotTime = new Time(11,40);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        ParkingSpot parkingSpot = new ParkingSpot(spotTime,address,parkedUser);
        searchingUser.reserveParkingSpot(true,arrivalTime,parkingSpot);
        searchingUser.declareFalseSpot();
        assertFalse(searchingUser.getSpotReservation().getSpotexchange().isValidity());
        assertFalse(searchingUser.getSpotReservation().getSpotexchange().isSuccess());

    }

    @Test
    public void SearchingUserExchangeTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser parkedUser = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Vehicle vehicle1 = new Vehicle("green",4.5,"Mazda","B2500","KBK5432");
        SearchingUser searchingUser = new SearchingUser("Giwrgos","Gewrgiadhs","gxrisoupoli@gmail.com","1234567","6943545678",vehicle1);
        Time arrivalTime = new Time(11,45);
        Time spotTime = new Time(11,40);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        ParkingSpot parkingSpot = new ParkingSpot(spotTime,address,parkedUser);
        searchingUser.reserveParkingSpot(true,arrivalTime,parkingSpot);
        parkedUser.setDelay(15);
        assertFalse(searchingUser.exchange());
        assertFalse(searchingUser.getSpotReservation().getSpotexchange().isSuccess());
        parkedUser.setDelay(5);
        searchingUser.setDelay(15);
        parkedUser.setPBucks(20);
        searchingUser.setPBucks(30);
        assertFalse(searchingUser.exchange());
        assertFalse(searchingUser.getSpotReservation().getSpotexchange().isSuccess());
        assertEquals(20,searchingUser.getPBucks());
        assertEquals(30,parkedUser.getPBucks());
        parkedUser.setDelay(5);
        searchingUser.setDelay(5);
        parkedUser.setPBucks(20);
        searchingUser.setPBucks(30);
        assertTrue(searchingUser.exchange());
        assertTrue(searchingUser.getSpotReservation().getSpotexchange().isSuccess());
        assertEquals(20,searchingUser.getPBucks());
        assertEquals(30,parkedUser.getPBucks());
    }

}
