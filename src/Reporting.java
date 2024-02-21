import java.util.ArrayList;
import java.util.List;

public class Reporting {
    List<FilmStudio> studios;

    public Reporting() {
        this.studios = new ArrayList<>();
    }

    public void addStudio(FilmStudio studio) {
        studios.add(studio);
    }

    public Film longestFilmEverMade() {
        Film longestFilm = null;
        int longest = 0;
        for (FilmStudio film : studios) {
            if (film.longestFilm().getLength() > longest) {
                longest = film.longestFilm().getLength();
                longestFilm = film.longestFilm();

            }
        }
        return longestFilm;
    }

    public FilmStudio largestStudioAverageEarnings(int year) {
        float highestEarnings = 0;
        FilmStudio currentHighestStudio = null;
        for (FilmStudio filmStudio : studios) {
            if (filmStudio.averageEarnings(year) > highestEarnings) {
                highestEarnings = filmStudio.averageEarnings(year);
                currentHighestStudio = filmStudio;
            }
        }
        return currentHighestStudio;


    }
    public List<Film> allFilmsEarningsLessThan(float amount) {
        List<Film> filmsWithEarningsLessThan = new ArrayList<>();
        for (FilmStudio filmStudio : studios) {
            filmsWithEarningsLessThan.addAll(filmStudio.filmsLessThan(amount));
        }
        return filmsWithEarningsLessThan;
    }
}