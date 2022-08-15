package NumberTheory;

import java.util.Scanner;

public class P1747 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int prime[] = new int[1000001];
		
		for (int i=2; i<prime.length; i++) {
			prime[i] = i; // initialize index to its own value
		}
		
		for (int i=2; i<Math.sqrt(prime.length); i++) { // repeat to prime length square root
			if (prime[i] == 0) // non-decimal
				continue;
			for (int j=i+i; j<prime.length; j=j+i) { // Repeat prime multiple values up to prime length
				prime[j] = 0;
			}
		}
		
		int i = N;
		while (true) { // Verify that the value is decimal and the number of palindroms is correct by increasing it by 1 from N
			if (prime[i] != 0) { // decimal is correct
				int result = prime[i];
				if (isPalindrome(result)) { // decimal & palindrome count, exit
					System.out.println(result);
					break;
				}
			}
			i++;
		}
	}
	
	private static boolean isPalindrome(int target) { // Implement palindrome number discrimination function, target == result == prime[i]
		char temp[] = String.valueOf(target).toCharArray(); // temp[] == target == result == prime[]
		// String.valueOf() -> Convert multiple types (char, int, long, double, etc.) to String
		// ex) Convert target to String string because it is int type
		// String.toCharArray() -> Split the string one character at a time and insert it into an array of char types
		int s = 0; // Start
		int e = temp.length-1; // End, Prime[] Reduced again because it expanded the array size by one more
		while (s < e) {
			if (temp[s] != temp[e]) // the values corresponding to the start and end indexes are different -> not the number of palindroms
				return false;
			s++;
			e--;
		}
		return true; // return true when repeat statement is complete
	}
}
