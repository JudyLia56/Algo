package july.day0714.bj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	// dir => 0 = 정방향, 1 = 역방향
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; ++tc) {
			Deque<Integer> deq = new ArrayDeque<Integer>();
			
			String p = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			String input = br.readLine();	
			input = input.substring(1, input.length() - 1);
			st = new StringTokenizer(input, ",");
			for (int i = 0; i < N; ++i) {
				deq.offer(Integer.parseInt(st.nextToken()));
			}
			int dir = 0;
			boolean isError = false;
			for (int i = 0; i < p.length(); ++i) {
				char current = p.charAt(i);
				if (current == 'R') {
					dir = (dir + 1) % 2;
				}
				else if (current == 'D') {
					if (deq.isEmpty()) {
						isError = true;
						break;
					}
					if (dir == 0) {
						deq.pollFirst();
					}
					else {
						deq.pollLast();
					}
				}
			}
			if (isError) {
				sb.append("error\n");
			}
			else {
				sb.append("[");
				while (deq.size() > 1) {
					if (dir == 0) {
						sb.append(deq.pollFirst());
					}
					else {
						sb.append(deq.pollLast());
					}
					
					sb.append(",");
				}
				// 빈배열일 경우 체크
				if (deq.size() == 0) {
					sb.append("]\n");
				}
				else {
					// 마지막 숫자도 저장
					sb.append(deq.pollFirst()).append("]\n");
				}
			}
		}
		System.out.println(sb);
	}
}