package griffith;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        // Initialize a Playlist object (null initially)
        Playlist playlist = null;

        // Infinite loop to display menu and handle user options
        while (true) {
            // Display menu options to the user
            System.out.println("Select an option:");
            System.out.println("1. Create new playlist");
            System.out.println("2. Add new song to playlist");
            System.out.println("3. Remove song from playlist");
            System.out.println("4. Show playlist details");
            System.out.println("5. Search for song");
            System.out.println("6. Export playlist");
            System.out.println("7. Exit");

            // Read user input for the selected option
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left after nextInt()

            // Handle user option using a switch statement
            switch (option) {
                case 1:
                    // Create a new playlist
                    System.out.print("Enter playlist name: ");
                    String name = scanner.nextLine();
                    playlist = new Playlist(name);
                    break;
                case 2:
                    // Add a new song to the playlist
                    if (playlist != null) {
                        System.out.print("Enter song title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter song artist: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter song duration (in minutes): ");
                        double duration = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character left after nextDouble()
                        // Add the new song to the playlist
                        playlist.addSong(new Song(title, artist, duration));
                    } else {
                        System.out.println("No playlist created.");
                    }
                    break;
                case 3:
                    // Remove a song from the playlist
                    if (playlist != null) {
                        System.out.print("Enter song title to remove: ");
                        String removeTitle = scanner.nextLine();
                        System.out.print("Enter song artist to remove: ");
                        String removeArtist = scanner.nextLine();
                        // Remove the song from the playlist
                        playlist.removeSong(removeTitle, removeArtist);
                    } else {
                        System.out.println("No playlist created.");
                    }
                    break;
                case 4:
                    // Show details of the playlist
                    if (playlist != null) {
                        playlist.displayPlaylistDetails();
                    } else {
                        System.out.println("No playlist created.");
                    }
                    break;
                case 5:
                    // Search for a song in the playlist
                    if (playlist != null) {
                        System.out.print("Enter search term: ");
                        String searchTerm = scanner.nextLine();
                        // Search for songs matching the search term
                        playlist.searchSongs(searchTerm);
                    } else {
                        System.out.println("No playlist created.");
                    }
                    break;
                case 6:
                    // Export the playlist
                    if (playlist != null) {
                        playlist.exportPlaylist();
                    } else {
                        System.out.println("No playlist created.");
                    }
                    break;
                case 7:
                    // Exit the application
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the loop and end the program
                default:
                    // Handle invalid menu option
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
