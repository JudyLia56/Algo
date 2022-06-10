package june.day0610.bj6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long count = 0;
		Stack<Integer> stack = new Stack<>();
		int n;
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(br.readLine());
			while(!stack.isEmpty() && stack.peek()<=n) {
				stack.pop();
			}
			count += stack.size();
			stack.push(n);
		}
		System.out.println(count);
	}
}
