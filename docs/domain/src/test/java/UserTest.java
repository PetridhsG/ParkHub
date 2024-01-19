import org.junit.jupiter.api.*;
import java.util.ArrayList;
public class UserTest{


    @Test
    public void UserConstructorTest(){
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
    public void UserSettersTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Vehicle vehicle1 = new Vehicle("green",4.5,"Mazda","B2500","KBK5432");
        user.setVehicle(vehicle1);
        user.setDelay(10);
        user.setName("Kwstas");
        user.setSurname("Papadakis");
        user.setEmail("kpapadakis@gmail.com");
        user.setPassword("qwerty");
        user.setTelephone("6979032451");
        user.setAverageDelayTime(4.5);
        user.setRating(2.0);
        user.setPBucks(150);
        ArrayList<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating(0.5,"ARGHSE POLY!"));
        ratings.add(new Rating(4,"Arghse ligo"));
        user.setRatings(ratings);
        Assertions.assertTrue(vehicle1.equals(user.getVehicle()));
        Assertions.assertTrue(ratings.equals(user.getRatings()));
        Assertions.assertEquals(10,user.getDelay());
        Assertions.assertEquals("Kwstas",user.getName());
        Assertions.assertEquals("Papadakis",user.getSurname());
        Assertions.assertEquals("kpapadakis@gmail.com",user.getEmail());
        Assertions.assertEquals("kpapadakis@gmail.com",user.getEmail());
        Assertions.assertEquals("qwerty",user.getPassword());
        Assertions.assertEquals("6979032451",user.getTelephone());
        Assertions.assertEquals(2.0,user.getRating());
        Assertions.assertEquals(4.5,user.getAverageDelayTime());
        Assertions.assertEquals(150,user.getPBucks());

    }

    @Test
    public void PBucksRenewalTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        user.PBucksRenewal(1);
        Assertions.assertEquals(110,user.getPBucks());
        user.PBucksRenewal(2);
        Assertions.assertEquals(140,user.getPBucks());
        user.PBucksRenewal(3);
        Assertions.assertEquals(240,user.getPBucks());
    }

    @Test
    public void UserEqualsTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Vehicle vehicle1 = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user1 = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Assertions.assertTrue(user.equals(user1));
    }

}