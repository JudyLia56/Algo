package july.day0707.bj1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	private static int[][] map;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int h = r2 - r1 + 1;
		int w = c2 - c1 + 1;
		map = new int[h][w];
		
		int x = 0, y = 0, d = 0, num = 1, cnt = 0, wCnt = 0, dCnt = 1;
		while (true) {
			// 배열을 다 채웠을 경우
			if(wCnt >= h*w) {
				break;
			}
			//범위를 벗어나지 않을 경우에 배열안에 숫자를 기록
			if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
				map[x - r1][y - c1] = num;
				wCnt++;
			}
			num++;
			cnt++;
			x = x + dx[d];
			y = y + dy[d];
			if (cnt == dCnt) {
				cnt = 0;
				// 숫자를 채우는 칸이 늘어남
				if (d == 1 || d == 3)
					dCnt++;
				d = (d + 1) % 4;
			}
		}
		// log를 사용해 빈칸을 맞춰서 출력할 수 있게
		int blank = (int)(Math.log10(num)+1);
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int len = (int)(Math.log10(map[i][j])+1);
				for (int k = 0; k < blank-len; k++) {
					System.out.print(" ");
				}
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
 
}