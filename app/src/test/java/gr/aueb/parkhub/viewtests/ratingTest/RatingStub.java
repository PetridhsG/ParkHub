package gr.aueb.parkhub.viewtests.ratingTest;

import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.views.rating.RatingView;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class RatingStub implements RatingView {

    private String comments,message ;

    private double rating;
    private int backClicks,submitClicks;

    private Integer attachedUserID ;
    @Override
    public void back(Integer userID) {
        backClicks++;
    }

    @Override
    public void submit(Integer userID) {

    }

    @Override
    public void setContent(User user) {

    }

    @Override
    public Integer getAttachedUserID() {
        return attachedUserID;
    }

    public void setAttachedUserID(Integer id){
        this.attachedUserID = id ;
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String getComments() {
        return this.comments;
    }

    @Override
    public double getRating() {
        return this.rating;
    }

    @Override
    public void showToastMessage(String message) {
        this.message = message;
    }

    public String getToastMessage(){
        return this.message;
    }
}
