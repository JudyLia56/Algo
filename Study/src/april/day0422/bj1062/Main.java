package april.day0422.bj1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String[] word;
	static int N,K, answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		//알파벳을 배웠는지 안배웠는지 확인하기 위한 check
		int check =0;
		// 알파벳을 숫자로
		check |= 1 << (int)'a'-96;
		check |= 1 << (int)'c'-96;
		check |= 1 << (int)'i'-96;
		check |= 1 << (int)'n'-96;
		check |= 1 << (int)'t'-96;
		//단어들의 배열
		word = new String[N];
		//배열에 넣어줄때 a,c,i,n,t는 지워준다(기본으로 배운다고 생각하기 때문에)
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			s = s.replaceAll("[a,c,i,n,t]", "");
			word[i] = s;
		}
		if(K>=5) {
			test(0, 5, check);
		}
		System.out.println(answer);
	}
	
	static void test(int idx, int cnt, int mask) {
		if(cnt == K) {
			int count = 0;
			for(int i=0; i<N; i++) {
				boolean flag = true;
				for(int j=0; j<word[i].length(); j++) {
					//i 번째 단어에서 한글자라도 배우지 않았을 경우
					if((mask & (1<< word[i].charAt(j)-96)) == 0) {
						flag = false;
						break;
					}
				}
				if(flag) count++;
			}
			answer = Math.max(answer, count);
			return;
		}
		//해당 단어를 아직 배우지 않았다면 골라본다.
		for(int i=idx; i<27; i++) {
			if((mask & (1<<i)) == 0) {
				test(i+1, cnt+1, mask|(1<<i));
			}
		}
	}
}
