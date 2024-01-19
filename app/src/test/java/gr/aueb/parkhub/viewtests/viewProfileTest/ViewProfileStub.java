package gr.aueb.parkhub.viewtests.viewProfileTest;

import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.views.viewProfile.ViewProfileView;

/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class ViewProfileStub implements ViewProfileView {
    private Integer attachedUserID;


    private Integer homePageUserID;
    private Integer editProfileUserID;
    private String errorMessage;
    private int backClicks;
    private int editClicks;

    @Override
    public Integer getAttachedUserID() {
        return attachedUserID;
    }

    @Override
    public void setContent(User user) {

    }

    public void setAttachedUserID(Integer id) {
        this.attachedUserID = id;
    }

    @Override
    public void homePage(Integer userID) {
        this.homePageUserID = userID;
        this.backClicks++;
    }

    public Integer getHomePageUserID() {
        return homePageUserID;
    }

    @Override
    public void editProfile(Integer userID) {
        this.editProfileUserID = userID;
        this.editClicks++;
    }

    public Integer getEditProfileUserID() {
        return editProfileUserID;
    }


    @Override
    public void showErrorMessage(String message) {
        this.errorMessage = message;
    }

    public int getBackClicks() {
        return backClicks;
    }

    public int getEditClicks(){
        return editClicks;
    }
}
