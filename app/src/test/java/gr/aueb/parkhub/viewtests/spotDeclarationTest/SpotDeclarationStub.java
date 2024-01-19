package gr.aueb.parkhub.viewtests.spotDeclarationTest;

import gr.aueb.parkhub.domain.Time;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.views.spotDeclaration.SpotDeclarationPresenter;
import gr.aueb.parkhub.views.spotDeclaration.SpotDeclarationView;

public class SpotDeclarationStub implements SpotDeclarationView {

    private String street, city, region, message, stNumber ;
    private int backClicks;
    private Time time;
    private Integer attachedUserID ;


    @Override
    public void back(Integer userID) {
        backClicks++;
    }

    @Override
    public void declare(Integer userID) {

    }

    public int getBackClicks(){
        return this.backClicks;
    }

    @Override
    public Integer getAttachedUserID() {
        return this.attachedUserID;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public void setStNumber(int stNumber) {

    }

    public void setStNumber(String stNumber) {
        this.stNumber = stNumber;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getStNumber() {
        return this.stNumber;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getRegion() {
        return this.region;
    }

    @Override
    public void showErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage(){
        return this.message;
    }

    @Override
    public Time getTime() {
        return this.time;
    }

    @Override
    public void setContent(User user) {
    }

    public void setAttachedUserID(Integer id){
        this.attachedUserID = id ;
    }

}
