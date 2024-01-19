package gr.aueb.parkhub.domaintest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import gr.aueb.parkhub.domain.Time;

public class TimeTest{

    @Test
    public void TimeConstructorTest(){
        Time time = new Time(23,45);
        assertEquals(23,time.getHour());
        assertEquals(45,time.getMinute());
    }

    @Test
    public void TimeSettersTest(){
        Time time = new Time(23,45);
        time.setHour(15);
        time.setMinute(34);
        assertEquals(15,time.getHour());
        assertEquals(34,time.getMinute());
    }

    @Test
    public void TimeEqualsTest(){
        Time time = new Time(22,34);
        Time time1 = new Time(22,34);
        assertEquals(time, time1);
    }

}