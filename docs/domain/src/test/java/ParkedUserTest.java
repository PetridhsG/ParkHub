import org.junit.jupiter.api.*;
public class ParkedUserTest {


    @Test
    public void ParkedUserConstructorTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser user = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
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
    public void ParkedUserSettersTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser user = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        ParkingSpot parkingSpot = new ParkingSpot(new Time(14,40),new Address("Pathsiwn",76,"Athens","Kypseli"),user);
        user.setParkingSpot(parkingSpot);
        Assertions.assertTrue(parkingSpot.equals(user.getParkingSpot()));
    }

    @Test void ParkedUserDeclareParkingSpotTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        ParkedUser user = new ParkedUser("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Time time = new Time(11,40);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        ParkingSpot parkingSpot = new ParkingSpot(time,address,user);
        user.declareParkingSpot(time,address);
        Assertions.assertTrue(parkingSpot.equals(user.getParkingSpot()));
    }

}
