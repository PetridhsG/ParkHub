

    public class Rating{

        private final double rating;
        private final String comment;

        public Rating(double rating,String comment){
            this.rating = rating;
            this.comment = comment;
        }
        public double getRating() {
            return rating;
        }

        public String getComment() {
            return comment;
        }


    }