import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Athlete> athletes = new ArrayList<>();

        // Using a loop to continuously ask for user input
        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Enter athlete name or press 's' to show the list of athletes:");
            String name = scanner.nextLine();
            // If the user enters 's', break the loop
            if (name.equalsIgnoreCase("s")) {
                break;
            }
            // Checking if the name is empty
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty. Please input a valid name.");
                continue;
            }
            // Checking if the name is a number
            try {
                Double.parseDouble(name);
                System.out.println("Name cannot be a number. Please input a valid name.");
            } catch (NumberFormatException e) {
            }

            // Asking for the training plan
            System.out.println("Enter training plan (Beginner, Intermediate, Elite):");
            String trainingPlan = scanner.nextLine();
            // Checking if the training plan is valid
            while (!(trainingPlan.equalsIgnoreCase("Beginner") || trainingPlan.equalsIgnoreCase("Intermediate") || trainingPlan.equalsIgnoreCase("Elite"))) {
                System.out.println("Invalid input. Please enter Beginner, Intermediate, or Elite:");
                trainingPlan = scanner.nextLine();
            }

            // Asking for the current weight
            System.out.println("Enter current weight:");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next();
            }
            double currentWeight = scanner.nextDouble();

            // Asking for the weight category
            System.out.println("Enter weight category (Heavyweight, Light-Heavyweight, Middleweight, Light-Middleweight, Lightweight, Flyweight):");
            scanner.nextLine();  // consume newline left-over
            String weightCategory = scanner.nextLine();
            // Checking if the weight category is valid
            while (!(weightCategory.equalsIgnoreCase("Heavyweight") || weightCategory.equalsIgnoreCase("Light-Heavyweight") || weightCategory.equalsIgnoreCase("Middleweight") || weightCategory.equalsIgnoreCase("Light-Middleweight") || weightCategory.equalsIgnoreCase("Lightweight") || weightCategory.equalsIgnoreCase("Flyweight"))) {
                System.out.println("Invalid input. Please enter Heavyweight, Light-Heavyweight, Middleweight, Light-Middleweight, Lightweight, or Flyweight:");
                weightCategory = scanner.nextLine();
            }
            int competitions = 0;
            // If the athlete is not a beginner, ask for the number of competitions
            if (!trainingPlan.equalsIgnoreCase ("Beginner")){
                System.out.println("Enter number of competitions");
                while (!scanner.hasNextInt()){
                    System.out.println("Invalid input. Please enter a number");
                    scanner.next();
                }
                competitions = scanner.nextInt();
                while (competitions > 2) {
                    System.out.println("Invalid input. The number of competitions are limited to 2 competitions every month.");
                    competitions = scanner.nextInt();
                }
                scanner.nextLine();   // consume newline left-over
            }

            // Asking for coaching hours
            System.out.println("Enter coaching hours:");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next();
            }
            int coachingHours = scanner.nextInt();
            // Checking if coaching hours are within the limit
            while (coachingHours > 20) {
                System.out.println("Invalid input. The maximum number of coaching hours is 20. Please enter a number:");
                coachingHours = scanner.nextInt();
            }
            scanner.nextLine();   // consume newline left-over


            // Creating an Athlete object with the provided details and adding it to the ArrayList
            Athlete athlete = new Athlete(name, trainingPlan, currentWeight, weightCategory, competitions, coachingHours);
            athletes.add(athlete);
        }


            Athlete athleteOne = new Athlete("Alex", "Intermediate", 98.5, "Light-heavyweight", 2, 5);
            Athlete athleteTwo = new Athlete("Bob", "Elite", 110.6, "Heavyweight", 3,2 );
            Athlete athleteThree = new Athlete("Charlie", "Elite", 96.4, "Light-heavyweight", 1,1 );
            Athlete athleteFour = new Athlete("Danny", "Beginner", 60.5, "Flyweight", 0,1 );
            Athlete athleteFive = new Athlete("Edward", "Intermediate", 105.7, "Heavyweight", 2,1 );
            Athlete athleteSix = new Athlete("Frank", "Intermediate", 86.2, "Middleweight", 1,1 );

            athletes.add(athleteOne);
            athletes.add(athleteTwo);
            athletes.add(athleteThree);
            athletes.add(athleteFour);
            athletes.add(athleteFive);
            athletes.add(athleteSix);


            for (Athlete athlete : athletes) {
                athlete.displayCosts();
            }
        }
    }

