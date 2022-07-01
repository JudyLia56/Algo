package july.day0701.bj7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static List<String> res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			res = new ArrayList<String>();
			dfs(1,"1");
			//정렬을 해야함.
			Collections.sort(res);
			for (int j = 0; j < res.size(); j++) {
				sb.append(res.get(j)).append("\n");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	//dfs를 통해 모든 경우를 탐색
	public static void dfs(int num, String str) {
		String[] oper = {"+", "-", " "};
		if(num == N) {
			//공백으로 뒀던 것을 연결시키기 위해 연결 후에 calc로 전달 
			String s = str.replace(" ", "");
			if(calc(s)) res.add(str);
			return;
		}
		//+,-," "중 하나
		for (int i = 0; i < 3; i++) {
			String next = Integer.toString(num+1);
			dfs(num+1, str+oper[i]+next);
		}
	}
	//식이 완성되면 합을 계산할 함수, 합이 0인 경우 true 반환
	public static boolean calc(String s) {
		//s를 +혹은 -를 기준으로 분리, 끝에 true를 붙여서 -,+도 분리에 포함시킴.
		StringTokenizer st = new StringTokenizer(s, "-|+",true);
		int sum = 0;
		sum += Integer.parseInt(st.nextToken());
		while(st.hasMoreElements()) {
			String op = st.nextToken();
			if(op.equals("-")) sum -= Integer.parseInt(st.nextToken());
			else sum += Integer.parseInt(st.nextToken());
		}
		//합이 0이면 true 반환
		if(sum == 0) return true;
		else return false;
	}
}
/*
 StringTokenizer에서 true쓰는 것과 hasMoreElements()
 */
