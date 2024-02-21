import java.util.Scanner;

public class ReportingIO {
    boolean end_program = false

    public void main(String[] args) {
        while (end_program != true) {
            System.out.println("Welcome to the film studio interface program!");
            System.out.println("1. Enter film studio data");
            System.out.println("2. Enter film data");
            System.out.println("3. List all film studios");
            System.out.println("4. List all films made by a given film studio");
            System.out.println("5. Provide a statistical report");
            System.out.println("6. Exit");

            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the number of the option you would like run: ");

            int user_input = input.nextInt();
            if (user_input == 1) {
                System.out.println("Please enter the studio name: ");
                String studio_name_input = input.nextLine();
                FilmStudio new_film_studio = new FilmStudio(studio_name_input);
            }
        }
    }
}
