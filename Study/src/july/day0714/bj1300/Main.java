package july.day0714.bj1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		long low = 1;
		long high = K;
		
		while(low < high) {
			//임의의 값을 중간값으로
			long mid = (low+high)/2;
			long count = 0;
			
			//임의의 값을 i번째 행을 나눔으로 그 수보다 작거나 같은 원소의 개수 누적합을 구함.(ex. 구구단)
			//이 때 각 행의 원소의 개수가 N을 초과하지 않아야함
			for (int i = 1; i <= N; i++) {
				count += Math.min(mid/i, N);
			}
			
			//count와 K를 비교해 임의의 값을 바꿔주기 위해 low또는 high값을 바꾸어 준다.
			if(K <= count)
				high = mid;
			else
				low = mid+1;
		}
		System.out.println(low);
	}
}
