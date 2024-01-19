package gr.aueb.parkhub.viewtests.spotReservationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.domain.ParkedUser;
import gr.aueb.parkhub.domain.Time;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.memorydao.ReservationDAOMemory;
import gr.aueb.parkhub.memorydao.SpotsDAOMemory;
import gr.aueb.parkhub.views.spotReservation.SpotReservationPresenter;


/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SpotReservationPresenterTest {

    private Initializer data ;
    private SpotReservationPresenter presenter;
    private SpotReservationStub view ;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */
    @Before
    public void setUp(){
        data = new MemoryInitializer();
        data.prepareData();
        view = new SpotReservationStub();
        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("sifisxr@gmail.com").getId());
        presenter = new SpotReservationPresenter(view,new AccountDAOMemory(),new SpotsDAOMemory(),new ReservationDAOMemory());
    }

    /**
     * Έλεγχος της λειτουργίας back
     */
    @Test
    public void testBack(){

        for (int i =0; i < 10; i++){
            presenter.onBack();
        }

        assertEquals(10,view.getBackClicks());
    }

    /**
     * Έλεγχος της λειτουργίας apply
     */
    @Test
    public void testApply(){

        view.setTime(new Time(11,40));
        view.setRegion("Center");
        presenter.onApply();
        assertEquals("Region:CenterTime:11:40",view.getConstraint());
    }

    /**
     * Έλεγχος της λειτουργίας confirm
     */
    @Test
    public void testConfirm(){

        view.setParkingSpotID(1000);
        presenter.onConfirm();
        assertEquals("Reservation Error",view.getTitle());

        view.setParkingSpotID(((ParkedUser)
                (new AccountDAOMemory().findUserByEmail("dkefalas@gmail.com"))).getParkingSpot().getId());
        presenter.onConfirm();
        assertTrue(view.getToastMessage().equals("Waiting for other user response...") ||
                view.getToastMessage().equals("Your resevation was successfull!"));
    }



}
