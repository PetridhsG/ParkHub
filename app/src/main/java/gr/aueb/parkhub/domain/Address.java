package gr.aueb.parkhub.domain;

import java.util.Objects;

/**
 * @author Χριστουλακης Ιωσηφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class Address{

    private String street;
    private int stNumber;
    private String city;
    private String region;


    public Address(String street, int stNumber, String city, String region) {
        this.street = street;
        this.stNumber = stNumber;
        this.city = city;
        this.region = region;
    }

    /**
     * Επιστρέφει την οδό της διεύθυνσης
     * @return η οδός της διεύθυνσης
     */
    public String getStreet() {
        return street;
    }

    /**
     * Θέτει την οδό της διεύθυνσης
     * @param street  η οδός της διεύθυνσης
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Επιστρέφει τον αριθμό οδού της διεύθυνσης
     * @return ο αριθμός οδού της διεύθυνσης
     */
    public int getStNumber() {
        return stNumber;
    }

    /**
     * Θέτει τον αριθμό οδού της διεύθυνσης
     * @param stNumber ο αριθμός οδού της διεύθυνσης
     */
    public void setStNumber(int stNumber) {
        this.stNumber = stNumber;
    }

    /**
     * Επιστρέφει την πόλη της διεύθυνσης
     * @return η πόλη της διεύθυνσης
     */
    public String getCity() {
        return city;
    }

    /**
     * Θέτει την πόλη της διεύθυνσης
     * @param city η πόλη της διεύθυνσης
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Επιστρέφει την περιοχή της διεύθυνσης
     * @return η περιοχή της διεύθυνσης
     */
    public String getRegion() {
        return region;
    }

    /**
     * Θέτει την περιοχή της διεύθυνσης
     * @param region  η περιοχή της διεύθυνσης
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Ελέγχει την ισότητα δύο αντικειμένων τύπου address
     * @param o ένα αντικείμενο τύπου address
     * @return αν είναι ίσα τα αντικείμενα
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return stNumber == address.stNumber && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(region, address.region);

    }

    /**
     * Επιστρέφει την συμβολοσειρά της κλάσης
     * @return η συμβολοσειρά της κλάσης
     */
    @Override
    public String toString() {
        return street + " " + stNumber + ", " + region + ", " + city;
    }

}
