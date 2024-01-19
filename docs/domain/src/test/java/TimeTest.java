import org.junit.jupiter.api.*;

public class TimeTest{

    @Test
    public void TimeConstructorTest(){
        Time time = new Time(23,45);
        Assertions.assertEquals(23,time.getHour());
        Assertions.assertEquals(45,time.getMinute());
    }

    @Test
    public void TimeSettersTest(){
        Time time = new Time(23,45);
        time.setHour(15);
        time.setMinute(34);
        Assertions.assertEquals(15,time.getHour());
        Assertions.assertEquals(34,time.getMinute());
    }

    @Test
    public void TimeEqualsTest(){
        Time time = new Time(22,34);
        Time time1 = new Time(22,34);
        Assertions.assertTrue(time.equals(time1));
    }

}