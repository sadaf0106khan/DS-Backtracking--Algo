package dp;

public class KnightTour {

	static int[] row1 = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] col1 = { 1, 2, 2, 1, -1, -2, -2, -1 };

	//first move of knight always should be (2,1)
	public static boolean knightTour(int[][] board, int row, int col, int move) {
		if (move == 64) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {

					System.out.print(board[i][j] + " ");

				}
				System.out.println();
			}
			System.out.println();
			return true;
			// return false;
		}

		for (int i = 0; i < row1.length; i++) {
			int newrow = row + row1[i];
			int newcol = col + col1[i];
			if (isSafe(board, newrow, newcol)) {
				move++;
				board[newrow][newcol] = move;
				if (knightTour(board, newrow, newcol, move)) {
					return true;
				}
				move--;
				board[newrow][newcol] = 0;
			}
		}
		return false;
	}

	public static boolean isSafe(int[][] board, int newrow, int newcol) {
		if ((newrow >= 0 && newrow < board.length) && (newcol >= 0 && newcol < board.length)
				&& (board[newrow][newcol] == 0)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] board = new int[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
			}
		}
		board[0][0] = 1;
		knightTour(board, 0, 0, 1);
	}
}
