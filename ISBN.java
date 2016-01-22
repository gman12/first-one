// This program determines if a user-entered ISBN number is valid or not

package isbn;

import java.util.*;

public class ISBN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer;
                        
        do {
            System.out.print("Enter a 10-digit ISBN: ");
            String isbn = console.nextLine();
            String firstnine = isbn.substring(0,9);  
            
            int checkdigit = getCheckDigit(firstnine);
            String onesdigit = isbn.substring(9);
            int lastdigit = Integer.parseInt(onesdigit);
                       
            if (checkdigit == lastdigit){
                System.out.println("The ISBN you entered is valid.");
            }
            else {
                System.out.println("The ISBN you entered is not valid.");
            }
            
            
            System.out.print("Do you want to try another (yes/no)? ");
            answer = console.nextLine();
            
            
            
        } while(!answer.equals("no"));
    }
    
    public static int getCheckDigit(String firstnine) {
        int sum = 0;
        for(int i = 0; i<firstnine.length(); i++){
            sum += Integer.parseInt(""+firstnine.charAt(i))*(10-i);
        }
        return ((11-(sum%11))%11);   
        
        
    }
}
