package july.day0701.bj18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, S, X, Y;
	static int map[][];
	static class Data implements Comparable<Data>{
		int x;
		int y;
		int type;
		int gen;
		public Data(int x, int y, int type, int gen) {
			this.x = x;
			this.y = y;
			this.type = type; // 바이러스 타입
			this.gen = gen; // 세대
		}
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			// 1. 세대 
			// 세대가 같으면 type
			if(this.gen - o.gen == 0) {
				return this.type - o.type;
			}
			return this.gen - o.gen;
		}
	}
	static PriorityQueue<Data> pq;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 맵 크기
		K = Integer.parseInt(st.nextToken()); // 바이러스 종료 1 - K
		pq = new PriorityQueue<>();
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					pq.add(new Data(i, j, map[i][j], 0));
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken()); // 시간
		X = Integer.parseInt(st.nextToken()); // 출력해야 하는 위치 x
		Y = Integer.parseInt(st.nextToken()); // 출력해야 하는 위치 y
		if(S != 0) {
			spread();
		}
			
		System.out.println(map[X-1][Y-1]);
	}
	
	static void spread() {
		// 상하좌우 바이러스를 퍼트린다.
		// 만약 바이러스를 퍼트릴 곳에 이미 바이러스가 있다면 패스
		Data cur = null;
		
		while(!pq.isEmpty()) {
			cur = pq.poll();
			
			if(cur.gen == S)
				return;
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.x + dr[dir];
				int nc = cur.y + dc[dir];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				
				if(map[nr][nc] != 0)
					continue;
				
				map[nr][nc] = cur.type;
				pq.add(new Data(nr, nc, map[nr][nc], cur.gen + 1));
			}
		}
	}
}