/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figures;

public class Figures {

    
    public static void main(String[] args) {
        hourglass();
        System.out.println();
        rectangle();
        System.out.println();
        bigHourglass();
    }
    
    // Prints out a series of stars in an hourglass-shaped figure
    public static void hourglass() {
        System.out.println("*****");
        for (int i = 1; i <= 3; i++) {
            System.out.println(" * * ");
        }
        System.out.println("*****");
    }
    
    // Prints out a series of stars in a shape of a rectangle 
    public static void rectangle() {
        for (int i = 1; i <= 4; i++) {
            System.out.println("*****");
        }
    }
    
    // Draws a larger hourglass-shaped figure using stars
    public static void bigHourglass() {
        hourglass();
        rectangle();
        hourglass();
    }
        
    
}
