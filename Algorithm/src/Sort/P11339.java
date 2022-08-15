package Sort;

import java.util.Scanner;

public class P11339 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int P[] = new int[N];
		for (int i=0; i<N; i++) {
			P[i] = scanner.nextInt();
		}
		for (int i=0; i<P.length-1; i++) {
			for (int j=i+1; j<P.length; j++) {
				if (P[i] > P[j]) {
					int temp = P[i];
					P[i] = P[j];
					P[j] = temp;
				}
			}
		}
		int sum = 0;
		int total = 0;
		for (int i=0; i<P.length; i++) {
			sum += P[i]; // sum[i] = sum[i] + p[i];
			total += sum;
		}
		System.out.println(total);
	}
}
