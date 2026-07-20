package classes.videoService;

public class Movie extends Video {
    private double rating;

    public Movie(String title, int duration, double rating) {
        super(title, duration);
        setRating(rating);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            this.rating = 0;
        }
        else {
            this.rating = rating;
        }
    }

    @Override
    public String getInfo() {
        return "Title: " + getTitle() + "\nDuration: " + getDuration() + "\nRating: " + getRating() + "\n----------------\n";
    }
}
