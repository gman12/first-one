package mutunes;

import java.util.*;
import java.io.*;

public class muTunes {
    // Class constants for table headers
    public static final String TITLE = "TITLE";
    public static final String ARTIST = "ARTIST";
    public static final String TIME = "TIME";
    public static final String DASHES = "------";
    public static final String TOTAL_TIME = "TOTAL TIME";
    public static final String LONGEST_TRACK = "LONGEST TRACK";
    public static final String SHORTEST_TRACK = "SHORTEST TRACK";
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("music.txt"));
        int numContent = input.nextInt();
        String[] tempWords = new String[numContent];        // A temporary array to for storing the String parts of data     
        
        // Creating arrays for three parts of each song
        int[] times = new int[numContent]; 
        String[] trackTitles = new String[numContent];
        String[] artists = new String[numContent];
        
        // Storing song times in an array 
        for (int i = 0; i < numContent; i++) {
            times[i] = input.nextInt();
            tempWords[i] = input.nextLine();
        }
        
        // Splitting temporary words array into two separate arrays for artists and track titles
        for (int i = 0; i < tempWords.length; i++) {        
            int colonLoc = tempWords[i].indexOf(":");
            artists[i] = tempWords[i].substring(colonLoc+1, tempWords[i].length());
            trackTitles[i] = tempWords[i].substring(1, colonLoc);
        }
       
        // Return values from methods for getting song data
        int totalTime = calcTotalTime(times);
        int longestIndex = findLongest(times, numContent);
        int shortestIndex = findShortest(times);
        
        // Printing out all the data about the songs
        printTable(times, trackTitles, artists);
        System.out.printf("%-32s %37d\n", TOTAL_TIME, totalTime);
        System.out.println();
        System.out.printf("%-32s\n", LONGEST_TRACK);
        System.out.printf("%-32s\n", DASHES); 
        System.out.printf("%-32s %-32s %-32d\n", trackTitles[longestIndex], artists[longestIndex], times[longestIndex]);
        System.out.println();
        System.out.printf("%-32s\n", SHORTEST_TRACK);
        System.out.printf("%-32s\n", DASHES);
        System.out.printf("%-32s %-32s %-32d\n", trackTitles[shortestIndex], artists[shortestIndex], times[shortestIndex]);
        System.out.println();
        // Calling sorting methods
        printSortedTitle(times, trackTitles, artists);
        printSortedArtist(times, trackTitles, artists);
        
        input.close();
    }
    
    // Formats and prints song data into a table
    public static void printTable(int[] times, String[] trackTitles, String[] artists) {
        System.out.printf("%-32s %-32s %-32s\n", TITLE, ARTIST, TIME);      // Headers
        System.out.printf("%-32s %-32s %-32s\n", DASHES, DASHES, DASHES);
        for (int i = 0; i < times.length; i++) {
            System.out.printf("%-32s %-32s %-32d\n", trackTitles[i], artists[i], times[i]);
        }
        System.out.println();
    }
    
    // Prints a table of the song data sorted alphabetically by title
    public static void printSortedTitle(int[] times, String[] trackTitles, String[] artists) {
        for (int n = 0; n < 5; n++) {
            for (int m = 0; m < 4 - n; m++) {
                if ((trackTitles[m].compareTo(trackTitles[m + 1])) > 0) {
                    String swapString = trackTitles[m];         // Sorting each individual array
                    trackTitles[m] = trackTitles[m + 1];
                    trackTitles[m + 1] = swapString;
                    String swapString2 = artists[m];
                    artists[m] = artists[m + 1];
                    artists[m + 1] = swapString2;
                    int swapInt = times[m];
                    times[m] = times[m + 1];
                    times[m + 1] = swapInt;
                }
            }
        }
        System.out.println("Sorted by title");
        printTable(times, trackTitles, artists);    
    }
    
    // Prints a table of the song data sorted alphabetically by artist
    public static void printSortedArtist(int[] times, String[] trackTitles, String[] artists) {
        for (int n = 0; n < 5; n++) {
            for (int m = 0; m < 4 - n; m++) {
                if ((artists[m].compareTo(artists[m + 1])) > 0) {
                    String swapString = trackTitles[m];         // Sorting each individual array
                    trackTitles[m] = trackTitles[m + 1];
                    trackTitles[m + 1] = swapString;
                    String swapString2 = artists[m];
                    artists[m] = artists[m + 1];
                    artists[m + 1] = swapString2;
                    int swapInt = times[m];
                    times[m] = times[m + 1];
                    times[m + 1] = swapInt;
                }
            }
        }
        System.out.println("Sorted by artist");
        printTable(times, trackTitles, artists);
    }
    
    // Calculates total time of songs
    public static int calcTotalTime(int[] times) {
        int totalTime = 0;
        for (int i = 0; i < times.length; i++) {
            totalTime += times[i];
        }
        return totalTime;
    }
    
    // Returns index of longest song
    public static int findLongest(int[] times, int numContent) {
        int longest = times[0];
        int longestIndex = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[i] > longest) {
                longestIndex = i;
                longest = times[i];
            }
        }
        return longestIndex;
    }
    
    // Returns index of shortest song
    public static int findShortest(int[] times) {
        int shortest = times[0];
        int shortestIndex = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[i] < shortest) {
               shortestIndex = i;
               shortest = times[i];
            }
        }
        return shortestIndex;
    }
}
