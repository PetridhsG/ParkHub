import java.util.Objects;
public class Vehicle{

    private String color;
    private double size;
    private String brand;
    private String model;
    private String licensePlate;


    public Vehicle(String color, double size, String brand, String model, String licensePlate) {
        this.color = color;
        this.size = size;
        this.brand = brand;
        this.model = model;
        this.licensePlate= licensePlate;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(size, vehicle.size) == 0 && Objects.equals(color, vehicle.color) && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(licensePlate, vehicle.licensePlate);
    }


}