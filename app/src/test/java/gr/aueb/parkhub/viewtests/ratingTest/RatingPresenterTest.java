package gr.aueb.parkhub.viewtests.ratingTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import gr.aueb.parkhub.domain.SearchingUser;
import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.memorydao.SpotsDAOMemory;
import gr.aueb.parkhub.views.rating.RatingPresenter;


/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class RatingPresenterTest {

    private Initializer data ;
    private RatingPresenter presenter;

    private RatingStub view ;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */
    @Before
    public void setUp(){
        data = new MemoryInitializer();
        data.prepareData();
        view = new RatingStub();
        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("giannisp@gmail.com").getId());
        presenter = new RatingPresenter(view,new AccountDAOMemory(),new SpotsDAOMemory());
    }

    /**
     * Έλεγχος της λειτουργίας back
     */
    @Test
    public void testBack(){

        SearchingUser user = (SearchingUser) new AccountDAOMemory().find(view.getAttachedUserID());
        presenter.onBack();

        assertFalse(user.getSpotReservation().getSpotexchange().isSuccess());
        assertFalse(user.getSpotReservation().getSpotexchange().isValidity());
        assertNull(new SpotsDAOMemory().find(user.getSpotReservation().getParkingSpot().getId()));

    }

    /**
     * Έλεγχος της λειτουργίας submit
     */
    @Test
    public void testSubmit(){

        SearchingUser user = (SearchingUser) new AccountDAOMemory().find(view.getAttachedUserID());
        presenter.onSubmit();

        assertFalse(user.getSpotReservation().getSpotexchange().isSuccess());
        assertFalse(user.getSpotReservation().getSpotexchange().isValidity());
        assertNull(new SpotsDAOMemory().find(user.getSpotReservation().getParkingSpot().getId()));

        assertEquals("Rating submited!",view.getToastMessage());
    }
}
