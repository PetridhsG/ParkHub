package gr.aueb.parkhub.dao;

import gr.aueb.parkhub.domain.*;

/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */

public abstract class Initializer {

    /**
     * Διαγράφει τα αποθηκευμένα δεδομένα.
     */
    protected abstract void eraseData();

    /**
     * Εισάγει τα δοκιμαστικά δεδομένα.
     */
    public void prepareData() {
        eraseData();

        AccountDAO accountDAO = getAccountDAO();

        accountDAO.save(new User("Dimitrios", "Papadopoulos", "dimitrios.p@example.com", "pass123", "6912345678",
                new Vehicle("Blue", 4.5, "Toyota", "Corolla", "XAB 1234")));

        accountDAO.save(new User("Eleftheria", "Tsakalidou", "eleftheria.t@example.com", "secure456", "6913456789",
                new Vehicle("Silver", 3.0, "Honda", "Civic", "XCD 5678")));

        accountDAO.save(new User("Katerina", "Papandreou", "katerina.p@example.com", "mypass789", "6914567890",
                new Vehicle("Red", 3.3, "Ford", "Focus", "XEF 9012")));

        accountDAO.save(new User("Andreas", "Konstantinidis", "andreas.k@example.com", "andreaspass", "6915678901",
                new Vehicle("White", 2.5, "Volkswagen", "Golf", "XGH 3456")));

        accountDAO.save(new User("Sophia", "Ioannou", "sophia.i@example.com", "s0phiaPass", "6916789012",
                new Vehicle("Black", 4.0, "BMW", "3 Series", "XIJ 7890")));

        accountDAO.save(new User("Panagiotis", "Georgiou", "panagiotis.g@example.com", "p@nPass!", "6917890123",
                new Vehicle("Silver", 3.5, "Mercedes-Benz", "A-Class", "XKL 1234")));

        accountDAO.save(new User("Maria", "Papadopoulou", "maria.p@example.com", "mariaPass22", "6918901234",
                new Vehicle("Blue", 3.2, "Audi", "A4", "XLM 5678")));

        accountDAO.save(new ParkedUser("Dimitris","Kefalas","dkefalas@gmail.com","qwerty12","6994413550",
                new Vehicle("Yellow",1.5,"Fiat","cinquecento","ZNZ6969")));

        accountDAO.save(new User("Sifis","Xristoulakhs","sifisxr@gmail.com","12345","6984137274",
                new Vehicle("Black",3.5,"Toyota","Hilux","XNK6969")));

        accountDAO.save(new SearchingUser("Giannis","Petridhs","giannisp@gmail.com","qwerty12","6985971897",
                new Vehicle("Black",3.0,"Hyundai","I30","KBK9090")));

        accountDAO.findUserByEmail("dkefalas@gmail.com").addRating(new Rating(4.5,"Arghse poly.Mhn ton empisteyeste!"));
        accountDAO.findUserByEmail("dkefalas@gmail.com").addRating(new Rating(3.0,"Aparadektos!"));

        accountDAO.findUserByEmail("giannisp@gmail.com").addRating(new Rating(2.5,"Arghse arketa!"));
        accountDAO.findUserByEmail("giannisp@gmail.com").addRating(new Rating(5.0,"Aparadektos!"));

        accountDAO.findUserByEmail("sifisxr@gmail.com").addRating(new Rating(0.5,"Den emfanisthke pote!"));
        accountDAO.findUserByEmail("sifisxr@gmail.com").addRating(new Rating(1.0,"Dhlwse lathos dieythinsi!"));

        accountDAO.findUserByEmail("maria.p@example.com").addRating(new Rating(2.5,"Arghse poly"));
        accountDAO.findUserByEmail("maria.p@example.com").addRating(new Rating(1.0,"Dhlwse lathos wra!"));

        accountDAO.findUserByEmail("panagiotis.g@example.com").addRating(new Rating(2.0, "Apogoiteysh, problimata me tin topothesia."));
        accountDAO.findUserByEmail("panagiotis.g@example.com").addRating(new Rating(1.5, "Dysaresti empeiria."));

        accountDAO.findUserByEmail("sophia.i@example.com").addRating(new Rating(1.0, "Kaki exypiretisi, o idioktitis den itan diathesimos."));
        accountDAO.findUserByEmail("sophia.i@example.com").addRating(new Rating(1.5, "Kaki topothesia, problimata me tin asfaleia."));

        accountDAO.findUserByEmail("andreas.k@example.com").addRating(new Rating(1.5, "Dysaresti synergasia, polles ateleies."));
        accountDAO.findUserByEmail("andreas.k@example.com").addRating(new Rating(1.5, "Den tha ton sinistousa."));

        SpotsDAO spotsDAO = getSpotsDAO();

        spotsDAO.save(new ParkingSpot(new Time(11, 10),new Address("Panepistimiou Street", 15, "Athens", "Center"),
                accountDAO.findUserByEmail("panagiotis.g@example.com")));

        ParkingSpot ps = new ParkingSpot(new Time(12, 30),new Address("Syntagma Square", 1, "Athens", "Center"),
                accountDAO.findUserByEmail("dkefalas@gmail.com"));
        spotsDAO.save(ps);

        spotsDAO.save(new ParkingSpot(new Time(12, 45),new Address("Mitropoleos Street", 24, "Athens", "Center"),
                accountDAO.findUserByEmail("sophia.i@example.com")));

        spotsDAO.save(new ParkingSpot(new Time(13, 20),new Address("Stadiou Street", 10, "Athens", "Center"),
                accountDAO.findUserByEmail("andreas.k@example.com")));

        spotsDAO.save(new ParkingSpot(new Time(12, 15),new Address("Kolokotroni Street", 8, "Athens", "Peristeri"),
                accountDAO.findUserByEmail("katerina.p@example.com")));

        spotsDAO.save(new ParkingSpot(new Time(12, 30),new Address("Karaiskakh", 2, "Athens", "Peristeri"),
                accountDAO.findUserByEmail("eleftheria.t@example.com")));

        ReservationsDAO reservationsDAO = getReservationsDAO();

        ((ParkedUser)accountDAO.findUserByEmail("dkefalas@gmail.com")).setParkingSpot(ps);

        SpotReservation sr = new SpotReservation(new Time(12,45),
                ((ParkedUser)accountDAO.findUserByEmail("dkefalas@gmail.com")).getParkingSpot(), new SpotExchange());
        reservationsDAO.save(sr);
        ((SearchingUser)accountDAO.findUserByEmail("giannisp@gmail.com")).setSpotReservation(sr);

    }

    /**
     * Επιστρέφει το DAO των χρηστών
     * @return Το DAO των χρηστών
     */
    public abstract AccountDAO getAccountDAO();

    /**
     * Επιστρέφει το DAO των κρατήσεων
     * @return Το DAO των κρατήσεων
     */
    public abstract ReservationsDAO getReservationsDAO();

    /**
     * Επιστρέφει το DAO των θέσεων
     * @return Το DAO των θέσεων
     */
    public abstract SpotsDAO getSpotsDAO();
}
