package gr.aueb.parkhub.domaintest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import gr.aueb.parkhub.domain.Vehicle;

public class VehicleTest{

    @Test
    public void VehicleConstructorTest(){

        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        assertEquals("red",vehicle.getColor());
        assertEquals(3.2,vehicle.getSize(),0.001);
        assertEquals("Toyota",vehicle.getBrand());
        assertEquals("Corolla",vehicle.getModel());
        assertEquals("ZNZ7080",vehicle.getLicensePlate());
    }

    @Test
    public void VehicleSettersTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        vehicle.setColor("green");
        vehicle.setSize(4.5);
        vehicle.setBrand("Mazda");
        vehicle.setModel("B2500");
        vehicle.setLicensePlate("KBK5432");
        assertEquals("green",vehicle.getColor());
        assertEquals(4.5,vehicle.getSize(),0.001);
        assertEquals("Mazda",vehicle.getBrand());
        assertEquals("B2500",vehicle.getModel());
        assertEquals("KBK5432",vehicle.getLicensePlate());
    }

    @Test
    public void VehicleEqualsTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        Vehicle vehicle1 = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        assertEquals(vehicle, vehicle1);
    }

}