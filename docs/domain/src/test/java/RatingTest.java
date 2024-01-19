import org.junit.jupiter.api.*;

public class RatingTest {

    @Test
    public void RatingConstructorTest(){
        Rating rating = new Rating(0.5,"Arghse poly!!!");
        Assertions.assertEquals(0.5,rating.getRating());
        Assertions.assertEquals("Arghse poly!!!",rating.getComment());
    }

}
