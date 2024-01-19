package gr.aueb.parkhub.domain;

/**
 * @author Κεφαλάς Δημήτρης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class Rating{

    private final double rating;
    private final String comment;

    public Rating(double rating,String comment){
        this.rating = rating;
        this.comment = comment;
    }

    /**
     * Επιστρέφει την βαθμολογία της αξιολόγησης
     * @return η βαθμολογία
     */
    public double getRating() {
        return rating;
    }

    /**
     * Επιστρέφει τα σχόλια της αξιολόγησης
     * @return τα σχόλια
     */
    public String getComment() {
        return comment;
    }

}