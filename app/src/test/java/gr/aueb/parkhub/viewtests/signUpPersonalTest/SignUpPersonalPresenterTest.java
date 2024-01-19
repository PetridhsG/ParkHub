package gr.aueb.parkhub.viewtests.signUpPersonalTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.views.signUpPersonal.SignUpPersonalPresenter;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */


public class SignUpPersonalPresenterTest {

    private Initializer data ;
    private SignUpPersonalPresenter presenter;

    private SignUpPersonalStub view ;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */

    @Before
    public void setUp(){
        data = new MemoryInitializer();
        data.prepareData();
        view = new SignUpPersonalStub();
    }

    /**
     * Έλεγχος της λειτουργίας SignIn
     */
    @Test
    public void testSignIn() {
        presenter = new SignUpPersonalPresenter(view);
        for (int i = 0; i < 10; i++) {
            presenter.onSignIn();
        }

        assertEquals(10, view.getSignInClicks());

    }

    /**
     * Έλεγχος της λειτουργίας SignUpVehicle
     */
    @Test
    public void testSignUpVehicle(){
        presenter = new SignUpPersonalPresenter(view);

        view.setName("1");
        presenter.onSignUpVehicle();
        assertEquals("Please only use letters in the name text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("1");
        presenter.onSignUpVehicle();
        assertEquals("Please only use letters in the surname text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("kf.com");
        presenter.onSignUpVehicle();
        assertEquals("Please enter a valid email address.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("");
        presenter.onSignUpVehicle();
        assertEquals("Please fill the password text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("qwerty12345");
        view.setTelephone("69");
        presenter.onSignUpVehicle();
        assertEquals("Please only use numbers in the phone number text and make sure they are 10.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("6984137274");
        presenter.onSignUpVehicle();

    }
}
