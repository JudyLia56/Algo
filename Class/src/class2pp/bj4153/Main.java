package class2pp.bj4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] num = new int[3];
			for (int i = 0; i < 3; i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			if(num[0]==0 && num[1]==0 && num[2]==0) break;
			Arrays.sort(num);
			if((num[0]*num[0])+(num[1]*num[1])==(num[2]*num[2])) {
				sb.append("right\n");
			}else {
				sb.append("wrong\n");
			}
		}
		System.out.println(sb.toString());
	}
}
