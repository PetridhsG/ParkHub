import org.junit.jupiter.api.*;

public class ParkingSpotTest{

    @Test
    public void ParkingSpotConstructorTest(){
        Time time = new Time(23,45);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        ParkingSpot parkingSpot= new ParkingSpot(time,address,user);
        Assertions.assertTrue(time.equals(parkingSpot.getTime()));
        Assertions.assertTrue(address.equals(parkingSpot.getAddress()));
        Assertions.assertTrue(user.equals(parkingSpot.getUser()));
        Assertions.assertTrue(parkingSpot.isAvailability());
        Assertions.assertEquals(parkingSpot.uid-1,parkingSpot.getId());
    }

    @Test
    public void ParkingSpotSettersTest(){
        Time time = new Time(23,45);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        ParkingSpot parkingSpot= new ParkingSpot(time,address,user);
        Time time2 = new Time(12,34);
        Address address2 = new Address("Xaniwn",13,"Thessalonikh","Kamara");
        Vehicle vehicle2 = new Vehicle("green",4.5,"Mazda","B2500","KBK5432");
        User user2 = new User("Giwrgos","Gewrgiadhs","gxrisoupoli@gmail.com","1234567","6943545678",vehicle2);
        parkingSpot.setTime(time2);
        parkingSpot.setAddress(address2);
        parkingSpot.setUser(user2);
        parkingSpot.setAvailability(false);
        Assertions.assertTrue(time2.equals(parkingSpot.getTime()));
        Assertions.assertTrue(address2.equals(parkingSpot.getAddress()));
        Assertions.assertTrue(user2.equals(parkingSpot.getUser()));
    }

    @Test
    public void ParkingSpotEqualsTest(){
        Time time = new Time(23,45);
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        ParkingSpot parkingSpot= new ParkingSpot(time,address,user);
        Time time2 = new Time(23,45);
        Address address2 = new Address("Pathsiwn",76,"Athens","Kypseli");
        Vehicle vehicle2 = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user2 = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle2);
        ParkingSpot parkingSpot2= new ParkingSpot(time2,address2,user2);
        Assertions.assertTrue(parkingSpot.equals(parkingSpot2));
    }

}
