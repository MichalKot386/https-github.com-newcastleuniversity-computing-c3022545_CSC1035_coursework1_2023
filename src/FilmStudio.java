import java.util.ArrayList;
import java.util.List;

public class FilmStudio {
    String studio_name;
    List<Film> films;

    public FilmStudio(String studio_name, List<Film> films) {
        this.studio_name = studio_name;
        this.films = new ArrayList<>();
    }


    public static void main(String[] args) {
        FilmStudio studio = new FilmStudio("Marvel");
        Film film = new Film("pacific", 2020, 90, 1300, "action");
                System.out.println(film.getLength());
        
    }
}