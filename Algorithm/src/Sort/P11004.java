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
			if (pivot == K) // K번째 수가 pivot이면 더 이상 구할 필요가 없음
				return;
			else if (K < pivot) // K번째 수가 pivot보다 작으면 왼쪽 그룹만 정렬
				quickSort(A, S, pivot-1, K); 
			else // K번째 수가 pivot보다 크면 오른쪽 그룹만 정렬
				quickSort(A, pivot+1, E, K);
		}
	}
	public static int partition(int A[], int S, int E) {
		int M = (S+E) / 2;
		swap(A, S, M); // 중앙값을 1번째 요소로 이동
		int pivot = A[S];
		int i = S, j = E; // 시작 : S, 끝 : E
		while (i < j) {
			while (pivot < A[j]) { // pivot보다 작은 수가 나올 때까지 j--
				j--;
			}
			while (i < j && pivot >= A[j]) { // pivot보다 큰 수가 나올 때까지 i++
				i++;
			}
			swap(A, i, j); // 찾은 i와 j를 교환
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
