package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8 ...)
	 */
	public static double geometricSum(int n) {
		// Base case: if n is 0, the sum is 0 (as there's nothing to sum)
		if (n == 0) {
	        return 0;
	    }
	    return 1 / Math.pow(2, n) + geometricSum(n - 1); // Recursive case: 1/2^n + geometricSum(n-1)
	}
	
	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
	    // Base case: if radius is smaller than the threshold, stop drawing
	    if (radius < radiusMinimumDrawingThreshold) {
	        return;
	    }

	    // Draw the current circle (assuming StdDraw is being used for drawing)
	    StdDraw.circle(xCenter, yCenter, radius);

	    // Recursive case: reduce the radius by a factor of 3 and draw three smaller circles
	    double newRadius = radius / 3.0;

	    // Draw circles to the left, right, and directly above the current circle
	    circlesUponCircles(xCenter - radius, yCenter, newRadius, radiusMinimumDrawingThreshold); // Left
	    circlesUponCircles(xCenter + radius, yCenter, newRadius, radiusMinimumDrawingThreshold); // Right
	    circlesUponCircles(xCenter, yCenter + radius, newRadius, radiusMinimumDrawingThreshold); // Above
	    circlesUponCircles(xCenter, yCenter - radius, newRadius, radiusMinimumDrawingThreshold); // Below
	}
	
	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
	    // Create a copy of the array to avoid mutation of the original array
	    int[] reversedArray = array.clone();
	    
	    // Call the helper method to reverse the array recursively
	    reverseHelper(reversedArray, 0, array.length - 1);
	    
	    return reversedArray;
	}

	// Helper method to reverse the array recursively
	private static void reverseHelper(int[] array, int start, int end) {
	    // Base case: if start is greater than or equal to end, stop recursion
	    if (start >= end) {
	        return;
	    }
	    
	    // Swap elements at start and end indices
	    int temp = array[start];
	    array[start] = array[end];
	    array[end] = temp;
	    
	    // Recursively reverse the rest of the array
	    reverseHelper(array, start + 1, end - 1);
	}

	
	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
	    // Base case: if q is 0, the gcd is p
	    if (q == 0) {
	        return p;
	    }
	    // Recursive case: gcd of q and p % q
	    return gcd(q, p % q);
	}
	
}
