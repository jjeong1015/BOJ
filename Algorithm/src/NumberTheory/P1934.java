package NumberTheory;

import java.util.Scanner;

public class P1934 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i=0; i<T; i++) {
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			int result = A * B / gcd(A, B);
			System.out.println(result);
		}
		/*
		int A[] = new int[T];
		int B[] = new int[T];
		int AB[] = new int[T];
		int gcd[] = new int[T];
		int i = 0;
		for (i=0; i<T; i++) {
			A[i] = scanner.nextInt();
			B[i] = scanner.nextInt();
			
			AB[i] = A[i] * B[i];
			//System.out.println(AB[i]);
		}
		int remainder[] = new int[T];
		while (true) {
			B[i] = A[i];
			A[i] = remainder[i];
		}
		*/
	}
	
	public static int gcd(int A, int B) {
		if (B == 0) // B�� 0�� ��� A�� �ִ� �����
			return A;
		else // ��� �Լ� ����
			return gcd(B, A % B); // gcd(���� ��, ū �� % ���� ��)
		
	}
}
