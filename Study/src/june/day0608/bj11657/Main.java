package june.day0608.bj11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int start;
	int end;
	int cost;

	public Node(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class Main {

	static int N, M;
	static int INF = Integer.MAX_VALUE;
	static long[] dist;
	static Node[] node;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new long[N + 1];
		for (int i = 0; i <= N; i++) {
			dist[i] = INF;
		}
		node = new Node[M + 1];
		// node정보 받아와 배열 만들기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			node[i] = new Node(start, end, cost);
		}

		bellmanFord();
		System.out.println(sb.toString());
	}

	public static void bellmanFord() {
		dist[1] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Node n = node[j];
				if (dist[n.start] != INF && dist[n.end] > dist[n.start] + n.cost) {
					dist[n.end] = dist[n.start] + n.cost;
				}
			}
		}
		if(check()) {
			sb.append("-1\n");
			return;
		} else {
			for (int i = 2; i <= N; i++) {
				if(dist[i]==INF) sb.append("-1\n");
				else sb.append(dist[i]).append("\n");
			}
		}
	}

	public static boolean check() {
		// 음수 사이클 확인
		for (int i = 0; i < M; i++) {
			Node n = node[i];
			if (dist[n.start] != INF && dist[n.end] > dist[n.start] + n.cost) {
				return true;
			}
		}
		return false;
	}
}
