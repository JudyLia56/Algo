package class2pp.bj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		divide(0, N-1, num);
		for (int i = 0; i < N; i++) {
			sb.append(num[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void divide(int start, int end, int[] arr) {
		if(start>=end) return;
		int mid = (start+end)/2;
		divide(start, mid, arr);
		divide(mid+1, end, arr);
		
		merge(start, mid, end, arr);
	}
	
	public static void merge(int start, int mid, int end, int[] arr) {
		int[] temp = new int[end-start+1];
		int i = start, j = mid+1, k = 0;
		while(i <= mid && j <=end) {
			if(arr[i]<arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		while(i <= mid)
			temp[k++] = arr[i++];
		while(j<= end)
			temp[k++] = arr[j++];
		
		while (k-- > 0)
			arr[start+k] = temp[k];
	}
}
