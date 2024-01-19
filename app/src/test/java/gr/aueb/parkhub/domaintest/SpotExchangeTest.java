package gr.aueb.parkhub.domaintest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import gr.aueb.parkhub.domain.SpotExchange;

public class SpotExchangeTest {

    @Test
    public void SpotExchangeConstructorTest(){
        SpotExchange spotExchange = new SpotExchange();
        assertEquals(0,spotExchange.getMin());
    }

    @Test
    public void SpotExchangeSettersTest(){
        SpotExchange spotExchange = new SpotExchange();
        spotExchange.setSuccess(true);
        spotExchange.setMin(5);
        spotExchange.setValidity(true);
        assertTrue(spotExchange.isSuccess());
        assertTrue(spotExchange.isValidity());
        assertEquals(5,spotExchange.getMin());
    }

}
