import java.util.Scanner;

public class ReportingIO {
    private static Reporting reporting = new Reporting();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean end_program = false;

        System.out.println("Welcome to the film studio interface program!");

        while (end_program != true) {
            System.out.println("1. Enter film studio data");
            System.out.println("2. Enter film data");
            System.out.println("3. List all film studios");
            System.out.println("4. List all films made by a given film studio");
            System.out.println("5. Provide a statistical report");
            System.out.println("6. Exit");

            System.out.println("Please enter the number of the option you would like to run: ");

            int user_input = input.nextInt();
            if (user_input == 1) {
                enterFilmStudio();
            }
            if (user_input == 2) {
                enterFilmData();

            }
            if (user_input == 3) {
                listFilmStudios();
            }
            if (user_input == 4) {
                listFilmsByStudio();
            }
            if (user_input == 5) {
                statisticalReport();

            }
            if (user_input == 6) {
                end_program = true;

            }
        }
    }

    public static void enterFilmStudio() {
        System.out.println("Please enter the studio name: ");
        String studio_name_input = input.nextLine();
        input.nextLine();
        FilmStudio new_film_studio = new FilmStudio(studio_name_input);
        reporting.addStudio(new_film_studio);
        System.out.println("You have successfully added a new film studio");
    }

    public static void enterFilmData() {
        System.out.println("Enter the film studios name: ");
        String studio_name = input.nextLine();
        input.nextLine();
        FilmStudio filmStudio = reporting.getStudio(studio_name);

        System.out.println("Enter the films title: ");
        String title = input.nextLine();
        System.out.println("Enter the year of release: ");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("Enter the runtime in minutes: ");
        int runtime = input.nextInt();
        input.nextLine();
        System.out.println("Enter the films box office earnings in pounds: ");
        int earnings = input.nextInt();
        input.nextLine();
        System.out.println("Enter the films genre: ");
        String genre = input.nextLine();
        Film film = new Film(title, year, runtime, earnings, genre);
        filmStudio.addFilm(film);

    }

    public static void listFilmStudios() {
        System.out.println(reporting.getStudios());
    }

    public static void listFilmsByStudio() {
        System.out.println("Please enter the studio name: ");
        String studio_name_input = input.nextLine();
        input.nextLine();
        System.out.println(reporting.getStudio(studio_name_input).getFilms());
    }

    public static void statisticalReport() {
        System.out.println("Enter a year to find out the studio with the largest box office earnings: ");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("Enter an amount of earnings to see which films fell short: ");
        int amount = input.nextInt();
        input.nextLine();
        System.out.println("The studio with the largest box office earnings in " +
                year + "was " + reporting.largestStudioAverageEarnings(year));
        System.out.println("The longest film ever made was " + reporting.longestFilmEverMade());
        System.out.println("A list of the films that fell short of the input amount:");
        for (Film films : reporting.allFilmsEarningsLessThan(amount)) {
            System.out.println(films);
        }
    }
}