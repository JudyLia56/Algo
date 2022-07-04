package algotest.day0703.lake;

public class Solution {
	static int min = 10000;
	static int max = 0;
	public int[] solution(int rows, int columns, int[][] lands) {
        int[] answer = new int[2];
        int[][] map = new int[rows][columns];
        boolean[][] visited = new boolean[rows][columns];
        
        for (int i = 0; i < lands.length; i++) {
			map[lands[i][0]-1][lands[i][1]-1] = 1;
			visited[lands[i][0]-1][lands[i][1]-1] = true;
		}
        map[0][0] = 2;
        for (int i = 0; i < rows; i++) {
        	checksea(map, visited, i, 0, rows, columns);
		}
        for (int i = 0; i < rows; i++) {
        	checksea(map, visited, i, columns-1, rows, columns);
        }
        for (int i = 0; i < columns; i++) {
        	checksea(map, visited, 0, i, rows, columns);
		}
        for (int i = 0; i < columns; i++) {
        	checksea(map, visited, rows-1, i, rows, columns);
		}
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					findlake(map, visited, i, j, rows, columns, 1);
				}
			}
		}
        answer[0] = min;
        answer[1] = max;
        if(answer[0] == 10000 || max == 0) {
        	answer[0] = -1;
        	answer[1] = -1;
        }
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < columns; j++) {
        		System.out.print(map[i][j]+" ");
        	}
        	System.out.println();
        }
        return answer;
    }
	public static void checksea(int[][] map, boolean[][] visited ,int x, int y, int rows, int columns) {
		visited[x][y] = true;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < rows && ny < columns && map[nx][ny]==0 && !visited[nx][ny]) {
				map[nx][ny] = 2;
				x = nx;
				y = ny;
				checksea(map, visited, x, y, rows,columns);
			}
		}
	}
	public static void findlake(int[][] map, boolean[][] visited ,int x, int y, int rows, int columns, int size) {
		if(max<size) Math.max(max, size);
		if(min>size) Math.min(min, size);
		visited[x][y] = true;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < rows && ny < columns && map[nx][ny]==0 && !visited[nx][ny]) {
				findlake(map, visited, nx, ny, rows,columns, size+1);
			}
		}
	}
	
}
