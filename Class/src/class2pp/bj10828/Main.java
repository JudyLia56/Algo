package class2pp.bj10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			if (str[0].equals("push")) {
				int push = Integer.parseInt(str[1]);
				stack.push(push);
			} else if (str[0].equals("top")) {
				if (stack.isEmpty())
					sb.append("-1\n");
				else
					sb.append(stack.peek()).append("\n");
			} else if (str[0].equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (str[0].equals("empty")) {
				if (stack.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (str[0].equals("pop")) {
				if (stack.isEmpty())
					sb.append("-1\n");
				else
					sb.append(stack.pop()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
