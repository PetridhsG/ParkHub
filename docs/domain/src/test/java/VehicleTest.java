import org.junit.jupiter.api.*;

public class VehicleTest{

    @Test
    public void VehicleConstructorTest(){

        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        Assertions.assertEquals("red",vehicle.getColor());
        Assertions.assertEquals(3.2,vehicle.getSize());
        Assertions.assertEquals("Toyota",vehicle.getBrand());
        Assertions.assertEquals("Corolla",vehicle.getModel());
        Assertions.assertEquals("ZNZ7080",vehicle.getLicensePlate());
    }

    @Test
    public void VehicleSettersTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        vehicle.setColor("green");
        vehicle.setSize(4.5);
        vehicle.setBrand("Mazda");
        vehicle.setModel("B2500");
        vehicle.setLicensePlate("KBK5432");
        Assertions.assertEquals("green",vehicle.getColor());
        Assertions.assertEquals(4.5,vehicle.getSize());
        Assertions.assertEquals("Mazda",vehicle.getBrand());
        Assertions.assertEquals("B2500",vehicle.getModel());
        Assertions.assertEquals("KBK5432",vehicle.getLicensePlate());
    }

    @Test
    public void VehicleEqualsTest(){
        Vehicle vehicle = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        Vehicle vehicle1 = new Vehicle("red",3.2,"Toyota","Corolla","ZNZ7080");
        Assertions.assertTrue(vehicle.equals(vehicle1));
    }

}