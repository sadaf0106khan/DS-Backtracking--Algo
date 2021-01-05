package dp;

public class SudokuSolver {

	public static boolean sudokuSolver(int[][] board,int n) {
		
		int row=-1;
		int col=-1;
		
		boolean isEmpty=true;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]==0) {
					row=i;
					col=j;
					isEmpty=false;
					break;
				}
			}
			
			if(!isEmpty) {
				break;
			}
		}
		
		if(isEmpty) {
			return true;
		}
		
		for(int num=1;num<=n;num++) {
			if(isSafe(board,row,col,num)) {
				board[row][col]=num;
				if(sudokuSolver(board,n)) {
					return true;
				}
				board[row][col]=0;
			}
		}
		return false;
		
	}
	private static boolean isSafe(int[][] board, int row, int col, int num) {
		for(int j=0;j<board.length;j++) {
			if(board[row][j]==num) {
				return false;
			}
		}
		for(int i=0;i<board.length;i++) {
			if(board[i][col]==num) {
				return false;
			}
		}
		
		int sqrt=(int)Math.sqrt(board.length);
		
		int newrow=row-row%sqrt;
		int newcol=col-col%sqrt;
		
		for(int r=newrow;r<newrow+sqrt;r++) {
			for(int j=newcol;j<newcol+sqrt;j++) {
				if(board[r][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int [][]board= {{5,3,0,0,7,0,0,0,0},
						{6,0,0,1,9,5,0,0,0},
						{0,9,8,0,0,0,0,6,0},
						{8,0,0,0,6,0,0,0,3},
						{4,0,0,8,0,3,0,0,1},
						{7,0,0,0,2,0,0,0,6},
						{0,6,0,0,0,0,2,8,0},
						{0,0,0,4,1,9,0,0,5},
						{0,0,0,0,8,0,0,7,9}};
		//int [][]board= {{0,2,3,0},{0,0,0,1},{0,1,0,0},{2,4,1,0}};
		int n=board.length;
		
		
	//	System.out.println(sudokuSolver(board,n));
		
		if(sudokuSolver(board,n)) {
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board.length;j++) {
						System.out.print(board[i][j]+" ");
					}
				System.out.println();
				}
		}
		else
			System.out.println("no");
		
	}
}
