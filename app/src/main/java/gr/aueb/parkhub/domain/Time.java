package gr.aueb.parkhub.domain;
/**
 * @author Ιωάννης Πετρίδης
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2023-2024.
 *
 */
public class Time {

    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Copy constructor
     * @param other ένας χρόνος
     */
    public Time(Time other){
        this.hour = other.hour;
        this.minute = other.minute;
    }

    /**
     * Επιστρέφει την ώρα
     * @return η ώρα
     */
    public int getHour() {
        return hour;
    }

    /**
     * Θέτει την ώρα
     * @param hour  η ώρα
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Επιστρέφει τα λεπτά
     * @return τα λεπτά
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Επιστρέφει τα λεπτά
     * @param minute τα λεπτά
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * Ελέγχει την ισότητα δύο αντικειμένων τύπου time
     * @param o ένα αντικείμενο τύπου time
     * @return αν είναι ίσα τα αντικείμενα
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour && minute == time.minute;
    }

    /**
     * Επιστρέφει την συμβολοσειρά της κλάσης
     * @return η συμβολοσειρά της κλάσης
     */
    @Override
    public String toString() {
        return hour + ":" +  minute ;
    }

}