package class2pp.bj10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void quickSort(int start, int end, int[] arr) {
		if (start >= end)
			return;

		int left = start + 1, right = end;
		int pivot = arr[start];

		while (left <= right) {
			while (left <= end && arr[left] <= pivot)
				left++;
			while (right > start && arr[right] >= pivot)
				right--;

			if (left <= right) {
				swap(arr, left, right);
			} else {
				swap(arr, start, right);
			}
		}
		quickSort(start, right - 1, arr);
		quickSort(right + 1, end, arr);
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
