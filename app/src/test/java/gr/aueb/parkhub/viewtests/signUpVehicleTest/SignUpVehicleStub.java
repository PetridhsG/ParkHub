package gr.aueb.parkhub.viewtests.signUpVehicleTest;

import gr.aueb.parkhub.views.signUpVehicle.SignUpVehicleView;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SignUpVehicleStub implements SignUpVehicleView {

    private String errorMessage;
    private String brand;
    private String model;
    private String color;
    private String licensePlate;
    private String size;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String telephone;

    private int SignUpCompleteClicks;
    private int SignUpPersonalClicks;


    @Override
    public void signUpComplete() {
        SignUpCompleteClicks++;
    }

    @Override
    public void signUpPersonal() {
        SignUpPersonalClicks++;
    }

    public int getSignUpCompleteClicks(){
        return SignUpCompleteClicks;
    }

    public int getSignUpPersonalClicks(){
        return SignUpPersonalClicks;
    }

    @Override
    public void showErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
