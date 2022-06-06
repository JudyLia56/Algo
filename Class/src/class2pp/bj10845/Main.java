package class2pp.bj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int back = -1;
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			if (str[0].equals("push")) {
				int push = Integer.parseInt(str[1]);
				queue.offer(push);
				back = push;
			} else if (str[0].equals("pop")) {
				if (queue.isEmpty())
					sb.append("-1\n");
				else {
					sb.append(queue.poll()).append("\n");
				}
			} else if (str[0].equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (str[0].equals("empty")) {
				if (queue.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (str[0].equals("front")) {
				if (queue.isEmpty())
					sb.append("-1\n");
				else
					sb.append(queue.peek()).append("\n");
			} else if (str[0].equals("back")) {
				if (queue.isEmpty())
					sb.append("-1\n");
				else
					sb.append(back).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
