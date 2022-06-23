package class2pp.bj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean check = true;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(c == '(') stack.push('(');
				else {
					if(!stack.isEmpty()) stack.pop();
					else {
						check = false;
						break;
					}
				}
			}
			if(!stack.isEmpty()) check = false;
			if(check) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb.toString());
	}
}
