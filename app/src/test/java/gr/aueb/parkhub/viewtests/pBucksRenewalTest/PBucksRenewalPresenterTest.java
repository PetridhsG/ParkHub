package gr.aueb.parkhub.viewtests.pBucksRenewalTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

import gr.aueb.parkhub.dao.AccountDAO;
import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.domain.User;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.views.pBucksRenewal.PBucksRenewalPresenter;
import gr.aueb.parkhub.viewtests.viewProfileTest.ViewProfileStub;

/**
 * @author Χριστουλάκης Ιωσήφ
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class PBucksRenewalPresenterTest {

    private Initializer data;
    private PBucksRenewalPresenter presenter;
    private PBucksRenewalStub view;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */
    @Before
    public void setUp() {
        data = new MemoryInitializer();
        data.prepareData();
        view = new PBucksRenewalStub();
    }

    /**
     * Έλεγχος της λειτουργίας pack10
     */
    @Test
    public void testPack10() {
        User user = (new AccountDAOMemory()).findUserByEmail("sifisxr@gmail.com");
        view.setAttachedUserID(user.getId());
        view.setContent(user);
        presenter = new PBucksRenewalPresenter(view,new AccountDAOMemory());

        user.setPBucks(100);
        presenter.onPack10();

        assertEquals((Integer)user.getId(), view.getPack10UserID());
        assertEquals(110, view.getContent().getPBucks());
    }

    /**
     * Έλεγχος της λειτουργίας pack20
     */
    @Test
    public void testPack20() {
        User user = (new AccountDAOMemory()).findUserByEmail("sifisxr@gmail.com");
        view.setAttachedUserID(user.getId());
        view.setContent(user);
        presenter = new PBucksRenewalPresenter(view,new AccountDAOMemory());

        user.setPBucks(100);
        presenter.onPack20();

        assertEquals((Integer)user.getId(), view.getPack20UserID());
        assertEquals(120, view.getContent().getPBucks());
    }

    /**
     * Έλεγχος της λειτουργίας pack50
     */
    @Test
    public void testPack50() {
        User user = (new AccountDAOMemory()).findUserByEmail("sifisxr@gmail.com");
        view.setAttachedUserID(user.getId());
        view.setContent(user);
        presenter = new PBucksRenewalPresenter(view,new AccountDAOMemory());

        user.setPBucks(100);
        presenter.onPack50();

        assertEquals((Integer)user.getId(), view.getPack50UserID());
        assertEquals(150, view.getContent().getPBucks());
    }

    /**
     * Έλεγχος της λειτουργίας pack100
     */
    @Test
    public void testPack100() {
        User user = (new AccountDAOMemory()).findUserByEmail("sifisxr@gmail.com");
        view.setAttachedUserID(user.getId());
        view.setContent(user);
        presenter = new PBucksRenewalPresenter(view,new AccountDAOMemory());

        user.setPBucks(100);
        presenter.onPack100();


        assertEquals((Integer)user.getId(), view.getPack100UserID());
        assertEquals(200, view.getContent().getPBucks());
    }
}

