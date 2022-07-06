package july.day0707.bj21610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int N, m;
	public static ArrayList<Node> cloud;
	public static int[][] map;
	public static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	public static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Node> cloud = new ArrayList<>();
		cloud.add(new Node(N - 1, 0));
		cloud.add(new Node(N - 1, 1));
		cloud.add(new Node(N - 2, 0));
		cloud.add(new Node(N - 2, 1));

		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			boolean[][] check = new boolean[N][N];
			// 구름 이동
			for (Node node : cloud) {
				int nx = node.x + dx[d] * (a % N);
				int ny = node.y + dy[d] * (a % N);
				if (nx < 0) {
					nx = N - Math.abs(nx);
				} else if (nx >= N) {
					nx -= N;
				}

				if (ny < 0) {
					ny = N - Math.abs(ny);
				} else if (ny >= N) {
					ny -= N;
				}

				map[nx][ny] += 1;
				check[nx][ny] = true;

				node.x = nx;
				node.y = ny;
			}

			int[][] map_copy = new int[N][N];
			for (Node node : cloud) {
				int cnt = 0;

				for (int i = 2; i <= 8; i += 2) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
						continue;
					}
					if (map[nx][ny] > 0) {
						cnt++;
					}
				}
				map_copy[node.x][node.y] = cnt;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += map_copy[i][j];
				}
			}
			cloud.clear();

			// 구름 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 2 && !check[i][j]) {
						cloud.add(new Node(i, j));
						map[i][j] -= 2;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += map[i][j];
			}
		}

		System.out.println(ans);
	}
}