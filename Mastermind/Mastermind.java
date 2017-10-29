/*
 Daniel Saltz
 Mastermind
 8/7/15
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Mastermind {
    private static int numTokens;
    private static String[] colors;
    private static boolean[] booleanArray;
    private static String[][] guessTable;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        initializeVariables();
        makeGuess();
        scanner.close();
    }

    public static void newGame() {
        System.out.println("New game? (enter yes or no)");
        String input = scanner.next().toLowerCase();
        boolean validResponse = input.equals("yes") || input.equals("no");

        while (!validResponse) {
            System.out.println("\nPlease enter a valid response");
            input = scanner.next().toLowerCase();
        }

        if (input.equals("yes")){
            initializeVariables();
            makeGuess();
        } else {
            return;
        }
    }

    public static void initializeVariables() {
        System.out.println("\nStarting Game: \n");
        colors = getColors();
        numTokens = getNumTokens();
        booleanArray = createBooleanArray();
        String[][] answerTable = new String[booleanArray.length][numTokens];
        guessTable = createTable(answerTable,colors,numTokens);
    }

    private static boolean checkBooleanArray() {
        int count = 0;
        String[] currentWinningGuess = {};
        for (int i = 0; i < booleanArray.length; i++) {
            if (booleanArray[i]) {
                count++;
                currentWinningGuess = guessTable[i];
            }
            if (count > 1) { // more than one possible combination
                break;
            }
        }
        if (count == 1) { // found combination
            displayWinningMessage(currentWinningGuess);
            return true;
        }
        return false;
    }

    public static void displayWinningMessage(String[] winningCombination) {
        System.out.print("\nFound your code!\nYour code is: ");
        for (int i = 0; i < winningCombination.length; i++) {
            System.out.print(winningCombination[i] + " ");
        }
        System.out.println("\n\n");
    }

    private static void makeGuess() {
        int index = getRandomIndexToGuess();
        String [] guess = guessTable[index];

        System.out.print("My guess is ");
        for (int y = 0; y < guess.length; y++) {
            System.out.print(guess[y]+" ");
        }

        System.out.println("\nHow many guesses had the correct color?");
        int correctColors = scanner.nextInt();
        while (correctColors > numTokens) {
            System.out.println("You have entered invalid input. Please try again.");
            correctColors = scanner.nextInt();
        }

        refineBooleanArrayBasedOnColors(guess,correctColors);
        if (checkBooleanArray()) {
            newGame();
        } else {
            System.out.println("How many guesses had the correct color in the correct location?");
            int correctLocation = scanner.nextInt();
            while (correctLocation > numTokens) {
                System.out.println("You have entered invalid input. Please try again.");
                correctLocation = scanner.nextInt();
            }
            if (correctLocation == guess.length) {
                displayWinningMessage(guess);
                newGame();
            } else {
                booleanArray[index] = false;
                refineBooleanArrayBasedOnLocation(guess,correctLocation);
                if (checkBooleanArray()) {
                    newGame();
                } else {
                    makeGuess();
                }
            }
        }
    }

    public static int getRandomIndexToGuess() {
        List<Integer> listOfPossibleIndices = new ArrayList<Integer>();
        for (int i = 0; i < booleanArray.length; i++) {
            if (booleanArray[i]) {
                listOfPossibleIndices.add(i);
            }
        }
        Random random = new Random();
        int selectedIndex = listOfPossibleIndices.get(random.nextInt(listOfPossibleIndices.size()));
        return selectedIndex;
    }

    private static void refineBooleanArrayBasedOnColors(String[] guessed, int correctColor) {
        Map<String,AtomicInteger> currentColorMap = createColorMap(guessed); // maps every color to the number of times it was guessed
        for (int i = 0; i < guessTable.length; i++) {
            if (!booleanArray[i]) { // skipping over impossible rows
                continue;
            }

            // checking for number of elements with with the same color
            List<String> listOfCurrentRow = Arrays.asList(guessTable[i]);
            int sameColor = 0;
            for (int x = 0; x < colors.length; x++) {
                int numOfColorInRow = Collections.frequency(listOfCurrentRow,colors[x]);
                int numOfColorInGuess = 0;
                if (currentColorMap.get(colors[x]) != null) {
                    numOfColorInGuess = currentColorMap.get(colors[x]).intValue();
                }
                if (numOfColorInRow >= numOfColorInGuess) {
                    sameColor += numOfColorInGuess;
                } else {
                    sameColor += numOfColorInRow;
                }
            }

            if (sameColor < correctColor) {
                booleanArray[i] = false;
            }
        }
    }

    private static void refineBooleanArrayBasedOnLocation(String[] guessed, int correctLocation) {

        if (correctLocation == guessed.length) {
            return;
        }

        Map<Integer, String> currentLocationMap = createLocationMap(guessed); // creating map between each guess and it's index
        for (int i = 0; i < guessTable.length; i++) {
            if (!booleanArray[i]) { // skipping over impossible rows
                continue;
            }

            // checking for number of elements in the same location
            int sameLocation = 0;
            for (int x = 0; x < guessed.length; x++) {
                if (currentLocationMap.get(x).equals(guessTable[i][x])) {
                    sameLocation++;
                }
            }
            if (sameLocation < correctLocation) {
                booleanArray[i] = false;
            }
        }
    }

    private static Map<Integer, String> createLocationMap(String[] guessed) {
        Map<Integer,String> currentLocationMap = new HashMap<Integer,String>();
        for (int i = 0; i < guessed.length; i++) {
            currentLocationMap.put(i,guessed[i]);
        }
        return currentLocationMap;
    }

    private static Map<String, AtomicInteger> createColorMap(String[] guessed) {
        Map<String,AtomicInteger> currentColorMap = new HashMap<String,AtomicInteger>();
        for (int i = 0; i < guessed.length; i++) {
            if (!currentColorMap.containsKey(guessed[i])) {
                currentColorMap.put(guessed[i], new AtomicInteger(1));
            } else {
                currentColorMap.get(guessed[i]).incrementAndGet();
            }
        }
        return currentColorMap;
    }

    private static String[][] createTable(String[][] answerTable, String[] colors, int numTokens) {
        int r = answerTable.length;
        int index = 0;
        int repeats;
        int next = 0;
        int column = numTokens-1;

        if (column >= 0){
            for (int row = 0; row < r; row++) {
                repeats = (int) Math.pow(colors.length,numTokens-1);
                if (next == repeats) {
                    index++;
                    next = 0;
                }
                next++;
                if (index == colors.length)
                    index = 0; // recycles through the array of colors
                answerTable[row][numTokens-1] = colors[index];
            }
            createTable(answerTable, colors, numTokens-1);
        }
        return answerTable;
    }

    private static boolean[] createBooleanArray() {
        int r = (int) Math.pow(colors.length, numTokens);
        boolean[] boolRows = new boolean [r];
        Arrays.fill(boolRows, true);
        return boolRows;
    }

    private static String[] getColors() {
        System.out.println("Enter each color, then press enter");
        System.out.println("Type \"stop\" once you're done, and then press enter.");
        List<String> colorList = new ArrayList<String>();
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("stop"))
                break;
            else if (colorList.contains(input)) {
                System.out.println("You have already entered this color. Please try again, or type \"stop\"");
            } else if (input.matches(".*[0-9].*")){
                System.out.println("You entered invalid input. Please try again, or type \"stop\"");
            } else {
                colorList.add(input);
            }
        }
        if (colorList.size() == 0 || (colorList.size() == 1 && colorList.get(0).equals(""))) {
            System.out.println("You must enter at least one color.");
            newGame();
            return null;
        }
        return colorList.toArray(new String[colorList.size()]);
    }


    private static int getNumTokens() {
        System.out.println("How many numTokens would you like to use?");
        String numTokens = scanner.nextLine();
        boolean hasSpace = numTokens.matches(".*\\s+.*");
        boolean numeric = numTokens.matches("\\d+");
        boolean hasLeadingZero = numTokens.startsWith("0");
        while (hasSpace || hasLeadingZero || !numeric) {
            if (hasSpace) {
                System.out.println("You have entered invalid input. Please try again without entering a space.");
            } else if (hasLeadingZero) {
                System.out.println("You have entered invalid input. Please try again without entering a leading zero.");
            } else {
                System.out.println("You have entered invalid input. Please try again without entering an invalid character.");
            }
            numTokens = scanner.next();
            numeric = numTokens.matches("\\d+");
            hasLeadingZero = numTokens.startsWith("0");
            hasSpace = numTokens.matches(".*\\s+.*");
        }
        return Integer.parseInt(numTokens);
    }

}