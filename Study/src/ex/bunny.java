package ex;

import java.util.Scanner;

public class bunny {
	
	static int[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			map = new int[10];
			for(int i = 0; i < 10; i++) {
				map[i] = sc.nextInt();
			}
			
			int[][] bunny = new int[5][2];
			
			for(int i = 0; i < 5; i++) {
				for (int j = 0; j < 2; j++) {
					bunny[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			
			for (int i = 0; i < 5; i++) {
				int up = bunny[i][0];
				int down = bunny[i][1];
				
				if(bunnyrun(up, down)) cnt++;
				
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean bunnyrun(int up, int down) {
		int idx = 0;
		while(true) {
			if(idx==9) {
				return true;
			}
			
			if(map[idx] < map[idx+1] ) {
				if(map[idx+1]-map[idx] > up) return false;
				else idx+=1;
			}else if(map[idx] > map[idx+1]) {
				if(map[idx]-map[idx+1] > down) return false;
				else idx+=1;
			}else {
				idx+=1;
			}
		}
	}
}
