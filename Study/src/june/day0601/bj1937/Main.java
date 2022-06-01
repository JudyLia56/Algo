package june.day0601.bj1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map, dp;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                answer = Math.max(answer, dfs(i, j));

            }
        }

        System.out.println(answer);
	}
	
	static int dfs(int i, int j) {
		
		if(dp[i][j] != 0) return dp[i][j];
		
		int cnt=0;
		for (int k = 0; k < 4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			if(x<0 || x>=N || y<0 || y>=N || map[i][j] >= map[x][y]) continue;
			
			cnt = Math.max(cnt, dfs(x,y));
		}
		return dp[i][j] = cnt+1;
	}
}
