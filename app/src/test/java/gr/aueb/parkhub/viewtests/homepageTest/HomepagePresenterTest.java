package gr.aueb.parkhub.viewtests.homepageTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.views.homepage.HomepagePresenter;


/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class HomepagePresenterTest {

    private Initializer data ;
    private HomepagePresenter presenter;

    private HomepageStub view ;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */
    @Before
    public void setUp(){
        data = new MemoryInitializer();
        data.prepareData();
        view = new HomepageStub();
    }

    /**
     * Έλεγχος της λειτουργίας viewProfile
     */
    @Test
    public void testViewProfile(){

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        for (int i =0; i < 10; i++){
            presenter.onViewProfile();
        }

        assertEquals(10,view.getViewProfileClicks());
    }

    /**
     * Έλεγχος της λειτουργίας AddPBucks
     */
    @Test
    public void testAddPBucks(){

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        for (int i =0; i < 10; i++){
            presenter.onAddPBucks();
        }

        assertEquals(10,view.getAddPBucksClicks());
    }

    /**
     * Έλεγχος της λειτουργίας DeclareSpot
     */
    @Test
    public void testDeclareSpot(){

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        for (int i =0; i < 10; i++){
            presenter.onDeclareSpot();
        }
        assertEquals(10,view.getDeclareSpotClicks());

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("dkefalas@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onDeclareSpot();
        assertEquals("Declaration Error",view.getErrorMessageTitle());

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("giannisp@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onDeclareSpot();
        assertEquals("Declaration Error",view.getErrorMessageTitle());
    }

    /**
     * Έλεγχος της λειτουργίας ReserveSpot
     */
    @Test
    public void testReserveSpot(){

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        for (int i =0; i < 10; i++){
            presenter.onReserveSpot();
        }
        assertEquals(10,view.getReserveSpotClicks());

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("dkefalas@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onReserveSpot();
        assertEquals("Reservation Error",view.getErrorMessageTitle());

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("giannisp@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onReserveSpot();
        assertEquals("Reservation Error",view.getErrorMessageTitle());
    }

    /**
     * Έλεγχος της λειτουργίας ExchangeSpot
     */
    @Test
    public void testExchangeSpot(){

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("giannisp@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onExchangeSpot();
        assertEquals(true,
                view.getToastMessage()=="You were too late!Exchange cancelled..." ||
                        view.getToastMessage()=="Your reservation was late!Exchange cancelled..." ||
                        view.getToastMessage()=="Exchange was successful!" );

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("dkefalas@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onExchangeSpot();
        assertEquals("Exchange Error",view.getErrorMessageTitle());

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onExchangeSpot();
        assertEquals("Exchange Error",view.getErrorMessageTitle());
    }

    /**
     * Έλεγχος της λειτουργίας ReportFalseSpot
     */
    @Test
    public void testReportFalseSpot(){

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("giannisp@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        for (int i =0; i < 10; i++){
            presenter.onReportFalseSpot();
        }
        assertEquals(10,view.getReportFalseSpotClicks());

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onReportFalseSpot();
        assertEquals("Report Error",view.getErrorMessageTitle());

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("dkefalas@gmail.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onReportFalseSpot();
        assertEquals("Report Error",view.getErrorMessageTitle());
    }

    /**
     * Έλεγχος της λειτουργίας ViewStatistics
     */
    @Test
    public void testViewStatistics(){

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());
        new AccountDAOMemory().addAuthorizedID(view.getAttachedUserID());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        for (int i =0; i < 10; i++){
            presenter.onViewStatistics();
        }
        assertEquals(10,view.getViewStatisticsClicks());

        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("panagiotis.g@example.com").getId());
        presenter = new HomepagePresenter(view,new AccountDAOMemory());
        presenter.onViewStatistics();
        assertEquals("Authorization Error",view.getErrorMessageTitle());
    }

}
