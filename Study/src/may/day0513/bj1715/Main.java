package may.day0513.bj1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		while(pq.size()>1) {
			int a = pq.poll();
			int b = pq.poll();
			int sum = a+b;
			answer+=sum;
			pq.offer(sum);
		}
		System.out.println(answer);
	}
}
