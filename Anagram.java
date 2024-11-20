/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("silent","listenz"));  // false
		System.out.println(isAnagram("William Shakespeare","I am a weakish spellery")); // false
		System.out.println(isAnagram("Madam Curieg","Radium came")); // false
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lod Voldemort")); // false

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		//Because we disregard spaces, we first want to remove the spaces from the checked words.
		while (str1.indexOf(' ') != -1) {
			str1 = str1.substring(0, str1.indexOf(' ')) + str1.substring(str1.indexOf(' ') + 1, str1.length());
		}
		while (str2.indexOf(' ') != -1) {
			str2 = str2.substring(0, str2.indexOf(' ')) + str2.substring(str2.indexOf(' ') + 1, str2.length());
		}
		char checkedChar;
		int isCharInStr = -1;
		
		//First, we check if the two pre-processed strings are the same length. If not, we can automatically assume they are not anagrams.
		if (str1.length() != str2.length()) {
			return false;
		}

		//Now, for each char in the first string, we check if it exists in the second string. If it does, we remove said character from the second string so we can accurately check if it exists again if neded.
		for (int i = 0; i < str1.length(); i++) {
			checkedChar = str1.charAt(i);
			isCharInStr = str2.indexOf(checkedChar);
			
			if (isCharInStr == -1) {
				return false;
			}
			str2 = str2.substring(0, isCharInStr) + str2.substring(isCharInStr + 1, str2.length());
		}
		//If the loop ended without returning false, the words are anagrams and we can return true.
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		char char1;
		String processedStr = "";
		for (int i = 0; i < str.length(); i++) {
			char1 = str.charAt(i);
			if ((char1 > 64) && (char1 < 91)) {
				processedStr += (char) (char1 + 32);
			}
			else if (((char1 > 96) && (char1 < 123)) || char1 == 32) {
				processedStr += char1;
			}
		}
		return processedStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomString = "";
		int rand;

		while (str.length() > 0) {
			rand = (int) (Math.random() * str.length());
			randomString += str.charAt(rand);
			str = str.substring(0, rand) + str.substring(rand + 1, str.length());
		}
		return randomString;
	}
}
