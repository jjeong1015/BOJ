package DataStructure;

import java.util.Scanner;

public class P10986 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		long S[] = new long[N]; // �� �迭
		long C[] = new long[M]; // ���� �������� �ε����� ī��Ʈ�Ĵ� �迭
		long answer = 0;
		S[0] = scanner.nextInt();
		for (int i=1; i<N; i++) { // ���� �� �迭 �����
			S[i] = S[i-1] + scanner.nextInt();
		}
		for (int i=0; i<N; i++) { // �� �迭�� ��� ���� %(������) ���� �����ϱ�
			int remainder = (int) (S[i] % M); // �� �迭�� M���� ���� ������ ��
			if (remainder == 0) answer++; // 0 ~ i������ ���� �� ��ü�� 0(�̹� M���� ���������)�� �� ���信 ���ϱ�
			C[remainder]++; // �������� ���� �ε����� ���� ī�����ϱ�
		}
		for (int i=0; i<M; i++) {
			if (C[i] > 1) { // C[i](i�� �������� �ε��� ����)���� 2������ �̴� ����� �� ���ϱ�
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}
}
