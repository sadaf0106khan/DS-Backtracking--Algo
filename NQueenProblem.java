package dp;

public class NQueenProblem {

	public static boolean solveNQueen(int [][]board,int row ,int n) {
		//bsce case
		
		if(row==n) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j]==1) {
						System.out.print("Q ");
					}else {
						System.out.print("_ ");
					}
				}
				System.out.println();
			}
			System.out.println();
			//return true;
			return false;
			//agar yaha pe return true ki jgh pe return false kroge to saare possible case return kar dega..
		}
		
		//recursive case
		//for particular row check every column 
		for(int j=0;j<n;j++) {
			if(isSafe(board,row,j,n)) {
				board[row][j]=1;
				if(solveNQueen(board,row+1,n))
					return true;
				board[row][j]=0;//backtrack
			}
		}
	return false;
	}

	private static boolean isSafe(int[][] board, int row, int col, int n) {
		
		//check for that column
		
		for(int i=0;i<row;i++) {
			if(board[i][col]==1) {
				return false;
			}
		}
		
		//check for left diagonal
		
		int x=row;
		int y=col;
		
		while(x>=0&&y>=0) {
			if(board[x][y]==1)
				return false;
			x--;y--;
		}
		
		x=row;y=col;
		
		while(x>=0&&y<n) {
			if(board[x][y]==1)
				return false;
			x--;y++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int [][]b=new int[10][10];
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b.length;j++) {
				b[i][j]=0;
			}
		}
		
		solveNQueen(b,0,4);
	}
}
