package gr.aueb.parkhub.domaintest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;



import gr.aueb.parkhub.domain.Address;


public class AddressTest {


    @Test
    public void AddressConstructorTest(){
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        assertEquals("Pathsiwn",address.getStreet());
        assertEquals(76,address.getStNumber());
        assertEquals("Athens",address.getCity());
        assertEquals("Kypseli",address.getRegion());

    }

    @Test
    public void AddressSettersTest(){
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        address.setStreet("Aristoteloys");
        address.setStNumber(10);
        address.setCity("Thessaloniki");
        address.setRegion("Kentro");
        assertEquals("Aristoteloys",address.getStreet());
        assertEquals(10,address.getStNumber());
        assertEquals("Thessaloniki",address.getCity());
        assertEquals("Kentro",address.getRegion());
    }

    @Test
    public void AddressEqualsTest(){
        Address address = new Address("Pathsiwn",76,"Athens","Kypseli");
        Address address1 = new Address("Pathsiwn",76,"Athens","Kypseli");
        assertEquals(address, address1);
    }

}
