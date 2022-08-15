package Search;
// ���� N�� �־����� �� N�� �ڸ� ���� �� ���ʺ��� ��� ��� �Ҽ��� ���� ã�ƺ���
// 1��° �ٿ� N(1<=N<=8)�� �־�����.
// N�� �ڸ� ���� �� ��� ��� �Ҽ��� ���� �������� ������ 1�ٿ� 1���� ����Ѵ�.
import java.util.Scanner;

public class P2023 {
	
	static int N;

	public static void main(String[] args) {
		/*
		long count;
		long num[] = new long[99999999];
		long prime;
		Scanner scanner = new Scanner(System.in);
		System.out.print("N�� �ڸ� ���ڸ� �Է��ϼ��� : ");
		int n = scanner.nextInt();
	
		if (n==1) {
			for (int i=1; i<10; i++) {
				prime = 1;
				prime += 1;
				num[i] = 1;
				num[i] += 1;
				if ((prime == 2)||(prime == 3)||(prime == 5)||(prime == 7)) {
					// ���� 1���� 9���� �� ������ �� ���� �� ���ǹ��� ���ϴ� �� ����ϱ�
					System.out.println(prime); // ����ϸ� �� 2�� 8�� ������?
				}
			}
		}
		
		if (n==2) {
			// ���� 10���� 99 (¦�� && �Ҽ������� �� && ���� �ִ� ��) �����ϰ� ���
			for (int i=10; i<100; i++) {
				prime = 10;
				prime += 1;
				num[i] = 10;
				num[i] += 1;
			}
		}
		
		if (n==3) {
			// ���� 100���� 999 (¦�� && �Ҽ������� �� && ���� �ִ� ��) �����ϰ� ���
			for (int i=100; i<1000; i++) {
				prime = 100;
				prime += 1;
				num[i] = 100;
				num[i] += 1;
			}
		}
		
		if (n==4) {
			// ���� 1000���� 9999 (¦�� && �Ҽ������� �� && ���� �ִ� ��) �����ϰ� ���
			for (int i=1000; i<10000; i++) {
				prime = 1000;
				prime += 1;
				num[i] = 1000;
				num[i] += 1;
			}
		}
		
		if (n==5) {
			// ���� 10000���� 99999 (¦�� && �Ҽ������� �� && ���� �ִ� ��) �����ϰ� ���
			for (int i=10000; i<100000; i++) {
				prime = 10000;
				prime += 1;
				num[i] = 10000;
				num[i] += 1;
			}
		}
		
		if (n==6) {
			// ���� 100000���� 999999 (¦�� && �Ҽ������� �� && ���� �ִ� ��) �����ϰ� ���
			for (int i=100000; i<1000000; i++) {
				prime = 100000;
				prime += 1;
				num[i] = 100000;
				num[i] += 1;
			}
		}
		
		if (n==7) {
			// ���� 1000000���� 9999999 (¦�� && �Ҽ������� �� && ���� �ִ� ��) �����ϰ� ���
			for (int i=1000000; i<10000000; i++) {
				prime = 1000000;
				prime += 1;
				num[i] = 1000000;
				num[i] += 1;
			}
		}
		
		if (n==8) {
			// ���� 10000000���� 99999999 (¦�� && �Ҽ������� �� && ���� �ִ� ��) �����ϰ� ���
			for (int i=10000000; i<100000000; i++) {
				prime = 10000000;
				prime += 1;
				num[i] = 10000000;
				num[i] += 1;
			}
		}
		
		// �������� ����
		for(int i=0; i<num.length-1;i++) {
			for(int j=i+1; j<num.length;j++) {
				if(num[i]>num[j]) {
					long tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
			//System.out.println(num[i]);
		}
		*/
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		DFS(2,1); // DFS �����ϱ� 2, 3, 5, 7�� Ž�� ����
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	static void DFS(int number, int jarisu) {
		if (jarisu == N) { // �ڸ��� = N -> �� �Ҹ��� ����
			if (isPrime(number)) { // �Ҽ� ���
				System.out.println(number); 
			}
			return; // Ž�� ����
		}
		for (int i=1; i<10; i++) { // 1~9 �ݺ�
			if (i%2 == 0) {
				continue;
			}
			if (isPrime(number*10 + i)) { // ���ڸ� ���� Ȧ���̸鼭 �Ҽ��� ���
				DFS(number*10+i, jarisu+1); // ����Լ��� �ڸ��� �ø� -> DFS ���� : �ڸ��� + 1, �� * 10 + ���ڸ� ��
			}
		}
	}
	static boolean isPrime(int num) {
		for (int i=2; i<=num/2; i++) // �Ҽ� ���ϱ� �Լ�
			if (num % i == 0)
				return false; // �Ҽ� �ƴ�
		return true;
	}
}
