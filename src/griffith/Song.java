package griffith;

public class Song {
    private String title; // Title of the song
    private String artist; // Artist of the song
    private double duration; // Duration of the song in minutes

    // Constructor to initialize a Song object with title, artist, and duration
    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    // Getter for the song title
    public String getTitle() {
        return title;
    }

    // Setter for the song title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the song artist
    public String getArtist() {
        return artist;
    }

    // Setter for the song artist
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Getter for the song duration
    public double getDuration() {
        return duration;
    }

    // Setter for the song duration
    public void setDuration(double duration) {
        this.duration = duration;
    }

    // Override the toString() method to return a string representation of the song
    @Override
    public String toString() {
        return title + ", " + artist + ", " + duration;
    }
}
