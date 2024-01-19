package gr.aueb.parkhub.viewtests.signInTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.views.signIn.SignInPresenter;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SignInPresenterTest {

    private Initializer data ;
    private SignInPresenter presenter;

    private SignInStub view ;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */

    @Before
    public void setUp(){
        data = new MemoryInitializer();
        data.prepareData();
        view = new SignInStub();
    }

    /**
     * Έλεγχος της λειτουργίας SignUpPersonal
     */
    @Test
    public void testSignUpPersonal() {
        presenter = new SignInPresenter(view, new AccountDAOMemory());
        for (int i = 0; i < 10; i++) {
            presenter.onSignUpPersonal();
        }

        assertEquals(10, view.getSignUpPersonalClicks());
    }

    /**
     * Έλεγχος της λειτουργίας Homepage
     */
    @Test
    public void testHomepage() {
        presenter = new SignInPresenter(view, new AccountDAOMemory());


        view.setEmail("sifisxr@gmail.com");
        view.setPassword("1234");
        presenter.onHomePage();
        assertEquals("Wrong password.", view.getErrorMessage());

        view.setEmail("sifisxr23@gmail.com");
        view.setPassword("12345");
        presenter.onHomePage();
        assertEquals("This email is not associated with an account.", view.getErrorMessage());

        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        presenter.onHomePage();
    }
}
