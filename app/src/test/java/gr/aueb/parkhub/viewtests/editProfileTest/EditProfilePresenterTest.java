package gr.aueb.parkhub.viewtests.editProfileTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.domain.Vehicle;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.views.editProfile.EditProfilePresenter;
import gr.aueb.parkhub.views.editProfile.EditProfileView;
/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */


public class EditProfilePresenterTest {


    private Initializer data;
    private EditProfileStub view;
    private EditProfilePresenter presenter;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */
    @Before
    public void setUp() {
        data = new MemoryInitializer();
        data.prepareData();
        view = new EditProfileStub();
        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());

    }

    /**
     * Έλεγχος της λειτουργίας back
     */
    @Test
    public void testBack() {
        User user = (new AccountDAOMemory()).findUserByEmail("sifisxr@gmail.com");
        view.setAttachedUserID(user.getId());
        presenter = new EditProfilePresenter(view, new AccountDAOMemory());
        for (int i = 0; i < 10; i++) {
            presenter.onBack();
        }

        assertEquals(10, view.getBackClicks());

    }

    /**
     * Έλεγχος της λειτουργίας finish
     */
    @Test
    public void testFinish(){
        presenter = new EditProfilePresenter(view, new AccountDAOMemory());

        view.setName("1");
        presenter.onFinish();
        assertEquals("Please use only letters in the name text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("1");
        presenter.onFinish();
        assertEquals("Please use only letters in the surname text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("kf.com");
        presenter.onFinish();
        assertEquals("Please enter a valid email.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("");
        presenter.onFinish();
        assertEquals("Please fill the password text.",view.getErrorMessage());

        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("69");
        presenter.onFinish();
        assertEquals("Please use 10 numbers in the phone number text.",view.getErrorMessage());


        view.setName("Sifis");
        view.setSurname("Xristoulakhs");
        view.setEmail("sifisxr@gmail.com");
        view.setPassword("12345");
        view.setTelephone("6984137274");
        view.setBrand("1");
        presenter.onFinish();
        assertEquals("Please use only letters in the brand text.",view.getErrorMessage());

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
        presenter.onFinish();
        assertEquals("Please use only letters and numbers in the model text.",view.getErrorMessage());

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
        presenter.onFinish();
        assertEquals("Please use only letters in the color text.",view.getErrorMessage());

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
        presenter.onFinish();
        assertEquals("Please use only letters and numbers in the license plate text.",view.getErrorMessage());

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
        presenter.onFinish();
        assertEquals("Please use only numbers in the size text.",view.getErrorMessage());


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
        presenter.onFinish();

    }
}





