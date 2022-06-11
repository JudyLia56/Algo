package class2pp.bj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			LinkedList<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			
			int cnt = 0;
			
			while(!q.isEmpty()) {
				int[] front = q.poll();
				boolean isMax = true;
				for (int j = 0; j < q.size(); j++) {
					if(front[1] < q.get(j)[1]) {
						q.offer(front);
						for (int j2 = 0; j2 < j; j2++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}
				if(isMax == false) {
					continue;
				}
				cnt++;
				if(front[0] == M) {
					break;
				}
			}
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
