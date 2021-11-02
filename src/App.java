import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        AsciiChars.printNumbers();
        AsciiChars.printLowerCase();
        AsciiChars.printUpperCase();

        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        // ask user if they want to continue the program
        System.out.println("Do you wish to continue to the interactive portion? (y/n)");
        String answer = scanner.nextLine();
        if (answer.equals("y") || answer.equals("yes")) {
            String playAgain;
            do {
                // ask user if they have a red car
                System.out.println("Do you have a red car? (y/n)");
                String answer2 = scanner.nextLine();

                // Ask the user the name of their favorite pet and check for correct input
                System.out.println("What is your favorite pet's name? (please use at lest 3 characters ;)");
                String petName = scanner.nextLine();
                while (!petName.matches("[a-zA-Z]+")) {
                    System.out.println("Please enter a valid name");
                    petName = scanner.nextLine();
                }

                // Ask the user the age of their favorite pet and check for correct input
                System.out.println("What is your favorite pet's age?");
                int petAge = Integer.parseInt(scanner.nextLine());
                while (petAge < 0) {
                    System.out.println("Please enter a positive number");
                    petAge = Integer.parseInt(scanner.nextLine());
                }

                // Ask the user what is their lucky number and check for correct input
                System.out.println("What is your lucky number?");
                int luckyNumber = Integer.parseInt(scanner.nextLine());
                while (luckyNumber < 0 || luckyNumber > 100) {
                    System.out.println("Please enter a number between 0 and 100");
                    Integer.parseInt(scanner.nextLine());
                }

                // Ask the user if they have a favorite quarterback? If so, ask what is their
                // jersey number and check for correct input
                System.out.println("Do you have a favorite quarterback? (y/n)");
                String answer3 = scanner.nextLine();
                int jerseyNumber = 1;
                if (answer3.equals("y") || answer3.equals("yes")) {
                    System.out.println("What is your favorite quarterback's jersey number?");
                    jerseyNumber = Integer.parseInt(scanner.nextLine());
                    while (jerseyNumber < 0 || jerseyNumber > 99) {
                        System.out.println("Invalid jersey number");
                        jerseyNumber = Integer.parseInt(scanner.nextLine());

                    }
                }

                // Ask what the user what the two-digit model year of their car is and check for
                // corrent input
                System.out.println("What is the two-digit model year of your car?");
                int modelYear = Integer.parseInt(scanner.nextLine());
                while (modelYear < 0 || modelYear > 99) {
                    System.out.println("Please enter a valid model year");
                    modelYear = Integer.parseInt(scanner.nextLine());
                }

                // Ask the user what is the first name of their favorite actor or actress and
                // check for correct input
                System.out.println("What is the first name of your favorite actor or actress?");
                String actorName = scanner.nextLine();
                while (!actorName.matches("[a-zA-Z]+")) {
                    System.out.println("Please enter a valid name");
                    actorName = scanner.nextLine();
                }

                // Ask the user to enter a number between 1 and 50 and check for correct input
                System.out.println("Please enter a number between 1 and 50");
                int number = Integer.parseInt(scanner.nextLine());
                while (number < 1 || number > 50) {
                    System.out.println("Please enter a valid number");
                    number = Integer.parseInt(scanner.nextLine());
                }

                // generate 3 random numbers between 1 and 65
                int randomNumber1 = (int) (Math.random() * 65) + 1;
                int randomNumber2 = (int) (Math.random() * 65) + 1;
                int randomNumber3 = (int) (Math.random() * 65) + 1;

                // a variable called "magicBall" that is assigned to luckyNumber or jerseyNumber
                // if a value for jerserNumber is available is given
                int magicBall = luckyNumber;
                if (answer3.equals("y") || answer3.equals("yes")) {
                    magicBall = jerseyNumber;
                }

                // times magicBall by a random number
                magicBall *= randomNumber1;

                // if magicBall is greater than 75, keep subtracting 75 from it untill it is
                // less than 75
                while (magicBall > 75) {
                    magicBall -= 75;
                }

                int powerBall[] = { 0, 0, 0, 0, 0 };

                // convert the 3rd letter of petName to a number
                powerBall[0] = petName.charAt(2) - '0';
                powerBall[0] = checkNumber(powerBall[0]);

                // powerBall2 is the sum of modelYear and luckyNumber
                powerBall[1] = modelYear + luckyNumber;
                powerBall[1] = checkNumber(powerBall[1]);

                // powerBall3 is the number the user entered subtracted by the second random
                // number
                powerBall[2] = number - randomNumber2;
                powerBall[2] = checkNumber(powerBall[2]);

                // powerBall4 is the sum of petAge and modelYear
                powerBall[3] = petAge + modelYear;
                powerBall[3] = checkNumber(powerBall[3]);

                // powerBall5 is the sum of jerseyNumber, petAge, and luckyNumber
                powerBall[4] = jerseyNumber + petAge + luckyNumber;
                powerBall[4] = checkNumber(powerBall[4]);

                // sort the powerBall array by descending order
                sortArray(powerBall);

                // check for duplicate numbers
                checkDuplicates(powerBall);

                // print out the powerball numbers
                System.out.println("Powerball numbers: " + powerBall[0] + " " + powerBall[1] + " " + powerBall[2] + " "
                        + powerBall[3] + " " + powerBall[4] + " Magic Ball: " + magicBall);

                // ask the user if they want to quit the program
                System.out.println("Do you wish to answer questions again to generate another set of numbers? (y/n)");
                playAgain = scanner.nextLine();
            } while (playAgain.equals("y") || playAgain.equals("yes"));

            System.out.println("Thank You and Goodbye!");

        } else {
            System.out.println("Goodbye! Please return later to complete the survey");
        }
        scanner.close();
    }

    public static class AsciiChars {

        public static void printNumbers() {
            for (int i = 48; i < 58; i++) {
                System.out.println(i + ": " + (char) i);
            }
        }

        public static void printLowerCase() {
            for (int i = 97; i < 123; i++) {
                System.out.println(i + ": " + (char) i);
            }
        }

        public static void printUpperCase() {
            for (int i = 65; i < 91; i++) {
                System.out.println(i + ": " + (char) i);
            }
        }
    }

    // a method that takes an array and sorts it
    public static void sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // a method that takes an array of integers and checks for duplicates
    public static void checkDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate found: " + arr[i]);
                    arr[i] = (int) (Math.random() * 65) + 1;
                }
            }
        }
    }

    // a function that checks if a number is greater than 65 or less than 0, and if
    // it is, add or subtract 65 until it is between 0 and 65
    public static int checkNumber(int number) {
        while (number > 65 || number < 0) {
            if (number > 65) {
                number -= 65;
            } else if (number < 0) {
                number += 65;
            }
        }
        return number;
    }
}
