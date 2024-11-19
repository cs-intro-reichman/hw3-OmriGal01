// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println("PLUS");
		System.out.println(plus(2,3));   // 2 + 3
		System.out.println(plus(2, -3));
		System.out.println("\nMINUS");
		System.out.println(minus(7,2));  // 7 - 2
		System.out.println(minus(7, -3));
		System.out.println("\nTIMES");
 		System.out.println(times(3,4));  // 3 * 4
		 System.out.println(times(3, -5));
		 System.out.println("\nBunch of Stuff");
   		System.out.println(plus(2,times(4,2)));
		   System.out.println("\nPOWER");  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));
		   System.out.println("\nDIVISION");      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));
		   System.out.println("\nMOD");   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));
		   System.out.println("\nSQRT");  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 == 0) {
			return x1;
		}
		else if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		}
		else {
			for (int i = 0; i > x2; i--) {
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 == 0) {
			return x1;
		}
		else if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1--;
			}
		}
		else {
			for (int i = 0; i > x2; i--) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		if (x2 == 0) {
			return 0;
		}
		else if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				result = plus(result, x1);
			}
		}
		else {
			for (int i = 0; i > x2; i--) {
				result = minus(result, x1);
			}
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		for (int i = 1; i < x1; i++) {
			if (times(i, x2) > x1) {
				return (minus(i, 1));
			}
			else if (times(i, x2) == x1) {
				return i;
			}
		}
		return 0;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		return (minus(x1, times(x2, div(x1, x2))));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int result = 0;
		for (int i = 0; i < x; i++) {
			result = times(i, i);
			if (result > x) {
				return (minus(i, 1));
			}
			else if (result == x) {
				return i;
			}
		}
		return 0;
	}	  	  
}