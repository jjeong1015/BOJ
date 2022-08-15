package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P21568 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long gcd = gcd(a, b);
		if (c % gcd != 0) { // c�� �ִ� ������� ����� �ƴ� ��� -1 ���
			System.out.println(-1);
		}
		else {
			int mok = (int) (c / gcd);
			long ret[] = Excute(a, b); // ������(b)�� 0�� �� ������ ��� �Լ��� ȣ���ϴ� ��Ŭ���� ȣ���� �Լ� ȣ��
			System.out.println(ret[0] * mok + " " + ret[1] * mok); // �ᱣ���� c / �ִ� ������� ���� ���� �� �ش� �� ���
		}
	}
	
	private static long[] Excute(long a, long b) {
		long ret[] = new long[2];
		if (b == 0) {
			ret[0] = 1; ret[1] = 0; // x=1, y=0���� �����ϰ� ����
			return ret;
		}
		long q = a / b;
		long v[] = Excute(b, a % b); // ��� ���·� ��Ŭ���� ȣ���� ����
		ret[0] = v[1]; // �������� �ö���鼭 x, y���� ����ϴ� ���� (x=y', y=x'-y' * ��)
		ret[1] = v[0] - v[1] * q;
		return ret;
	}
	
	private static long gcd(long a, long b) { // �ִ� ����� gcd �Լ� ����
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a); // b�� 0�� ��� ���� a ��ȯ
	}
}
