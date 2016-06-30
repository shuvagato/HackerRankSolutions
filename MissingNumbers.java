/*
* Solution for Missing Numbers in Hackerrank
*https://www.hackerrank.com/challenges/missing-numbers
*/

import java.io.*;
import java.util.*;

public class Solution {

    final static int MINIMUM = 0;
	final static int MAXIMUM = 1;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
		// TODO Auto-generated constructor stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] A = new int[n];
		
		for(int i = 0 ; i < n; i++) {
			A[i] = in.nextInt();
		}
		
		int min = getMinMax(A, MINIMUM);
		int max = getMinMax(A, MAXIMUM);
		
		int[] cacheArrayN = new int[max - min + 1];
		int[] cacheArrayM = new int[max - min + 1];
			
		for(int i = 0 ; i < n ; i++) {
			cacheArrayN[A[i] - min]++;
		}
		
				int m = in.nextInt();
		
		for(int i = 0 ; i < m ; i++) {
			int a = in.nextInt();
			cacheArrayM[a - min]++;
		}
		
		
		

		for(int i = 0 ; i < cacheArrayM.length ; i++) {
			
			if(cacheArrayM[i] - cacheArrayN[i] > 0) {
				System.out.print(min+i + " ");
			}
		}
		
		
		
	
    }
    
    
	private static int getMinMax(int arr[], int minOrMax) {
		int min = arr[0];
		int max = arr[0];
		
		for(int i = 0 ; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		if(minOrMax == MINIMUM) {
			return min;
		} else {
			return max;
		}
	}

}
