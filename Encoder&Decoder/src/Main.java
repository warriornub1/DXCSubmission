import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Encoder BC;
		String encoded_String = ""; 
		String decoded_String = "";
		
		try {
			Scanner scanner = new Scanner(System.in);
			
			// Get a new word
			System.out.println("Enter a word : ");		
			String word = scanner.nextLine();
			// Upper case everything to keep it consistent
			word = word.toUpperCase();
			//enter word into constructor
			BC = new Encoder(word);
			
			// Encode word
			encoded_String = BC.encoder(word.substring(1));
			System.out.println("The encoded String is : " + encoded_String);
			// Decode Word
			decoded_String = BC.decoder(encoded_String);
			System.out.println("The decoded String is : " + decoded_String);
			
			System.out.println();
	        // Close the scanner to free up resources
	        scanner.close();
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	
		

	}

}
