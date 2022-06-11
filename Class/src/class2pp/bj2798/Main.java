package class2pp.bj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < N - 2; i++) {
			if (card[i] > M)
				continue;
			for (int j = i + 1; j < N - 1; j++) {
				if (card[i] + card[j] > M)
					continue;
				for (int j2 = j + 1; j2 < N; j2++) {
					int com = card[i] + card[j] + card[j2];
					if (M == com) {
						System.out.println(com);
						return;
					}
					if (max < com && com < M) {
						max = com;
					}
				}
			}
		}
		System.out.println(max);
	}
}
