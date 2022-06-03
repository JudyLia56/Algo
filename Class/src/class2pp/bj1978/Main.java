package class2pp.bj1978;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 배열 입력 받기
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		// 소수 개수 담을 변수
		int cnt = 0;
		for (int i = 0; i < n; i++) {// 배열을 하나씩 돌면서 소수인지 판별한다
			int j = 2;
			for (; j < nums[i]; j++) {
				if (nums[i] % j == 0)
					break;
			}
			if (j == nums[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
