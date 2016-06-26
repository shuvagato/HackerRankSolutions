/*
* Solution for Matrix Rotation CounterClock wise in Hackerrank
*https://www.hackerrank.com/challenges/matrix-rotation-algo
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
		// TODO Auto-generated constructor stub
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		
		int R = in.nextInt();
		
		int[][] matrix = new int[M][N];
		
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		
		int[][] outputMatrix = matrix;
		int startRow = 0;
		int startCol = 0;
		int endRow = M;
		int endCol = N;
		int numberOfLayers = Math.min(M, N) / 2;

		
		for(int l = 0 ; l < numberOfLayers; l++) {
			
			
			ArrayList<Integer> elementsInLayer = new ArrayList<Integer>();
			//Get Layer Elements
			//towards Right
			for(int i = startCol; i < endCol; i ++) {
				elementsInLayer.add(matrix[startRow][i]);
			}
			
			//towards Down
			for(int i = startRow + 1; i < endRow; i++) {
				elementsInLayer.add(matrix[i][endCol - 1 ]);
			}
			
			//Towards Left
			for(int i = endCol - 2; i >=startCol ; i --) {
				elementsInLayer.add(matrix[endRow - 1][i]);
			}
			
			//Towards Up
			for(int i = endRow - 2; i > startRow; i--) {
				elementsInLayer.add(matrix[i][startCol]);
			}
			
			int rotatebyR = R % elementsInLayer.size();
			rotateArray(elementsInLayer, rotatebyR);
			
			//Put Layer Elements after rotoation
			int c = 0;
			//towards Right
			for(int i = startCol; i < endCol; i ++) {
				outputMatrix[startRow][i] = elementsInLayer.get(c++);
				
			}
			
			//towards Down
			for(int i = startRow + 1; i < endRow; i++) {
				outputMatrix[i][endCol - 1] = elementsInLayer.get(c++) ;
				
			}
			
			//Towards Left
			for(int i = endCol - 2; i >=startCol ; i --) {
				outputMatrix[endRow - 1][i] = elementsInLayer.get(c++);
			}
			
			//Towards Up
			for(int i = endRow - 2; i > startRow; i--) {
				outputMatrix[i][startCol] = elementsInLayer.get(c++);
			}	
			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}
		
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++	) {
				System.out.print(outputMatrix[i][j] + " ");
			}
			System.out.println(" ");
		}
		
		
	
    }
    private static void rotateArray(ArrayList<Integer> arr, int num) {
		for(int i = 0 ; i < num ; i++) {
			int temp =arr.get(0);
			arr.remove(0);
			arr.add(temp);
		}
	}
}
