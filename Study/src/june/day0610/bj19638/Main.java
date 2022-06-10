package june.day0610.bj19638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, H, T;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));

		for (int i = 0; i < T; i++) {
			int giant = pq.peek();
			if (giant < H) {
				System.out.println("YES");
				System.out.println(i);
				System.exit(0);
			} else if (giant > 1) {
				pq.poll();
				pq.add(giant / 2);
			}
		}

		if (pq.peek() < H) {
			System.out.println("YES");
			System.out.println(T);
		} else {
			System.out.println("NO");
			System.out.println(pq.peek());
		}
	}
}
