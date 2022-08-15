package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class P1874 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int A[] = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = scanner.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer();
		int num = 1; // �������� ��
		boolean result = true;
		for (int i=0; i<A.length; i++) {
			int su = A[i]; // ���� ������ ��
			if (su >= num) { // ���� ���� �� >= �������� �ڿ���
				while (su >= num) { // ���� ������ ������ push() ����
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			}
			else { // ���� ���� �� < �������� �ڿ��� (pop()�� ������ ���� ���Ҹ� ����)
				int n = stack.pop(); // ������ ���� ���� ���� ������ �ϴ� ������ ������ ũ�� ������ ����� �� ����
				if (n > su) { // ���� pop �ᱣ�� > ������ ��
					System.out.println("NO");
					result = false;
					break;
				}
				else {
					bf.append("-\n");
				}
			}
		}
		if (result) System.out.println(bf.toString()); // ���� ����� ���� ���� ��� ������ �� ���
	}
}
