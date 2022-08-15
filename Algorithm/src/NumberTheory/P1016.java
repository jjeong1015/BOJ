package NumberTheory;

import java.util.Scanner;

public class P1016 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long min = scanner.nextLong();
		long max = scanner.nextLong();
		boolean check[] = new boolean[(int) (max - min +1)]; // �ִ񰪰� �ּڰ��� ���̸�ŭ �迭 ����
		
		for (long i=2; i*i<=max; i++) { // 2�� �������� 4���� max���� �۰ų� ���� ������ �ݺ�
			long pow = i*i; // ������
			long start_index = min/pow; // �ּڰ� / ������
			if (min % pow != 0) // �ּڰ����� �������� ���� �������� 0�� �ƴ� ���
				start_index++; // �������� ���� ��� 1�� ���ؾ� min���� ū ���������� ����
			for (long j = start_index; pow*j<=max; j++) { // �������� ��� ���·� Ž��
				check[(int) ((j*pow)-min)] = true; // j*pow�� max���� ���� �� �ּڰ�, �ִ� ������ �������̹Ƿ� check �迭�� ����
			}
		}
		int count = 0; // ������ �ƴ� �� ī��Ʈ
		for (int i=0; i<=max-min; i++) {
			if (!check[i]) { // check �迭���� ������ �ƴ� ����� count ����
				count++;
			}
		}
		System.out.println(count);
	}
}