package classes.videoService;

public class TvSeries extends Video {
    private int episodes;

    public TvSeries(String title, int duration, int episodes) {
        super(title, duration);
        setEpisodes(episodes);
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        if (episodes < 1) {
            this.episodes = 1;
        }
        else {
            this.episodes = episodes;
        }
    }

    @Override
    public String getInfo() {
        return "Title: " + getTitle() + "\nDuration: " + getDuration() + "\nEpisodes: " + getEpisodes() + "\n----------------\n";
    }
}
