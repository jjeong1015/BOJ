package NumberTheory;

import java.util.Scanner;

public class P1456 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long A = scanner.nextLong();
		long B = scanner.nextLong();
		long prime[] = new long[10000001];
		
		for (int i=2; i<prime.length; i++) { // 10������ �������� 10^7���� �ݺ�(�Ҽ� Ž��)
			prime[i] = i;
		}
		for (int i=2; i<=Math.sqrt(prime.length); i++) { // 10^7�� �����ٱ��� �ݺ� -> �ؿ� for������ ��� ���Ϸ��� ��� ������?
			if (prime[i] == 0) { // �Ҽ��� �ƴ� ��� �Ѿ
				continue; // ���� �ܰ� �ߴ� -> ���� �ܰ�� �Ѿ��
			}
			for (int j=i+i; j<prime.length; j=j+i) { // �Ҽ��� ������� 10^7���� �ݺ�
				// ex) i=2 -> for (int j=2+2(i���� 2����� ����); j<prime.length; j=4+2(i�� ��ŭ ����))
				prime[j] = 0; // i�� ������ i�� ������� �Ҽ��� �ƴ� ���� ǥ��
			}
		}
		int count = 0;
		for (int i=2; i<1000001; i++) {
			if (prime[i] != 0) { // prime �迭���� �Ҽ��� ���� ���
				long temp = prime[i]; // temp = ���� �Ҽ�
				// ���� �Ҽ��� �������� B���� ���� ���� �������� ������ ������ long ������ �Ѿ �� �־� ���� ������ ó��
				while ((double)prime[i] <= (double)B/(double)temp) { // ���� �Ҽ� <= B/temp
					if ((double)prime[i] >= (double)A/(double)temp) { // ���� �Ҽ� >= A/temp
						count++; // ī��Ʈ ����
					}
					temp = temp * prime[i]; // temp = temp * ���� �Ҽ�
				}
			}
		}
		System.out.println(count);
	}
}