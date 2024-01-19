package gr.aueb.parkhub.viewtests.spotReservationTest;

import gr.aueb.parkhub.domain.Time;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.views.spotReservation.SpotReservationView;

public class SpotReservationStub implements SpotReservationView {

    private String constraint,region,title,message,toastMessage;

    private Time time;
    private Integer attachedUserID,parkingSpotID;

    private int backClicks;

    @Override
    public void back(Integer userID) {
        backClicks++;
    }

    public int getBackClicks(){
        return this.backClicks;
    }

    @Override
    public void apply(String constraint) {
        this.constraint = constraint;
    }


    @Override
    public void confirm(Integer userID) {

    }

    @Override
    public void setContent(User user) {

    }

    public String getConstraint(){
        return this.constraint;
    }
    @Override
    public Time getTime() {
        return this.time;
    }

    @Override
    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String getRegion() {
        return this.region;
    }

    @Override
    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public void setParkingSpotID(Integer parkingSpotID) {
        this.parkingSpotID = parkingSpotID;
    }

    @Override
    public Integer getParkingSpotID() {
        return this.parkingSpotID;
    }

    @Override
    public Integer getAttachedUserID() {
        return this.attachedUserID;
    }

    @Override
    public void showMessage(String title, String message) {
        this.title = title;
        this.message = message;
    }

    @Override
    public void showToast(String toastMessage) {
        this.toastMessage = toastMessage;
    }

    public String getToastMessage(){
        return this.toastMessage;
    }

    public String getTitle(){
        return this.title;
    }

    public void setAttachedUserID(Integer id){
        this.attachedUserID = id ;
    }
}
