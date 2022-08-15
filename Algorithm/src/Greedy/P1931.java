package Greedy;
import java.util.Arrays;
import java.util.Comparator;
// �� ȸ�Ǹ��� ���� �ð��� ������ �ð��� �־��� �� ȸ�� �ð��� ��ġ�� �����鼭 ���� ���� �����ϱ� ���� Ƚ���� �� ������ ���ϱ�
// 1��° �ٿ� ȸ���� �� N, 2��° �ٺ��� N+1�ٱ��� �� ȸ���� ���� �ð��� ������ �ð��� ������ ���̿� �ΰ� �־�����. ���� �ð��� ������ �ð��� -1���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
// 1��° �ٿ� ������ �� �ִ� ȸ���� �ִ� ������ ����Ѵ�.
import java.util.Scanner;

public class P1931 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // ȸ�� ����
		int A[][] = new int [N][2]; // ȸ�� ���� ���� -> �� 2���� �迭?
		for (int i=0; i<N; i++) {
			A[i][0] = scanner.nextInt();
			A[i][1] = scanner.nextInt();
		}
		Arrays.sort(A, new Comparator<int[]>() { // ����
			@Override
			public int compare(int S[], int E[]) {
				if (S[1] == E[1]) { // ���� �ð��� ���� ��
					return S[0] - E[0];
				}
				return S[1] - E[1];
			}
		});
		int count = 0;
		int end = -1;
		for (int i=0; i<N; i++) {
			if (A[i][0] >= end) { // �� ȸ���� ���� �ð����� ���� �ð��� ���� ȸ�ǰ� ���� ���(��ġ�� �ʴ� ���� ȸ�ǰ� ���� ���)
				end = A[i][1]; // ���� ȸ���� ���� �ð����� ���� �ð� ������Ʈ�ϱ�
				count++; // ������ �� �ִ� ȸ�� �� 1 ����
			}
		}
		System.out.println(count); // �� ���� ���� ȸ�� �� ����ϱ�
		/*
		int S[] = new int[N];
		int E[] = new int[N];
		int T[] = new int[N];
		
		for (int i=0; i<N; i++) {
			S[i] = scanner.nextInt();
			E[i] = scanner.nextInt();
			T[i] = E[i] - S[i];
		}
		
		for (int i=0; i<N-1; i++) {
			for (int j=i+1; j<N; j++) {
				if (T[i]>T[j]) {
					int temp = T[i];
					T[i] = T[j];
					T[j] = temp;
				}
			}
			System.out.print(T[i] + " "); // N-1 ������ �������� ©��
		}
		*/
	}
}
