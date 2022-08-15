package Greedy;
// ������ ��ȣ�� �����ϰ� ��ġ�� ������ ���� �ּҷ� ����� ���α׷� �ۼ�
// 1��° �ٿ� ���� �־�����. ���� '0'~'9', '+'�� '-'������ �̷��� �ְ�, ���� ó���� ������ ���ڴ� ���ڴ�. ���ӵ� 2�� �̻��� �����ڰ� ��Ÿ���� ������ 5�ڸ����� ���� ���ӵǴ� ���ڴ� ����. ���� ���̴� 50 ���ϴ�.
// 1��° �ٿ� ������ ����Ѵ�.
import java.util.Scanner;
public class P1541 {
	static int answer = 0; // ���� ����
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String example = scanner.nextLine();
		String str[] = example.split("-"); // ���� �����͸� "-" ��ȣ�� �������� split �����ϱ�(���ڿ� ������ �迭�� ����)
		for (int i=0; i<str.length; i++) {
			int temp = mySum(str[i]); // �ᱣ�� = mySum() �Լ� �����ϱ�
			if (i==0) // ���� �� �������� �� answer�� �ᱣ�� ���ϱ�
				answer = answer + temp; // ���� �տ� �ִ� ���� ����
			else // answer�� �ᱣ�� ����
				answer = answer - temp; // �޺κ��� ���� ������ ��
		}
		System.out.println(answer);
	}
	static int mySum(String a) { // ���� String�� �ִ� ���� ��� ���ϴ� �Լ�
		int sum = 0;
		String temp[] = a.split("[+]"); // ���� �����͸� "+" ��ȣ�� �������� split �����ϱ�(���ڿ� ������ �迭�� ����)
		for (int i=0; i<temp.length; i++) {
			sum += Integer.parseInt(temp[i]); // String ���� Integer������ ��ȯ�� ���ϰ��� ���ϱ�
		}
		return sum;
	}
}
