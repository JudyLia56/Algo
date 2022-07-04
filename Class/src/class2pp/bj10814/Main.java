package class2pp.bj10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		String[][] user = new String[N][2];
		for (int i = 0; i < user.length; i++) {
			st = new StringTokenizer(br.readLine());
			user[i][0] = st.nextToken();
			user[i][1] = st.nextToken();
		}
		
		Arrays.sort(user, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			sb.append(user[i][0]).append(" ").append(user[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}
