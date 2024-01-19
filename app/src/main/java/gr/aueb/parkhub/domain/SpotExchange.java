package gr.aueb.parkhub.domain;

/**
 * @author Κεφαλάς Δημήτρης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class SpotExchange {

    private boolean success;
    private int min;
    private boolean validity;

    public SpotExchange() {
        this.min = 0;
    }

    /**
     * Επιστρέφει την επιτυχία της ανταλλαγής
     * @return η επιτυχία
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Θέτει την επιτυχία της ανταλλαγής
     * @param success η επιτυχία
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Επιστρέφει τα λεπτά καθυστέρησης
     * @return τα λεπτά
     */
    public int getMin() {
        return min;
    }

    /**
     * Θέτει τα λεπτά καθυστέρησης
     * @param min τα λεπτά
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Επιστρέφει την εγκυρότητα της κράτησης
     * @return την εγκυρότητα
     */
    public boolean isValidity() {
        return validity;
    }

    /**
     * Θέτει την εγκυρότητα της κράτησης
     * @param validity την εγκυρότητα
     */
    public void setValidity(boolean validity) {
        this.validity = validity;
    }

}