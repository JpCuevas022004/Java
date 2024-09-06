package it131;
import java.util.Scanner;

public class Wednesday_LABoratory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner scanner = new Scanner(System.in);
		        System.out.print("Your name: ");
		        String name = scanner.nextLine().toLowerCase();

		        int Vowel = 0;
		        int Consonant = 0;

		        for (int i = 0; i < name.length(); i++) 
		        {
		            char ch = name.charAt(i);
		            
		            if (Character.isLetter(ch)) 
		            {
		                // Check if the character is a vowel
		                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
		                {
		                    Vowel++;
		                } 
		                else 
		                {
		                    Consonant++;
		                }
		            }
		        }

		        System.out.println("Enter the number of vowels in your name: " + Vowel);
		        System.out.println("Enter the number of consonants in your name: " + Consonant);

		        scanner.close();
		    }
		}


