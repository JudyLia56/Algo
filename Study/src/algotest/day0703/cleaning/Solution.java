package algotest.day0703.cleaning;

import java.util.Scanner;

public class Solution {
	public static int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        int[] dx = {0, 1, 0, 1, 0, -1};
        int[] dy= {1, 0, -1, 0, 1, 0};
        int num = 2;
        answer[0][0] = 1;
        int x = 0, y = 0;
        int m = 1;
        while(!check(answer)) {
        	if(horizontal) {
        		int d = 0;
        		x += dx[d];
        		y += dy[d];
        		d= (d+1)%6;
        		answer[x][y] = num++;
        		while(x < m) {
        			x += dx[d];
        			y += dy[d];
        			answer[x][y] = num++;
        		}
        		d = (d+1)%6;
        		while(y > 0) {
        			x += dx[d];
        			y += dy[d];
        			answer[x][y] = num++;
        		}
        		d = (d+1)%6;
        		horizontal = false;
        		m++;
        	}else {
        		int d = 3;
        		x += dx[d];
        		y += dy[d];
        		d= (d+1)%6;
        		answer[x][y] = num++;
        		while(y < m) {
        			x += dx[d];
        			y += dy[d];
        			answer[x][y] = num++;
        		}
        		d = (d+1)%6;
        		while(x > 0) {
        			x += dx[d];
        			y += dy[d];
        			answer[x][y] = num++;
        		}
        		d = (d+1)%6;
        		horizontal = true;
        		m++;
        	}
        }
        return answer;
    }
	public static boolean check(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		boolean hori = true;
		map = solution(N, hori);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
