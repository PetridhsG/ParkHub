package gr.aueb.parkhub.viewtests.editProfileTest;


import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.views.editProfile.EditProfileView;

/**
 * @author Χριστουλάκης Ιωσήφ
 * <p>
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 */
public class EditProfileStub implements EditProfileView {

    private Integer attachedUserID;


    private int backClicks;

    private Integer backUserID;
    private Integer finishUserID;
    private int finishClicks;
    private String errorMessage;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String telephone;
    private String brand;
    private String model;
    private String color;
    private String licensePlate;
    private String size;

    @Override
    public Integer getAttachedUserID() {
        return attachedUserID;
    }

    public void setAttachedUserID(Integer id) {
        this.attachedUserID = id;
    }

    @Override
    public void setContent(User user) {

    }

    @Override
    public void homePage(Integer userID) {
        this.backUserID = userID;
        this.backClicks++;
    }

    @Override
    public void finish(Integer userID) {
        this.finishUserID = userID;
        this.finishClicks++;
    }

    public int getFinishUserID() {
        return finishUserID;
    }

    public int getBackClicks(){
        return backClicks;
    }
    public int getFinishClicks() {
        return finishClicks;
    }

    @Override
    public void showErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
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


}

