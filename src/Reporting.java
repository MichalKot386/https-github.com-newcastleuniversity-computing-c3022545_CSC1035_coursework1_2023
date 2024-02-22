// Import required libraries
import java.util.ArrayList;
import java.util.List;

public class Reporting {
    // Define class field
    List<FilmStudio> studios;

    public Reporting() {
        // Assign attributes to Reporting object
        this.studios = new ArrayList<>();
    }


    public void addStudio(FilmStudio studio) { // Method to add a studio to the list of studios
        studios.add(studio);
    }

    public List<FilmStudio> getStudios() { // Method to get all studios
        return studios;
    }

    public FilmStudio getStudio(String studio_name) { // Method to get a specific studio
        FilmStudio studio = null;
        for (FilmStudio film : studios) { // Loop through the list of studios
            if (film.getStudio_name() == studio_name) { // Check if current studios name matches the input
                studio = film;
            }
        }
        return studio;
    }

    public Film longestFilmEverMade() { // Method to get the longest film made by any studio
        Film longestFilm = null;
        int longest = 0;
        for (FilmStudio film : studios) { // Loop through the list of studios
            if (film.longestFilm() != null && film.longestFilm().getLength() > longest) { //Check if current studios longest film does not equal null and if is longer than the current longest film
                longest = film.longestFilm().getLength(); // Set new longest length
                longestFilm = film.longestFilm(); // Set new longest film

            }
        }
        return longestFilm;
    }

    public FilmStudio largestStudioAverageEarnings(int year) { // Method to get the studio with the most earnings in a given year
        float highestEarnings = 0;
        FilmStudio currentHighestStudio = null;
        for (FilmStudio filmStudio : studios) { // Loop through list of studios
            if (filmStudio.averageEarnings(year) > highestEarnings) { // Check if current studios earnings are greater than the current highest earning studio
                highestEarnings = filmStudio.averageEarnings(year); // Set new value for highest earnings
                currentHighestStudio = filmStudio; // Set current studio to be the highest earned studio
            }
        }
        return currentHighestStudio;


    }
    public List<Film> allFilmsEarningsLessThan(float amount) { // Method to get all films which earned less than a given amount
        List<Film> filmsWithEarningsLessThan = new ArrayList<>(); // Create new list
        for (FilmStudio filmStudio : studios) { // Loop through the list of studios
            filmsWithEarningsLessThan.addAll(filmStudio.filmsLessThan(amount)); // Add film
        }
        return filmsWithEarningsLessThan;
    }
}