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
			String word = fileIn.next();
			word = word.toLowerCase();
		
			//Parsing to find values of individual chars
			char[] wordLetters = word.toCharArray();
			for (int i = 0; i < word.length(); i++) {
				switch (wordLetters[i]) {
					case 'a':
						count[0]++;
						break;
						
					case 'b':
						count[1]++;
						break;
						
					case 'c':
						count[2]++;
						break;
						
					case 'd':	
						count[3]++;
						break;
						
					case 'e':
						count[4]++;
						break;
						
					case 'f':
						count[5]++;
						break;
						
					case 'g':
						count[6]++;
						break;
						
					case 'h':
						count[7]++;
						break;
						
					case 'i':
						count[8]++;
						break;
						
					case 'j':
						count[9]++;
						break;
						
					case 'k':
						count[10]++;
						break;
						
					case 'l':
						count[11]++;
						break;
						
					case 'm':
						count[12]++;
						break;
						
					case 'n':
						count[13]++;
						break;
						
					case 'o':
						count[14]++;
						break;
						
					case 'p':
						count[15]++;
						break;
						
					case 'q':
						count[16]++;
						break;
						
					case 'r':
						count[17]++;
						break;
						
					case 's':
						count[18]++;
						break;
						
					case 't':
						count[19]++;
						break;
						
					case 'u':
						count[20]++;
						break;
						
					case 'v':
						count[21]++;
						break;
						
					case 'w':
						count[22]++;
						break;
						
					case 'x':
						count[23]++;
						break;
						
					case 'y':
						count[24]++;
						break;
						
					case 'z':
						count[25]++;
						break;
				}
			}
			
			//Object Creation of new Class
			FunClass xD = new FunClass();
			
			//Finding the Maximum Count by Parsing through all the counters
			for(int i = 0; i < count.length; i++) {
				if (count[i] > maxCount) {
					maxCount = count[i];
					maxChar = xD.getAssociatedLetter(i); //Will return a char of the letter that is associated with that index (i.g. 0 = a, 1 = b, 2 = c, etc......)
				}
			}
		}
		
		//System Output
		System.out.println("The longest count of a single character is the character " + maxChar + " with " + maxCount + " occurances");
	}

}
