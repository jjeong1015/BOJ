package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int A[] = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, N-1, K-1);
		System.out.println(A[K-1]);
	}
	public static void quickSort(int A[], int S, int E, int K) {
		if (S < E) {
			int pivot = partition(A, S, E);
			if (pivot == K) // K��° ���� pivot�̸� �� �̻� ���� �ʿ䰡 ����
				return;
			else if (K < pivot) // K��° ���� pivot���� ������ ���� �׷츸 ����
				quickSort(A, S, pivot-1, K); 
			else // K��° ���� pivot���� ũ�� ������ �׷츸 ����
				quickSort(A, pivot+1, E, K);
		}
	}
	public static int partition(int A[], int S, int E) {
		int M = (S+E) / 2;
		swap(A, S, M); // �߾Ӱ��� 1��° ��ҷ� �̵�
		int pivot = A[S];
		int i = S, j = E; // ���� : S, �� : E
		while (i < j) {
			while (pivot < A[j]) { // pivot���� ���� ���� ���� ������ j--
				j--;
			}
			while (i < j && pivot >= A[j]) { // pivot���� ū ���� ���� ������ i++
				i++;
			}
			swap(A, i, j); // ã�� i�� j�� ��ȯ
		}
		A[S] = A[i];
		A[i] = pivot;
		return i;
	}
	public static void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
