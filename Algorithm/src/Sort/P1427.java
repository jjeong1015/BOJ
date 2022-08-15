package Sort;

import java.util.Scanner;

public class P1427 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int A[] = new int[str.length()];
		for (int i=0; i<str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i+1)); // substring -> index i 에서 (i+1)-1 위치까지 리턴
		}
		for (int i=0; i<str.length(); i++) {
			int Max = i;
			for (int j=i+1; j<str.length(); j++) {
				if (A[j] > A[Max]) // 내림차순이므로 최댓값 찾기
					Max = j;
			}
			if (A[i] < A[Max]) {
				int temp = A[i];
				A[i] = A[Max];
				A[Max] = temp;
			}
		}
		for (int i=0; i<str.length(); i++) {
			System.out.println(A[i]);
		}
	}
}
