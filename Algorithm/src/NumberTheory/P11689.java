package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11689 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine()); // ���μ� ǥ��
		long result = n; // �ᱣ��
		for (long p=2; p<=Math.sqrt(n); p++) { // ��� ������� ���� �����ؼ� �����ٱ��� ���
			if (n % p == 0) { // p�� ���μ��� ���
				result = result - result / p; // �ᱣ�� = �ᱣ�� - �ᱣ�� / ���簪
				while (n % p == 0) { // n���� ���� ���μ� ���� ���� ex) 2^7*11�̶�� 2^7�� ���ְ� 11�� ����
					n /= p;
				}
			}
		}
		if (n > 1) // ���� ���μ� ������ ���� ���� �� �ݺ������� �����ٱ����� Ž�������Ƿ� 1���� ���μ��� �����Ǵ� ���̽�(n�� ������ ���μ��� ��)
			result = result - result / n; // // �ᱣ�� = �ᱣ�� - �ᱣ�� / n
		System.out.println(result);
	}
}