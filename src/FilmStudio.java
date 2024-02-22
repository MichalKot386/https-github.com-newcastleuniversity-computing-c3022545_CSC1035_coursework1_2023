// Import required libraries
import java.util.ArrayList;
import java.util.List;

public class FilmStudio {
    // Define class fields
    String studio_name;
    List<Film> films;

    public FilmStudio(String studio_name) { // Constructor method for FilmStudio class
        // Assign attributes to object
        this.studio_name = studio_name;
        this.films = new ArrayList<>();
    }
    public void addFilm(Film film) { // Method to add a Film object to a list

        films.add(film); // Add film to list
    }
    public List<Film> getFilms() { // Method to get the list of films
        return films;
    }
    public void setStudio_name(String studio_name) {
        this.studio_name = studio_name;
    }
    public String getStudio_name() { // Method to get studio name

        return studio_name;
    }
    public Film longestFilm() { // Method to find the longest film the studio has produced
        Film longest_film = null;
        int longest = 0;
        for (Film film : films) { // Loop through the list of films
            if (film.getLength() > longest) { // Check if the film length is longer than the current longest film
                longest = film.getLength(); // Set current films length to be the longest
                longest_film = film;
            }
        }
        return longest_film;
    }
    public float averageEarnings(int year) { // Method to calculate the average earnings a studio makes in a given year
        float total = 0;
        int count = 0;
        for (Film film : films) { // Loop through the list of films
            if (film.getRelease_year() == year) { // Check if the current film was created in the given year
                total = total + film.getEarnings(); // Add its earnings to the total
                count = count + 1; // Increment film count by 1
            }
        }
        return total / count; // Calculate the average
    }
    public List<Film> filmsLessThan(float amount) { // Method to find films with earnings less than a given amount
        List<Film> filmsLessThan = new ArrayList<>(); // Create new list
        for (Film film : films) { // Loop through list of films
            if (film.getEarnings() < amount) { // Check if the current films earnings are less than the given amount
                filmsLessThan.add(film); // Add it to the new list
            }
        }
        return filmsLessThan;
    }


        public static void main(String[] args) {
        FilmStudio studio = new FilmStudio("Marvel");
        Film film = new Film("pacific", 2020, 90, 1300, "action");
                System.out.println(film.getLength());
        
    }
}