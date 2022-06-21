package june.day0621.bj14267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static int[] res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//상사관계 표현을 위한 list
		list = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int up = Integer.parseInt(st.nextToken());
			if(up != -1) {
				list[up].add(i);
			}
		}
		//칭찬의 양 배열
		res = new int [n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int empno = Integer.parseInt(st.nextToken());
			int praise = Integer.parseInt(st.nextToken());
			//여기서 한번 틀림. 같은 사람이 칭찬 받는 경우를 고려해야 함.
			res[empno] += praise;
		}
		//1번 사장부터 밑으로 쭉 순회
		dfs(1);
		for (int i = 1; i <= n; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int start) {
		for (int i : list[start]) {
			res[i] += res[start];
			dfs(i);
		}
	}
}
