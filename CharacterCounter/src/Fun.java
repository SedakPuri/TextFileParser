/* The purpose of this program is to take in a text file that a user enters and displays the 
* character with the maximum occurance and the amount times that this character is shown in the text. 
* The sample rich text file that I have in the reference library is called "jcPenny.rtf". You can reuse 
* this by double clicking on the file in eclipse and editing it to preference to test the program.
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class Fun {

	public static void main(String[] args) {
		
		//User Input
		System.out.println("Enter the name of the file you wish to import: ");
		Scanner keyboard = new Scanner(System.in);
		String file = keyboard.next();
		
		//File Input Stream
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find File");
			System.exit(0);
		}
		
		//"King of the Hill" initial max values
		char maxChar = 'a';
		int maxCount = 0;
		
		//Counter Initialization
		int[] count = new int[26];
		for(int i = 0; i < count.length; i++) {
			count[i] = 0;
		}

		//Parsing through file
		while(fileIn.hasNext()) {
			String word = fileIn.next().toLowerCase();
		
			//Parsing to find values of individual chars
			char[] wordLetters = word.toCharArray();
			for(int i = 0; i < word.length(); i++) {
				if(Character.isAlphabetic(wordLetters[i])) {
					int current = (int)wordLetters[i];
					count[current % 97]++;
				}
			}
	
			//Finding the Maximum Count by Parsing through all the counters
			for(int i = 0; i < count.length; i++) {
				if (count[i] > maxCount) {
					maxCount = count[i];
					maxChar = ((char) i + 97);
				}
			}
		}
		
		//System Output
		System.out.println("The longest count of a single character is the character " + maxChar + " with " + maxCount + " occurances");
	}

}
