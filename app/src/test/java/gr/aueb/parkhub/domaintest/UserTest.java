package gr.aueb.parkhub.domaintest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;

import gr.aueb.parkhub.domain.Rating;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.domain.Vehicle;

public class UserTest{


    @Test
    public void UserConstructorTest(){
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
        assertEquals(vehicle1, user.getVehicle());
        assertEquals(ratings, user.getRatings());
        assertEquals(10,user.getDelay());
        assertEquals("Kwstas",user.getName());
        assertEquals("Papadakis",user.getSurname());
        assertEquals("kpapadakis@gmail.com",user.getEmail());
        assertEquals("kpapadakis@gmail.com",user.getEmail());
        assertEquals("qwerty",user.getPassword());
        assertEquals("6979032451",user.getTelephone());
        assertEquals(2.0,user.getRating(),0.001);
        assertEquals(4.5,user.getAverageDelayTime(),0.001);
        assertEquals(150,user.getPBucks());

    }

    @Test
    public void PBucksRenewalTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        user.PBucksRenewal(1);
        assertEquals(110,user.getPBucks());
        user.PBucksRenewal(2);
        assertEquals(140,user.getPBucks());
        user.PBucksRenewal(3);
        assertEquals(240,user.getPBucks());
    }

    @Test
    public void UserEqualsTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        Vehicle vehicle1 = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        User user1 = new User("Alexis","Kefalas","akefalas@gmail.com","qwerty12","6975431238",vehicle);
        assertEquals(user, user1);
    }

}