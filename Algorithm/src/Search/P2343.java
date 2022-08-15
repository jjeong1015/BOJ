package Search;
// ��緹���� ũ�� �� �ּڰ��� ���ϴ� ���α׷� �ۼ�
// 1��° �ٿ� ������ �� N, M�� �ְ� 2��° �ٿ� ������ ���̰� ���� ������� �� ������ �ڿ����� �־�����. ������ ���̴� 10,000���� ���� �ʴ´�.
// 1��° �ٿ� ��緹�� ũ�� �� �ּڰ��� ����Ѵ�.
import java.util.Scanner;

public class P2343 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // ���� ����
		int M = scanner.nextInt(); // ��緹�� ����
		int A[] = new int[N]; // ���� �迭 ����
		int start = 0;
		int end = 0;
		for (int i=0; i<N; i++) {
			A[i] = scanner.nextInt();
			if (start < A[i]) start = A[i]; // ���� �ε��� ����(�迭 �� �ִ�)
			end = end + A[i]; // ���� �ε��� ����(�迭 ����)
		}
		while (start <= end) {
			int middle = (start+end)/2; // �߰� �ε���
			int sum = 0; // ���� ��
			int count = 0; // ���� ����� ��緹�� ����
			for (int i=0; i<N; i++) { // �߰� �ε��� ������ ��� ������ ������ �� �ִ��� Ȯ��
				if (sum + A[i] > middle) { // ���� �� + ���� �ð� > �߰� �ε���
					count++; // count�� �ø���
					sum = 0; // 0���� ���� -> ��緹�̿� ������ �� ���� �� ��緹�̷� ��ü�Ѵٴ� ��
				}
				sum = sum + A[i]; // sum�� ���� ���� �ð��� ���ϱ�
			}
			if (sum != 0) // 0�� �ƴ� ��� ������ ��緹�� �ʿ�
				count++; // count�� �ø���
			if (count > M) // �߰� �ε��������� ��� ���� ���� �Ұ���
				start = middle + 1; // ���� �ε��� = �߰� �ε��� + 1;
			else // ��� ���� ���� ����
				end = middle - 1; // ���� �ε��� = �߰� �ε��� - 1;
			System.out.println(count);
		}
		System.out.println(start); // ���� �ε��� ���
	}

}
