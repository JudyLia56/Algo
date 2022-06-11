package class2pp.bj10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			String str = s[0];
			if(str.equals("push_front")) {
				int num = Integer.parseInt(s[1]);
				dq.addFirst(num);
			}else if(str.equals("push_back")) {
				int num = Integer.parseInt(s[1]);
				dq.addLast(num);
			}else if(str.equals("pop_front")) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.removeFirst()).append("\n");
				}
			}else if(str.equals("pop_back")) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.removeLast()).append("\n");
				}
			}else if(str.equals("size")) {
				sb.append(dq.size()).append("\n");
			}else if(str.equals("empty")) {
				if(dq.isEmpty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}else if(str.equals("front")) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.peekFirst()).append("\n");
				}
			}else if(str.equals("back")) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.peekLast()).append("\n");
				}
			}
			
		}
		System.out.println(sb.toString());
	}
}
