import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main application for the Data Analysis Mini-Project.
 *
 * 
 *  - Update the path to your dataset file ✔
 *  - Read the CSV file using Scanner ✔
 *  - Parse each row and extract the correct columns ✔
 *  - Construct Data objects from each row ✔
 *  - Store them in an array ✔
 *  - Write methods to analyze the dataset ✔
 *  - Print insights and answer your guiding question ✔
 *  - Add Javadoc comments for any methods you create ✔
 */
public class App {

    public static void main(String[] args) {

        //Update this with your CSV file path
        File file = new File("pokemon.csv");

        //Create an array of Data objects to store data
        Pokemon[] pokemonArray = new Pokemon[200]; // enough space
        int count = 0;


        // Read file using Scanner
        // - Skip header if needed
        // - Loop through rows
        // - Split each line by commas
        // - Convert text to numbers when needed
        // - Create new Data objects
        // - Add to your array
        try {
            Scanner scanner = new Scanner(file);

            // Skip header
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String name = parts[0];
                String type = parts[1];

                // Convert WITHOUT parseInt and WITHOUT trim
                int hp = stringToInt(parts[3]);
                int attack = stringToInt(parts[4]);
                int defense = stringToInt(parts[5]);
                int speed = stringToInt(parts[6]);

                // Create object
                Pokemon p = new Pokemon(name, type, hp, attack, defense, speed);

                // Add to array
                pokemonArray[count] = p;
                count++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


        //Call your analysis methods
        Pokemon strongest = findStrongestPokemon(pokemonArray, count);
        double averageAttack = calculateAverageAttack(pokemonArray, count);


        //Print insights
        // - Number of rows loaded
        // - Min, max, average, or any other findings
        // - Final answer to your guiding question
        System.out.println("Total Pokemon loaded: " + count);
        System.out.println("Average Attack: " + averageAttack);

        System.out.println("\nStrongest Pokemon:");
        System.out.println(strongest);


        // Add user interaction:
        // Ask the user what kind of analysis they want to see
    }


    /**
     * Converts a string to an integer WITHOUT using parseInt.
     * Assumes valid positive numbers.
     * @param str the number as a string
     * @return integer value
     */
    public static int stringToInt(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= '0' && c <= '9') { // ignore spaces or unexpected chars
                int digit = c - '0';
                result = result * 10 + digit;
            }
        }

        return result;
    }


    /**
     * Finds the Pokemon with the highest total stats.
     * @param arr array of Pokemon
     * @param size number of valid elements
     * @return strongest Pokemon
     */
    public static Pokemon findStrongestPokemon(Pokemon[] arr, int size) {
        Pokemon strongest = arr[0];

        for (int i = 1; i < size; i++) {
            if (arr[i].getTotalStats() > strongest.getTotalStats()) {
                strongest = arr[i];
            }
        }

        return strongest;
    }


    /**
     * Calculates average attack stat.
     * @param arr array of Pokemon
     * @param size number of valid elements
     * @return average attack
     */
    public static double calculateAverageAttack(Pokemon[] arr, int size) {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += arr[i].getAttack();
        }

        return (double) sum / size;
    }
}