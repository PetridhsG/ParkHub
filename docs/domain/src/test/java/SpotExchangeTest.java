import org.junit.jupiter.api.*;
public class SpotExchangeTest {

    @Test
    public void SpotExchangeConstructorTest(){
        SpotExchange spotExchange = new SpotExchange();
        Assertions.assertEquals(0,spotExchange.getMin());
    }

    @Test
    public void SpotExchangeSettersTest(){
        SpotExchange spotExchange = new SpotExchange();
        spotExchange.setSuccess(true);
        spotExchange.setMin(5);
        spotExchange.setValidity(true);
        Assertions.assertTrue(spotExchange.isSuccess());
        Assertions.assertTrue(spotExchange.isValidity());
        Assertions.assertEquals(5,spotExchange.getMin());
    }

}
