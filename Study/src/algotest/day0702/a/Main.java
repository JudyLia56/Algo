package algotest.day0702.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, answer;
	static int[][] town;
	static int max = 0;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		town = new int[N+2][2];
		visited = new boolean[N+2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			town[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			town[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0,K);
		System.out.println(max);
	}
	
	public static void dfs(int start, int powersum, int leftpower) {
		if(powersum > leftpower || start == N+1) {
			int res = 0;
			for (int i = 1; i <= N; i++) {
				if(visited[i] == true) {
					res += town[i][1];
				}
			}
			max = Math.max(max, res);
			return;
		}
		visited[start] = true;
		for (int i = 1; i <= N+1; i++) {
			if(!visited[i]) {
				dfs(i, powersum+town[i][0], leftpower-powersum);
				visited[i] = false;
			}
				
		}
		
	}
}
