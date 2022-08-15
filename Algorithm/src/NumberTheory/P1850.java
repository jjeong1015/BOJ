package NumberTheory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1850 {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long A = scanner.nextLong();
		long B = scanner.nextLong();
		long result = gcd(A, B);
		
		while (result > 0) { // A, B�� �ִ� �������ŭ 1�� �ݺ��� ���
			bw.write("1"); // ��� Ƚ���� ���� ������ BufferedWriter ���
			result--;
		}
		bw.flush();
		bw.close();
	}
	
	public static long gcd(long A, long B) { // �ִ� ����� gcd() �Լ� ����
		if (B == 0) // B�� 0�� �Ǵ� ��� A�� �ִ� ����� ex) A % B = ������1 => B % ������1 = ������2 => ������1 % ������2 = ������3
			return A; // (������ ������ B ��ġ�� A ��ġ��, ������ ��ġ�� B ��ġ�� �Ѿ�� ������)
		else // ��� �Լ� ���·� ����
			return gcd(B, A % B); // gcd(���� ��, ū �� % ���� ��)
	}
}
