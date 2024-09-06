package it131;
import java.util.Scanner;
public class Assignment_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner scanner = new Scanner(System.in);

		        // Prompt the user to enter the number of strings (n)
		        System.out.print("Enter the number of strings: ");
		        int n = scanner.nextInt();

		        // Create an array of strings with size n
		        String[] arr = new String[n];

		        // Input strings from the user
		        for (int i = 0; i < n; i++) {
		            System.out.print("Enter string " + (i + 1) + ": ");
		            arr[i] = scanner.next();
		        }
		        
		        System.out.println("");
		        // Print all the elements of the array
		        System.out.println("Elements in the array:");
		        for (int i = 0; i < n; i++) {
		            System.out.println("Element " + (i + 1) + ": " + arr[i]);
		        }
		        scanner.close();
		    }
         }

