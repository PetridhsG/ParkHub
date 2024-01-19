package gr.aueb.parkhub.viewtests.signUpVehicleTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.views.signUpVehicle.SignUpVehiclePresenter;

/**
 * @author Δημήτρης Κεφαλάς
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */


public class SignUpVehiclePresenterTest {

    private Initializer data ;
    private SignUpVehiclePresenter presenter;

    private SignUpVehicleStub view ;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */

    @Before
    public void setUp(){
        data = new MemoryInitializer();
        data.prepareData();
        view = new SignUpVehicleStub();
    }

    /**
     * Έλεγχος της λειτουργίας SignUpPersonal
     */
    @Test
    public void testSignUpPersonal() {
        presenter = new SignUpVehiclePresenter(view, new AccountDAOMemory());
        for (int i = 0; i < 10; i++) {
            presenter.onSignUpPersonal();
        }

        assertEquals(10, view.getSignUpPersonalClicks());

    }

    /**
     * Έλεγχος της λειτουργίας SignUpComplete
     */
    @Test
    public void testSignUpComplete(){
        presenter = new SignUpVehiclePresenter(view, new AccountDAOMemory());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("6984137274");
        view.setBrand("1");
        presenter.onSignUpComplete();
        assertEquals("Please only use letters in the brand text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("6984137274");
        view.setBrand("Toyota");
        view.setModel("@");
        view.setColor("Black");
        view.setLicensePlate("XNK6969");
        view.setSize("3.5");
        presenter.onSignUpComplete();
        assertEquals("Please only use letters and numbers in the model text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("6984137274");
        view.setBrand("Toyota");
        view.setModel("Hilux");
        view.setColor("1");
        view.setLicensePlate("XNK6969");
        view.setSize("3.5");
        presenter.onSignUpComplete();
        assertEquals("Please only use letters in the color text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("6984137274");
        view.setBrand("Toyota");
        view.setModel("Hilux");
        view.setColor("Black");
        view.setLicensePlate("@#");
        view.setSize("3.5");
        presenter.onSignUpComplete();
        assertEquals("Please only use letters and numbers in the license plate text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("6984137274");
        view.setBrand("Toyota");
        view.setModel("Hilux");
        view.setColor("Black");
        view.setLicensePlate("XNK6969");
        view.setSize("a");
        presenter.onSignUpComplete();
        assertEquals("Please only use numbers in the size text.",view.getErrorMessage());


        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("6984137274");
        view.setBrand("Toyota");
        view.setModel("Hilux");
        view.setColor("Black");
        view.setLicensePlate("XNK6969");
        view.setSize("3.5");
        presenter.onSignUpComplete();

    }
}
