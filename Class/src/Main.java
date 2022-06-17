import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int find = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(num[i] == find) cnt++;
		}
		
		System.out.println(cnt);
	}
}
