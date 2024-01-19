package gr.aueb.parkhub.viewtests.spotDeclarationTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

import gr.aueb.parkhub.dao.Initializer;
import gr.aueb.parkhub.memorydao.AccountDAOMemory;
import gr.aueb.parkhub.memorydao.MemoryInitializer;
import gr.aueb.parkhub.memorydao.SpotsDAOMemory;
import gr.aueb.parkhub.views.spotDeclaration.SpotDeclarationPresenter;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public class SpotDeclarationPresenterTest {

    private Initializer data ;
    private SpotDeclarationPresenter presenter;
    private SpotDeclarationStub view ;

    /**
     * Αρχικοποίηση των δεδομένων που θα χρειαστούμε για τους ελέγχους
     */
    @Before
    public void setUp(){
        data = new MemoryInitializer();
        data.prepareData();
        view = new SpotDeclarationStub();
        view.setAttachedUserID(new AccountDAOMemory().findUserByEmail("giannisp@gmail.com").getId());
        presenter = new SpotDeclarationPresenter(view,new AccountDAOMemory(),new SpotsDAOMemory());

    }

    /**
     * Έλεγχος της λειτουργίας declare
     */

    @Test
    public void DeclareTest(){

        view.setStreet("1");
        presenter.onDeclare();

        assertEquals("Please use only letters in the street text.",view.getErrorMessage());

        view.setStreet("Pathsiwn");
        view.setStNumber("Pathsiwn");
        presenter.onDeclare();
        assertEquals("Please use only numbers in the street number text.",view.getErrorMessage());

        view.setStreet("Pathsiwn");
        view.setStNumber("101");
        view.setCity("101");
        presenter.onDeclare();
        assertEquals("Please use only letters in the city text.",view.getErrorMessage());

        view.setStreet("Pathsiwn");
        view.setStNumber("101");
        view.setCity("Athens");
        view.setRegion("101");
        presenter.onDeclare();
        assertEquals("Please use only letters in the region text.",view.getErrorMessage());

        view.setStreet("Pathsiwn");
        view.setStNumber("101");
        view.setCity("Athens");
        view.setRegion("Kypseli");
        presenter.onDeclare();
    }

    /**
     * Έλεγχος της λειτουργίας back
     */
    @Test
    public void BackTest(){

        for (int i =0; i < 10; i++){
            presenter.onBack();
        }

        assertEquals(10,view.getBackClicks());
    }

}

