package griffith;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name; // Name of the playlist
    private List<Song> songs; // List to store songs in the playlist

    // Constructor to initialize the playlist with a name
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>(); // Initialize the list of songs
    }

    // Method to add a song to the playlist
    public void addSong(Song song) {
        songs.add(song);
    }

    // Method to remove a song from the playlist by title and artist
    public void removeSong(String title, String artist) {
        // Remove the song if it matches the title and artist (case insensitive)
        songs.removeIf(song -> song.getTitle().equalsIgnoreCase(title) && song.getArtist().equalsIgnoreCase(artist));
    }

    // Method to display details of the playlist
    public void displayPlaylistDetails() {
        // Print the playlist name, total duration, and number of songs
        System.out.println("Playlist: " + name + ", Duration: " + getTotalDuration() + ", Songs: " + songs.size());
        System.out.println("title, artist, duration");
        // Print details of each song in the playlist
        for (Song song : songs) {
            System.out.println(song.getTitle() + ", " + song.getArtist() + ", " + song.getDuration());
        }
    }

    // Method to search for songs by title or artist
    public void searchSongs(String searchTerm) {
        boolean found = false;
        // Search through the list of songs for matches
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) || 
                song.getArtist().toLowerCase().contains(searchTerm.toLowerCase())) {
                // Print the song details if a match is found
                System.out.println(song);
                found = true;
            }
        }
        // If no songs are found, print a message
        if (!found) {
            System.out.println("No songs found with the search term: " + searchTerm);
        }
    }

    // Method to export the playlist to a text file
    public void exportPlaylist() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            // Write the playlist details to the file
            writer.write("Playlist: " + name + ", Duration: " + getTotalDuration() + ", Songs: " + songs.size());
            writer.newLine();
            writer.write("title, artist, duration");
            writer.newLine();
            // Write each song's details to the file
            for (Song song : songs) {
                writer.write(song.getTitle() + ", " + song.getArtist() + ", " + song.getDuration());
                writer.newLine();
            }
            System.out.println("Playlist exported successfully.");
        } catch (IOException e) {
            // Print an error message if there is an issue with file operations
            System.out.println("An error occurred while exporting the playlist.");
        }
    }

    // Private method to calculate the total duration of the playlist
    private String getTotalDuration() {
        double totalMinutes = songs.stream().mapToDouble(Song::getDuration).sum();
        int hours = (int) totalMinutes / 60;
        int minutes = (int) totalMinutes % 60;
        int seconds = (int) ((totalMinutes - (hours * 60 + minutes)) * 60);
        // Return the duration in a formatted string
        return hours + "Hrs " + minutes + "m " + seconds + "secs";
    }
}
