// Importing required libraries
import java.util.Scanner;
import java.util.List;

public class ReportingIO {
    // Defining private fields
    private static Reporting reporting = new Reporting(); // Instantiate 'reporting' object
    private static Scanner input = new Scanner(System.in); // Scanner to read user inputs

    public static void main(String[] args) {
        boolean end_program = false;

        System.out.println("Welcome to the film studio interface program!");

        while (end_program != true) { // While loop that breaks when condition is true
            System.out.println("1. Enter film studio data");
            System.out.println("2. Enter film data");
            System.out.println("3. List all film studios");
            System.out.println("4. List all films made by a given film studio");
            System.out.println("5. Provide a statistical report");
            System.out.println("6. Exit");

            System.out.println("Please enter the number of the option you would like to run: ");

            // User choices
            int user_input = input.nextInt(); // User input
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
        String studio_name_input = input.nextLine(); // User input
        input.nextLine();
        FilmStudio new_film_studio = new FilmStudio(studio_name_input); // Instantiate FilmStudio object
        reporting.addStudio(new_film_studio); // Add object to a list of objects
        System.out.println("You have successfully added a new film studio");
    }

    public static void enterFilmData() {
        System.out.println("Enter the film studios name: ");
        String studio_name = input.nextLine(); // User input
        input.nextLine();
        FilmStudio filmStudio = reporting.getStudio(studio_name);

        System.out.println("Enter the films title: ");
        String title = input.nextLine(); // User input
        System.out.println("Enter the year of release: ");
        int year = input.nextInt(); // User input
        input.nextLine();
        System.out.println("Enter the runtime in minutes: ");
        int runtime = input.nextInt(); // User input
        input.nextLine();
        System.out.println("Enter the films box office earnings in pounds: ");
        int earnings = input.nextInt(); // User input
        input.nextLine();
        System.out.println("Enter the films genre: ");
        String genre = input.nextLine(); // User input
        Film film = new Film(title, year, runtime, earnings, genre); // Instantiate new film object
        filmStudio.addFilm(film); // Add film a list of films

    }

    public static void listFilmStudios() { // Method to list all film studios
        System.out.println(reporting.getStudios());
        List<FilmStudio> studios = reporting.getStudios(); // Create new list
        for (FilmStudio studio : studios) { // Loop through the list
            System.out.println(studio);
            System.out.println(studio.getStudio_name());
        }
    }

    public static void listFilmsByStudio() { // Method to list all films made by a given studio
        System.out.println("Please enter the studio name: ");
        String studio_name_input = input.nextLine(); // User input
        input.nextLine();
        for (Film film : reporting.getStudio(studio_name_input).getFilms()) {  // Loop through list
            System.out.println(film.getTitle());
        }
    }

    public static void statisticalReport() { // Method to generate a statistical report on the film studios
        System.out.println("Enter a year to find out the studio with the largest box office earnings: ");
        int year = input.nextInt(); // User input
        input.nextLine();
        System.out.println("Enter an amount of earnings to see which films fell short: ");
        int amount = input.nextInt(); // User input
        input.nextLine();
        System.out.println("The studio with the largest box office earnings in " +
                year + "was " + reporting.largestStudioAverageEarnings(year).getStudio_name());
        System.out.println("The longest film ever made was " + reporting.longestFilmEverMade().getTitle());
        System.out.println("A list of the films that fell short of the input amount:");
        for (Film x : reporting.allFilmsEarningsLessThan(amount)) { // Loop through a list
            System.out.println(x.getTitle());
        }
    }
}