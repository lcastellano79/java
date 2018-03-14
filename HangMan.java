import java.util.Scanner;

// Written by: Larissa Castellano 260739557
//______________________________________________________________________________

// This program implements a basic version for the Hangman word game, in which one player thinks about a word, and the other tries to guess it suggesting letters
public class HangMan {

	public static void main(String[] args) {
		
		// Variables declaration
		char[] alphabet = new char[26];
		Scanner input;
		String word, answer, aux;
		int wordLength, guesses, missingLetters, the, index = 0;
		char currentChar, puzzle;
		boolean valid, length =  false, isLetter = false, nonRepeated = false;
		
		// Initializes alphabet
		alphabet[0] = 'a';
		for (int i = 1; i < alphabet.length; i++)	{
			alphabet[i] = (char)(alphabet[i-1] +1) ;
		}
		
		// Presents welcome message, and the game's instructions to start playing
		System.out.println("**************************************\nWelcome to Larissa's HANGMAN Game!!!!!\n**************************************");		
		System.out.println("Guessing player, please turn around while your friend enters the word to guess.");
		System.out.println("Other player, please enter your word (up to 10 letters only, not case sensitive): ");
		input = new Scanner(System.in);
		word = input.next();
		
		// Normalizes the string into lower case
		word = word.toLowerCase();
		
		// Make sure the word is up to 10 characters
		while (word.length() > 10 )	{
			System.out.println("Invalid word.\nPlease enter a word up to 10 digits:");
			word = input.next();
			
			// Normalizes the string into lower case
			word = word.toLowerCase();
		}
		
		// Add some space to "clean" the mystery word from the command line
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		// Game logic implementation
		wordLength = word.length();
		
		// Stores how many letters the guessing player must guess
		missingLetters = wordLength;
		
		// Stores the mystery word with letters that had already been guessed
		char[] wordToDate = new char[wordLength];
		
		// Initializes the mystery word with '*'
		for (int i = 0; i < wordLength; i++)
			wordToDate[i] = '*';
		
		// The guessing player has 10 guesses to find out the mystery word
		guesses = 10;
		
		// The program runs while there was not 10 guesses, or while the mystery word has not been discovered
		while ( (guesses > 0) && (missingLetters > 0 ) )	{
			
			// Presents the current status of the game
			printArray(wordToDate);
			System.out.println(" ( " + guesses + " guess(es) left )");
			
			// Present the option to solve the puzzle (guess all the words)
			System.out.println("Do you want to solve the puzzle? Enter 'Y' to solve the puzzle or 'N' to guess a character:");
	
			//puzzle = stringToChar(input.next());
			
			// Auxiliary variable to transform input string into char
			aux = input.next();
			
			// Normalizes the string into lower case
			aux = aux.toLowerCase();
			puzzle = aux.charAt(0);
			
			// The player wants to guess the word
			if ( puzzle == 'y') 	{
				
				// Logic to receive and process the puzzle answer (word)
				System.out.print("Enter the complete word: ");
				
				// Auxiliary variable to transform input string into char
				answer = input.next();
				
				// Normalizes the string into lower case
				answer = answer.toLowerCase();
				
				// Mystery word discovered
				if (answer.compareTo(word) == 0) {
					guesses--;
					missingLetters = 0;
					break;
				
				// Wrong guess
				} else	{
					System.out.println("Wrong word. Better luck next time!");
					guesses--;
				}
				
				// Logic to receive and process the guesses (letters)
				} else if ( puzzle == 'n' )	{
				
					// Presents the letters not tried yet
					System.out.print("Letters not tried yet: ");
					printArray(alphabet);
					
					// Asks for the letter input
					System.out.println("\nWhich letter should I check for?");
					aux = input.next();
					aux = aux.toLowerCase();
					currentChar = aux.charAt(0);
					
					// Sets condition to enter the loop
					valid = false;
					
					// Makes sure the player will enter a valid letter
					while (!valid)	{
						
						// Checks if only one character was typed
						if (aux.length() == 1 ) {
							length = true;
						}
						
						// Checks if the character is a letter
						if (currentChar > 96 && currentChar < 123 )	{
							isLetter = true;
							index = (int)currentChar - 97;
						}
						
						// Checks if the character is repeated (only if it is a letter index will have a consistent value)
						if ((isLetter) && (alphabet[index] != '*'))	{
								nonRepeated = true;
						} 
						
						// Checks if all conditions are true and sets the variable to exit the loop
						if ( length && isLetter && nonRepeated)	{	
							valid = true;
						
						// Asks for the player input again
						} else	{
						System.out.println("\nInvalid entry. Please try again: ");
							aux = input.next();
							aux = aux.toLowerCase();
							currentChar = aux.charAt(0);
						}
						
						// Cleans the variables for the next iteration
						length = false;
						isLetter = false;
						nonRepeated = false;
					}
					
					// Marks the used words on the array
					searchChar(currentChar, alphabet);
					
					// Searches for the letters in the mystery word
					occurences = searchChar(currentChar, wordToDate, word);
					if (occurences > 0)	{
						missingLetters = missingLetters - occurences;
					}
					guesses--;
				}
			}
			// Mystery word not found, end of the program
			if (missingLetters == 0)	{
				printArray(alphabet);
				System.out.println("\nCongratulations! You guessed the mystery word \"" + word + "\" in " + (10 - guesses) + " guess(es)!" );
					
				// Mystery word not found, end of the program
				} else	{
					printArray(alphabet);
					System.out.println("\nSorry! You did not guess the mystery word \"" + word + "\". Better luck next time!");
				}
		}

	// This function prints an array of characters
	public static void printArray (char[] array)	{
		for( int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
	
	// This function searches a character in a String, modify an array to present this character and returns how many occurrences
	public static int searchChar (char letter, char[] array , String word)	{
		
		int occurences = 0;
		for ( int i = 0 ; i < word.length(); i++)	{
			if (word.charAt(i) == letter)	{
				occurences++;
				array[i] = word.charAt(i);
			}
		}
		return occurences;
	}
	
	// This function searches a character in an Array and modifies it to hide this character
	public static void searchChar (char letter, char[] array)	{
		
		for ( int i = 0 ; i < array.length; i++)	{
			if (array[i] == letter)	{
				array[i] = '*';
			}
		}
	}
	
}