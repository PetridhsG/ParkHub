package gr.aueb.parkhub.viewtests.pBucksRenewalTest;


import gr.aueb.parkhub.views.pBucksRenewal.PBucksRenewalView;
import gr.aueb.parkhub.domain.User;


/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class PBucksRenewalStub implements PBucksRenewalView {
    private Integer homePageUserID;
    private Integer pack10UserID;
    private Integer pack20UserID;
    private Integer pack50UserID;
    private Integer pack100UserID;
    private Integer attachedUserID;
    private User content;

    @Override
    public void homePage(Integer userID) {
        this.homePageUserID = userID;
    }

    @Override
    public void pack10(Integer userID) {
        this.pack10UserID = userID;
    }

    @Override
    public void pack20(Integer userID) {
        this.pack20UserID = userID;
    }

    @Override
    public void pack50(Integer userID) {
        this.pack50UserID = userID;
    }

    @Override
    public void pack100(Integer userID) {
        this.pack100UserID = userID;
    }

    @Override
    public Integer getAttachedUserID() {
        return attachedUserID;
    }

    public void setAttachedUserID(Integer attachedUserID) {
        this.attachedUserID = attachedUserID;
    }

    @Override
    public void setContent(User user) {
        this.content = user;
    }

    public Integer getHomePageUserID() {
        return homePageUserID;
    }

    public Integer getPack10UserID() {
        return pack10UserID;
    }

    public Integer getPack20UserID() {
        return pack20UserID;
    }

    public Integer getPack50UserID() {
        return pack50UserID;
    }

    public Integer getPack100UserID() {
        return pack100UserID;
    }

    public User getContent() {
        return content;
    }

}

