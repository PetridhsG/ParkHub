import org.junit.jupiter.api.*;
public class SearchingUserTest {

    @Test
    public void SearchingUserConstructorTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Assertions.assertEquals(100,user.getPBucks());
        Assertions.assertEquals("Alexis",user.getName());
        Assertions.assertEquals("Kefalas",user.getSurname());
        Assertions.assertEquals("qwerty12",user.getPassword());
        Assertions.assertEquals("akefalas@gmail.com",user.getEmail());
        Assertions.assertEquals("6975431238",user.getTelephone());
        Assertions.assertEquals(user.getUid()-1,user.getId());
        Assertions.assertTrue(vehicle.equals(user.getVehicle()));

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
        Assertions.assertTrue(spotReservation.equals(searchingUser.getSpotReservation()));
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
        Assertions.assertFalse(searchingUser.reserveParkingSpot(false,arrivalTime,parkingSpot));
        Assertions.assertTrue(searchingUser.reserveParkingSpot(true,arrivalTime,parkingSpot));
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
        Assertions.assertFalse(searchingUser.getSpotReservation().getSpotexchange().isValidity());
        Assertions.assertFalse(searchingUser.getSpotReservation().getSpotexchange().isSuccess());

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
        Assertions.assertFalse(searchingUser.exchange());
        Assertions.assertFalse(searchingUser.getSpotReservation().getSpotexchange().isSuccess());
        parkedUser.setDelay(5);
        searchingUser.setDelay(15);
        parkedUser.setPBucks(20);
        searchingUser.setPBucks(30);
        Assertions.assertFalse(searchingUser.exchange());
        Assertions.assertFalse(searchingUser.getSpotReservation().getSpotexchange().isSuccess());
        Assertions.assertEquals(20,searchingUser.getPBucks());
        Assertions.assertEquals(30,parkedUser.getPBucks());
        parkedUser.setDelay(5);
        searchingUser.setDelay(5);
        parkedUser.setPBucks(20);
        searchingUser.setPBucks(30);
        Assertions.assertTrue(searchingUser.exchange());
        Assertions.assertTrue(searchingUser.getSpotReservation().getSpotexchange().isSuccess());
        Assertions.assertEquals(20,searchingUser.getPBucks());
        Assertions.assertEquals(30,parkedUser.getPBucks());
    }

}
