package gr.aueb.parkhub.viewtests.viewProfileTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.domain.SearchingUser;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.views.editProfile.EditProfilePresenter;
import gr.aueb.parkhub.views.viewProfile.ViewProfilePresenter;
import gr.aueb.parkhub.views.viewProfile.ViewProfileView;
import gr.aueb.parkhub.viewtests.editProfileTest.EditProfileStub;


/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class ViewProfilePresenterTest {

    private Initializer data;
    private ViewProfileStub view;
    private ViewProfilePresenter presenter;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */
    @Before
    public void setUp() {
        data = new MemoryInitializer();
        data.prepareData();
        view = new ViewProfileStub();
    }

    /**
     * Έλεγχος της λειτουργίας back
     */
    @Test
    public void testBack() {
        User user = (new AccountDAOMemory()).findUserByEmail("sifisxr@gmail.com");
        view.setAttachedUserID(user.getId());
            presenter = new ViewProfilePresenter(view, new AccountDAOMemory());
        for (int i = 0; i < 10; i++) {
            presenter.onHomePage();
        }

        assertEquals(10, view.getBackClicks());

    }

    /**
     * Έλεγχος της λειτουργίας edit
     */
    @Test
    public void testEdit() {
        User user = (new AccountDAOMemory()).findUserByEmail("sifisxr@gmail.com");
        view.setAttachedUserID(user.getId());
        presenter = new ViewProfilePresenter(view, new AccountDAOMemory());
        for (int i = 0; i < 10; i++) {
            presenter.onEditProfile();
        }

        assertEquals(10, view.getEditClicks());

    }

}
