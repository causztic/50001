package week3;
// Question 3
// total: 30 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.Arrays;

public class TestMatrix {
	public static void main(String[] args) {
		double [][] a = { 
				{1,2,3},
				{4,5,6}
		};
		
		double [][] b = {
				{1,2},
				{3,4},
				{5,6}
		};
		
		double [][] c = matMpy (a,b);
		
		printMat(c);

		//////
		
		int [] f = {2, 5, 0, 0, 0};
		int [] g = {1, 3, 7};
		
		mergeSortedArray(f, 2, g, 3);
		
		printMat(f);
		
	}

	public static void printMat(int [] c) {
		int m;
		m = c.length;
		for (int i = 0; i< m; i++) {
			System.out.print(c[i] + ",  ");
		}
		System.out.println();
	}
	
	public static void printMat(double [][] c) {
		int m,n;
		m = c.length;
		n = c[0].length;
		for (int i = 0; i< m; i++) {
			for (int j=0; j< n; j++) {
				System.out.print(c[i][j] + ",  ");
			}
			System.out.println();
		}
		
	}
	
	
	public static double [][] matMpy ( double [][] a, double [][] b) {
		if (a[0].length != b.length)
			return null;

        double[][] output = new double[a.length][a.length];
        for (int i = 0; i < a.length; i++){
            // looping through the number of rows.
            // move along column
            for (int column = 0; column < a.length; column++){
                // move down column
                double value = 0;
                for (int j = 0; j < a[0].length; j++){
                    value += b[j][column] * a[i][j];
                }
                output[i][column] = value;
            }
        }
        return output;
	}

	public static void mergeSortedArray(int [] a, int m, int [] b, int n) {
		// leftPointer is pointer for a, rightPointer is pointer for b.
		// n is the size of b.
        int leftPointer = 0, rightPointer = 0;
        while (rightPointer < b.length && leftPointer < a.length){
            if (b[rightPointer] <= a[leftPointer]){
                // item is smaller than the array to merge to, shift items to the right and insert it
                for (int i = m - 1; i >= leftPointer; i--){
                    a[i+1] = a[i];
                }
                a[leftPointer] = b[rightPointer];
                // increase rightPointer and the number of items.
                rightPointer++;
                m++;
            } else {
                // item is bigger than the array to merge to, check if m is smaller than the pointer.
                // increment the left pointer.
                if (leftPointer == m - 1){
                    // the leftPointer is at the last element already, add the rest
                    for (int i = rightPointer; i < n; i++){
                        a[leftPointer+1] = b[i];
                        leftPointer++;
                    }
                }
                leftPointer++;
            }
        }
    }
}
