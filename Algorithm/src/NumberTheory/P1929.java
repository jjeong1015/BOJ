package NumberTheory;

import java.util.Scanner;

public class P1929 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int prime[] = new int[N+1];
		for (int i=2; i<=N; i++) { // �迭 �ʱ�ȭ
			prime[i] = i;
		}
		for (int i=2; i<=Math.sqrt(N); i++) { // �����ٱ����� ����
			// N�� �����ٱ����� Ž���ϴ� ����
			// N�� a*b��� �������� ��, a�� b ��� N�� �����ٺ��� Ŭ �� ����
			// ���� N�� �����ٱ����� Ȯ���ص� ��ü ������ �Ҽ� �Ǻ� ����
			// ex) 16 = 4*4 -> 16���� ���� ���ڴ� �׻� 4���� ���� ����� ���� ��
			// ���� 4������ Ȯ���ϰ� �Ҽ� �Ǻ� ����
			if (prime[i] == 0) { // �Ҽ��� �ƴϸ� �Ѿ
				continue;
			}
			for (int j=i+i; j<=N; j=j+i) { // �Ҽ��� ��� ���� N���� �ݺ�
				prime[j] = 0; // ��� �����
			}
		}
		for (int i=M; i<=N; i++) {
			if (prime[i] != 0) { // �Ҽ��� �� ���
				System.out.println(prime[(int) i]);
			}
		}
		/*
		int prime[] = new int[N-M+1];
		int i = 0;
		int count = 0;
		System.out.println("N-M+1 : " + (N-M+1));
		
		for (i=M; i<=N; i++) {
			if (count != 0) {
				for (i=0; i<N/M; i++) { // �� ������� ��� ����
					System.out.println("�Ҽ� �ƴ�");
				}
				count = 0;
			}
			
			if (N % M == 0) { // �������� 0 -> ������ -> �ش� ���� ����� ��� �����ϱ�
				for (i=0; i<N/M; i++) { // �� ������� ��� ����
					System.out.println("����");
				}
			}
			
			else {
				System.out.println(M);
				M++;
				count = 1;
			}
		}
		*/
	}
}
