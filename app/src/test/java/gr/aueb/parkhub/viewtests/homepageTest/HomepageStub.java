package gr.aueb.parkhub.viewtests.homepageTest;

import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.views.homepage.HomepagePresenter;
import gr.aueb.parkhub.views.homepage.HomepageView;

public class HomepageStub implements HomepageView {

    private Integer attachedUserID ;
    private String title,message,toastMessage;

    private HomepagePresenter presenter;
    private int viewProfileClicks,addPBucksClicks,declareSpotClicks,
            reserveSpotClicks,reportFalseSpotClicks,viewStatisticsClicks;
    @Override
    public Integer getAttachedUserID() {
        return this.attachedUserID;
    }

    public void setAttachedUserID(Integer id){
        this.attachedUserID = id ;
    }

    @Override
    public void viewProfile(Integer userID) {
        viewProfileClicks++;
    }

    @Override
    public void addPBucks(Integer userID) {
        addPBucksClicks++;
    }

    @Override
    public void declareSpot(Integer userID) {
        declareSpotClicks++;
    }

    @Override
    public void reserveSpot(Integer userID) {
        reserveSpotClicks++;
    }

    @Override
    public void exchangeSpot(Integer userID) {
        ;
    }

    @Override
    public void reportFalseSpot(Integer userID) {
        reportFalseSpotClicks++;
    }

    @Override
    public void viewStatistics(Integer userID) {
        viewStatisticsClicks++;
    }

    public int getViewProfileClicks(){
        return viewProfileClicks;
    }

    public int getAddPBucksClicks(){
        return addPBucksClicks;
    }

    public int getDeclareSpotClicks(){
        return declareSpotClicks;
    }

    public int getReserveSpotClicks(){
        return reserveSpotClicks;
    }

    public int getReportFalseSpotClicks(){
        return reportFalseSpotClicks;
    }

    public int getViewStatisticsClicks(){
        return viewStatisticsClicks ;
    }

    @Override
    public void showErrorMessage(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getErrorMessageTitle(){
        return this.title;
    }

    public String getErrorMessage(){
        return this.message;
    }

    @Override
    public void setContent(User user) {

    }

    @Override
    public void showToastMessage(String message) {
        this.toastMessage = message;
    }

    public String getToastMessage(){
        return this.toastMessage;
    }
}
