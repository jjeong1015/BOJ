package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2751 {
	
	public static int A[], tmp[];
	public static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1]; // The index of an array originally starts at zero, but you can free up one space by doing +1 so the index starts at one
		tmp = new int[N+1]; // "
		for (int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		merge_sort(1, N); // perform merge sort
		for (int i=1; i<=N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush(); // remaining data output
		bw.close(); // close stream
	}
	private static void merge_sort(int s, int e) { // s : 1, e : N
		if (e - s < 1) // Exit - Start is less than 1 -> Means there is nothing to sort
			return;
		int m = s + (e - s) / 2; // start: s, end: e, middle: m ex) 1 + (5 - 1) / 2 = 3
		merge_sort(s, m); // Implement recursive functions -> Start : s, End (e) : m Reason -> Merge sort is broken into groups
		merge_sort(m+1, e); // Split from s to m and merge the remaining ones
		for (int i=s; i<=e; i++) {
			tmp[i] = A[i]; // tmp[] -> temporary array to be used for sorting
		}
		int k = s;
		int index1 = s; // front group start point
		int index2 = m + 1; // back group start point
		while (index1 <= m && index2 <= e) { // merge two groups logic
			// Compare the values indicated by indexes in both groups, select a smaller number,
			// store them in an array, and move the index value of the selected data one space to the right
			if (tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2]; // precede smaller values
				k++; // then increase to sort numbers
				index2++; // then increment to sort numbers
			}
			else { // (tmp[index1] <= tmp[index2])
				A[k] = tmp[index1]; // precede smaller values
				k++; // then increase to sort numbers
				index1++; // then increment to sort numbers
			}
		}
		while (index1 <= m) { // clean up the last remaining value after all groups are selected (index1 or index2)
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while (index2 <= e) { // clean up the last remaining value after all groups are selected (index1 or index2)
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}
