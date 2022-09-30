/*
* This program finds the length of a board foot
* given width and height
*
* @author  Aidan Lalonde-Novales
* @version 1.0
* @since   2020-09-30
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a Mean and Median Calculator.
*/

final class Statistics {

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Statistics() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * This function calculates the mean (average) value of a set.
    *
    * @param numberArray Array containing the set.txt file
    * @param quantity The amount of numbers in the array
    * @return mean The average of all the numbers
    */
    public static float meanCalculation(
        final Integer[] numberArray, final int quantity) {
        float mean = 0;
        for (int counter : numberArray) {
            mean += counter;
        }
        mean /= quantity;
        return mean;
    }

    /**
    * This function calculates the median (middle number) in a set.
    *
    * @param numberArray Array containing the set.txt file
    * @param quantity The amount of numbers in the array
    * @return median The middle value of all the numbers
    */
    public static float medianCalculation(
        final Integer[] numberArray, final int quantity) {
        float median = 0;

        Arrays.sort(numberArray);
        if (quantity % 2 == 0) {
            median = (numberArray[(int) (quantity / 2)]
                + numberArray[(int) ((quantity - 1) / 2)]) / 2;
        } else {
            median = numberArray[(int) ((quantity - 1) / 2)];
        }
        return median;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {

        // Initialize Variables
        Integer temp;
        final ArrayList<Integer> textArray = new ArrayList<Integer>();
        final Path filePath = Paths.get("./", args[0]);
        final Charset charset = Charset.forName("UTF-8");
        final float mean;
        final float median;
        final Integer[] numberArray;

        System.out.println(
            "This program calculates the means and media from a txt file."
        );
        System.out.println(
            "The current file being used is " + filePath + ".\n"
        );

        // Append the txt file to a list, verify input
        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                temp = Integer.parseInt(line);
                textArray.add(temp);
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }

        // Process
        numberArray = textArray.toArray(new Integer[0]);
        final int quantity = numberArray.length;

        mean = meanCalculation(numberArray, quantity);
        median = medianCalculation(numberArray, quantity);

        // Output
        System.out.println("The mean is " + mean);
        System.out.println("The median is " + median);

        System.out.println("\nDone.");
    }
}
