package june.day0615.bj14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] ground = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			ground[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for (int i = 0; i < w; i++) {
			int left = i;
			for (int l = i; l >= 0; l--) {
				if (ground[l] > ground[left])
					left = l;
			}
			int right = i;
			for (int r = i; r < w; r++) {
				if (ground[r] > ground[right])
					right = r;
			}
			//왼쪽, 오른쪽 중 작은 높이 - 현재 높이 = 빗물
			int rain = Math.min(ground[left], ground[right]) - ground[i];
			if (rain > 0)
				sum += rain;
		}

		System.out.println(sum);
	}
}
