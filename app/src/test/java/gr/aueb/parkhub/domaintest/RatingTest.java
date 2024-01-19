package gr.aueb.parkhub.domaintest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import gr.aueb.parkhub.domain.Rating;

public class RatingTest {

    @Test
    public void RatingConstructorTest(){
        Rating rating = new Rating(0.5,"Arghse poly!!!");
        assertEquals(0.5,rating.getRating(),0.001);
        assertEquals("Arghse poly!!!",rating.getComment());
    }

}
