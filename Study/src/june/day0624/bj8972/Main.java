package june.day0624.bj8972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static int[] dx = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dy = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static LinkedList<Arduino> list;
	static Arduino my;
	static boolean check = false;

	public static class Arduino {
		int x;
		int y;

		public Arduino(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		list = new LinkedList<>();

		// 입력
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'I')
					my = new Arduino(i, j);
				else if (map[i][j] == 'R')
					list.add(new Arduino(i, j));
			}
		}

		String str = br.readLine();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			// 기존의 종수의 위치 '.'으로 변경
			map[my.x][my.y] = '.';
			// 지정된 방향으로 이동
			my.x = my.x + dx[str.charAt(i) - '0'];
			my.y = my.y + dy[str.charAt(i) - '0'];
			// 만약 이동했는데 미친 아두이노가 있을 경우 바로 종료
			if (map[my.x][my.y] == 'R') {
				check = true;
				break;
			}
			// 움직인 위치에 종수 표시
			map[my.x][my.y] = 'I';
			// 미친 아두이노 이동
			move();
			// 미친 아두이노 이동 후 check가 true일 경우 종료
			if (check)
				break;
			cnt++;
		}
		if (check) {
			cnt++;
			System.out.println("kraj " + cnt);
		}
		else {
			for (int i = 0; i < R; i++) {
				System.out.println(map[i]);
			}
		}

	}
	//미친 아두이노 이동
	public static void move() {
		//미친 아두이노의 개수 파악하는 
		int[][] mapcnt = new int[R][C];
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Arduino cur = list.poll();
			//미친 아누이도의 현재 위치는 .으로 변경
			map[cur.x][cur.y] = '.';
			//어느 위치로 이동을 할지 정하는 함수
			int moveres = choose(cur);
			int nc = cur.x + dx[moveres];
			int nr = cur.y + dy[moveres];
			
			if(map[nc][nr]=='I') {
				check = true;
				return;
			}
			mapcnt[nc][nr]++;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(mapcnt[i][j] == 1) {
					map[i][j] = 'R';
					list.add(new Arduino(i, j));
				}
			}
		}
		return;
	}
	
	public static int choose(Arduino cur) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 1; i < 10; i++) {
			if(i == 5) continue;
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
				int dis = Math.abs(nx - my.x) + Math.abs(ny - my.y);
				if(min > dis) {
					min = dis;
					res = i;
				}
			}
		}
		return res;
	}
}
