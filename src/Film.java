public class Film {
    // Define class fields
    String title;
    int release_year;
    int length;
    int earnings;
    String genre;

    public Film(String title, int release_year, int length, int earnings, String genre) { // Constructor method for the Film class
        // Assign attributes to the film object
        this.title = title;
        this.release_year = release_year;
        this.length = length;
        this.earnings = earnings;
        this.genre = genre;
    }

    public static void main(String[] args) {
        Film film = new Film("pacific", 2020, 90, 1300, "action");
        System.out.println(film.length);
    }
    // Get methods
    public String getTitle() {
        return title;
    }
    public int getRelease_year() {
        return release_year;
    }
    public int getLength() {
        return length;
    }
    public int getEarnings() {
        return earnings;
    }
    public String getGenre() {
        return genre;
    }
}