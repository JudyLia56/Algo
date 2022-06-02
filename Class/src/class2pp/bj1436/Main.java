package class2pp.bj1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int num = 666;
		while(cnt!=N) {
			String s = Integer.toString(num);
			if(s.contains("666")) cnt++;
			num++;
		}
		System.out.println(num-1);
	}
}
