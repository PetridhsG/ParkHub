package gr.aueb.parkhub.domain;

import java.util.Objects;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
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

    /**
     * Copy constructor
     * @param other ένα όχημα
     */
    public Vehicle(Vehicle other) {
        this.color = other.color;
        this.size = other.size;
        this.brand = other.brand;
        this.model = other.model;
        this.licensePlate = other.licensePlate;
    }

    /**
     * Επιστρέφει το χρώμα του οχήματος
     * @return το χρώμα
     */
    public String getColor() {
        return color;
    }

    /**
     * Θέτει το χρώμα του οχήματος
     * @param color το χρώμα
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Επιστρέφει το μέγεθος του οχήματος
     * @return το μέγεθος
     */
    public double getSize() {
        return size;
    }

    /**
     * Θέτει το μέγεθος του οχήματος
     * @param size το μέγεθος
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Επιστρέφει την μάρκα του οχήματος
     * @return την μάρκα
     */
    public String getBrand() {
        return brand;
    }

    /**
     * θέτει την μάρκα του οχήματος
     * @param brand η μάρκα
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Επιστρέφει το μοντέλο του οχήματος
     * @return το μοντέλο
     */
    public String getModel() {
        return model;
    }

    /**
     * Θέτει το μοντέλο του οχήματος
     * @param model το μοντέλο
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Επιστρέφει τον αριθμό πινακίδας του οχήματος
     * @return τον αριθμό πινακίδας
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Θέτει τον αριθμό πινακίδας του οχήματος
     * @param licensePlate τον αριθμό πινακίδας
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Ελέγχει την ισότητα δύο αντικειμένων τύπου vehicle
     * @param o ένα αντικείμενο τύπου vehicle
     * @return αν είναι ίσα τα αντικείμενα
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(size, vehicle.size) == 0 && Objects.equals(color, vehicle.color) && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(licensePlate, vehicle.licensePlate);
    }

    /**
     * Επιστρέφει την συμβολοσειρά της κλάσης
     * @return η συμβολοσειρά της κλάσης
     */
    @Override
    public String toString() {
        return brand + " " + model + ", " + color + ", " + licensePlate;
    }
}