package dp;

public class RatInAMaze {

	public static void main(String[] args) {
		int [][]maze= { {1,1,0,1},
						{1,1,0,0},
						{0,1,1,0},
						{1,1,1,1}};
		int [][]visited=new int[maze.length][maze.length];
		for(int i=0;i<visited.length;i++) {
			for(int j=0;j<visited.length;j++) {
				visited[i][j]=0;
			}
		}
		visited[0][0]=1;
		
		solveRatInMaze(maze,visited,0,0,3,3);
	}
	static int row1[]= {0,0,1,-1};
	static int col1[]= {1,-1,0,0};

	private static boolean solveRatInMaze(int[][] maze, int[][] visited ,int row ,int col, int lastrow,int lastcol) {
		if((row==lastrow)&&(col==lastcol)) {
			for(int i=0;i<visited.length;i++) {
				for(int j=0;j<visited.length;j++) {
					
						System.out.print(visited[i][j]+" ");
					
				}
				System.out.println();
			}
			System.out.println();
			//return true;
			return false;
		}
		
		//for recursive case
		
		for(int i=0;i<row1.length;i++) {
			int newrow=row+row1[i];
			int newcol=col+col1[i];
			
			if(isSafe(maze,visited,newrow,newcol)) {
				visited[newrow][newcol]=1;
				if(solveRatInMaze(maze,visited,newrow,newcol,lastrow,lastcol))
					return true;
				visited[newrow][newcol]=0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] maze, int[][] visited, int newrow, int newcol) {
		if((newrow>=0&&newrow<visited.length)&&(newcol>=0&&newcol<visited.length)&&(maze[newrow][newcol]==1)&&visited[newrow][newcol]==0)
		return true;
		
		return false;
	}
}
