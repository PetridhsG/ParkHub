package gr.aueb.parkhub.daotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.parkhub.domain.*;
import gr.aueb.parkhub.memorydao.*;
import gr.aueb.parkhub.dao.*;


/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */


public class DAOTest {

    private AccountDAO accountDAO;
    private SpotsDAO spotsDAO;
    private ReservationsDAO reservationsDAO;

    /**
     * Αρχικοποιήση των δεδομένων και DAO
     * που θα χρησιμοποιήσουμε για τα tests
     */
    @Before
    public void setUp(){
        Initializer data = new MemoryInitializer();
        data.prepareData();
        accountDAO = new AccountDAOMemory();
        spotsDAO = new SpotsDAOMemory();
        reservationsDAO = new ReservationDAOMemory();
    }

    /**
     * Έλεγχος της κλάσης AccountDAO
     */
    @Test
    public void accountDAOTest(){
        accountDAO.addAuthorizedID(10);
        assertTrue(accountDAO.authorized(10));
        assertEquals("Giannis",accountDAO.find(accountDAO.findUserByEmail("giannisp@gmail.com").getId()).getName());
        assertNull(accountDAO.find(10900));

        User user = new User("Iwannhs","Petridhs","giannispetridakos@gmail.com","qwerty12","6987043290",
                new Vehicle("Black",4.5,"BMW","X8","KBK6540"));
        accountDAO.save(user);
        assertEquals("Iwannhs",accountDAO.findUserByEmail("giannispetridakos@gmail.com").getName());
        accountDAO.delete(user);
        assertNull(accountDAO.findUserByEmail("giannispetridakos@gmail.com"));

    }


    /**
     * Έλεγχος της κλάσης SpotsDAO
     */
    @Test
    public void spotsDAOTest(){
        assertEquals("Syntagma Square", spotsDAO.find(((ParkedUser)accountDAO.findUserByEmail("dkefalas@gmail.com")).
                getParkingSpot().getId()).getAddress().getStreet());
        assertNull(spotsDAO.find(10900));

        ParkingSpot ps = new ParkingSpot(new Time(11,40),
                new Address("Omonoias",10,"Athens","Center"),
                accountDAO.find(9));
        spotsDAO.save(ps);
        assertEquals("Omonoias",spotsDAO.find(ps.getId()).getAddress().getStreet());
        spotsDAO.delete(ps);
        assertNull(spotsDAO.find(ps.getId()));
    }

/*
    /**
     * Έλεγχος της κλάσης ReservationsDAO
     */

    @Test
    public void reservationsDAOTest(){
        assertEquals("Dimitris",reservationsDAO.find(((SearchingUser)accountDAO.findUserByEmail("giannisp@gmail.com"))
                .getSpotReservation().getId()).getParkingSpot().getUser().getName());
        assertNull(reservationsDAO.find(109));

        SpotReservation sr = new SpotReservation(new Time(11,50),new ParkingSpot(new Time(11,40),
                new Address("Omonoia",10,"Athens","Center"),
                accountDAO.find(9)),new SpotExchange());
        reservationsDAO.save(sr);
        assertEquals("Omonoia",reservationsDAO.find(sr.getId()).getParkingSpot().getAddress().getStreet());
        reservationsDAO.delete(sr);
        assertNull( reservationsDAO.find(sr.getId()));
    }

    /**
     * Έλεγχος της κλάσης Initializer
     */


}
