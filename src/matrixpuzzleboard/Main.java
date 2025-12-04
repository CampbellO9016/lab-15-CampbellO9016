package matrixpuzzleboard;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		int[][] board = new int[5][5];
		Random ran = new Random();
		
		for(int i = 0; i < 5; i ++) {
			for(int j = 0; j < 5; j ++) {
				board[i][j] = ran.nextInt(16);
			}
		}
		for(int[] b : board) {
			for(int n: b) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
		int num = Main.detectEquivalentAdjacentPairs(board);
		System.out.println(num);
		
		System.out.println("_______________");
		Main.checkDuplicates(board);
		
		System.out.println("_______________");
		Main.shiftRight(board, 2, 0);
		
		System.out.println("_______________");
		Main.shiftUp(board, 2, 0);
		System.out.println("_______________");
		for(int[] b : board) {
			for(int n: b) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
		System.out.println("_______________\nReverses");
		
		System.out.println("_______________");
		Main.reverseRow(board, 0);
		
		System.out.println("_______________");
		Main.reverseColummn(board, 0);
		
		
		

	}
	public static int detectEquivalentAdjacentPairs(int[][] arr){
		int ap = 0;
		for(int i = 0; i < arr.length; i ++) {
			for(int j = 1; j < arr[i].length; j ++) {
				if(arr[i][j-1] == arr[i][j]) {
					ap ++;
				}
			}
		}
		return ap;
	}
	public static void checkDuplicates(int[][] arr) {
		int[] dup = new int[16];
		for(int k = 0; k < 16; k++) {
			int count = 0;
			for(int i = 0; i < 5; i ++) {
				for(int j = 0; j < 5; j ++) {
					if(arr[i][j] == k) {
						count ++;
					}
				}
			}
			dup[k] = count;
		}
		for(int i = 0; i < 16; i ++) {
			if(!(dup[i] <= 1)) {
				System.out.println(i + ": " + dup[i]);
			}
		}
	}
	public static void shiftRight(int[][] arr, int shift, int row) {
		
		for(int i = 0; i < shift; i ++) {
			int last = arr[row][arr.length-1];
			for(int j = arr[row].length -1; j > 0; j --) {
				arr[row][j] = arr[row][j-1];
			}
			arr[row][0] = last;
		}
		for(int[] b : arr) {
			for(int n: b) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
	}
	public static void shiftUp(int[][] arr, int shift, int col) {
		for(int i = 1; i <= shift; i ++) {
			int last = arr[arr.length-1][col];
			for(int j = arr[col].length -1; j > 0; j --) {
				arr[j][col] = arr[j-1][col];
			}
			arr[0][col] = last;
		}
		for(int[] b : arr) {
			for(int n: b) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
	}
	public static void reverseRow(int[][] arr, int row) {
		int hold = arr[row][0];
		arr[row][0] = arr[row][4];
		arr[row][4] = hold;
		hold = arr[row][1];
		arr[row][1] = arr[row][3];
		arr[row][3] = hold; 
		
		for(int[] b : arr) {
			for(int n: b) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
	}
	public static void reverseColummn(int[][] arr, int col) {
		int hold = arr[0][col];
		arr[0][col] = arr[4][col];
		arr[4][col] = hold;
		hold = arr[1][col];
		arr[1][col] = arr[3][col];
		arr[4][col] = hold;
		
		
		for(int[] b : arr) {
			for(int n: b) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
	}
	
	

}
