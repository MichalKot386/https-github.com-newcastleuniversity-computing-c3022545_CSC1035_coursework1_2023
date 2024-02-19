import java.util.ArrayList;
import java.util.List;

public class FilmStudio {
    String studio_name;
    List<Film> films;

    public FilmStudio(String studio_name) {
        this.studio_name = studio_name;
        this.films = new ArrayList<>();
    }
    public void addFilm(Film film) {
        films.add(film);
    }
    public String getStudio_name() {
        return studio_name;
    }
    public Film longestFilm() {
        Film longest_film = null;
        int longest = 0;
        for (Film film : films) {
            if (film.getLength() > longest) {
                longest = film.getLength();
                longest_film = film;
            }
        }
        return longest_film;
    }
    public float averageEarnings(int year) {
        float total = 0;
        int count = 0;
        for (Film film : films) {
            if (film.getRelease_year() == year) {
                total = total + film.getEarnings();
                count = count + 1;
            }
        }
        return total / count;
    }
    public List<Film> filmsLessThan(float amount) {
        List<Film> filmsLessThan = new ArrayList<>();
        for (Film film : films) {
            if (film.getEarnings() < amount) {
                filmsLessThan.add(film);
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