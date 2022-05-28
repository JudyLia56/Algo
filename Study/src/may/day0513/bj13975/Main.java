package may.day0513.bj13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			PriorityQueue<Long> pq = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < N;i++) {
				pq.offer((long) Integer.parseInt(s[i]));
			}
			long answer = 0;
			if(N==1) {
				System.out.println(answer);
				return;
			}
			while(pq.size()>2) {
				long a = pq.poll();
				long b = pq.poll();
				long sum = a+b;
				answer+=sum;
				pq.offer(sum);
			}
			if(pq.size()<=2) {
				while(!pq.isEmpty()) {
					answer += pq.poll();
				}
			}
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
