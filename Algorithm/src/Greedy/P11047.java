package Greedy;
// �ʿ��� ���� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ�
// 1��° �ٿ� N,K 2��° �ٺ��� N���� �ٿ� ������ ���� A[]�� ������������ �־���
// 1��° �ٿ� K���� ����� �� �ʿ��� ���� ������ �ּҰ� ���
import java.util.Scanner; // Scanner Ŭ���� ȣ�� -> stdio.h(��, ���)�� �����

public class P11047 {
	public static void main(String[] args) {
		int N;
		int K;
		Scanner scanner = new Scanner(System.in); // �Է� �ޱ� -> �̰� ���� ���� Scanner Ŭ���� ȣ�� (Ŭ���� �̸� ��ü �̸� = new Ŭ���� �̸�();)
		
		do {
			N = scanner.nextInt(); // ���� ���� -> 1<=N<=10, scanner�� ��ü �̸� -> ���� scanner ��� a�� ������ ���� scanner���� ��� a�� ������ ��
		} while (N<1 || N>10);
		
		do {
			K = scanner.nextInt(); // ��ǥ �ݾ� -> 1<=K<=100,000,000, int�� �Է� �� ����
		} while (K<1 || K>100000000);
		
		int A[] = new int[N]; // ���� ������ŭ �ڸ� Ȯ�� -> 1<=A[]<=1,000,000 -> �迭 �ִ� �����ϱ�, �迭 ���� �� �ʱ�ȭ
		
		for (int i=0; i<N; i++) { // �迭�� �� ����ֱ�
			A[i] = scanner.nextInt(); // ���� ����(����) �Է� -> ������������ �ޱ� -> ������������ ���� �ʾ����� �ٽ� �Է��ϱ� -> ���� �Է��� ���� ���� �Է��� ������ ũ�� �ٽ� �ޱ�
			//while (A[i]<A[i+1]) { // A[i+1]�� A[i]���� Ŭ ������ �ٽ� �Է� -> ������ ���� �� �����
				//A[i] = 0; // ������ ���� A[i] 0���� �ʱ�ȭ�ؼ� �ٽ� �ޱ�
				//System.out.println("�ٽ� �Է��ϼ���");
				//A[i] = scanner.nextInt();
			//}
		}
		
		int count = 0; // �� ���� ���� ī��Ʈ
		for (int i=N-1; i>=0; i--) { // �ݾ��� ū �������� �����ؾ� ������ �ּҷ� ���� ����
			if (A[i] <= K) { // ���� K(��ǥ �ݾ�)���� ���� �ݾ��� ���ų� ���� ���
				count += (K / A[i]); // ���� ���� += ��ǥ �ݾ� / ���� ���� �ݾ� -> �� ������ �� ������ ���� �� �ִ���
				K = K % A[i]; // ��ǥ �ݾ� = ��ǥ �ݾ� % ���� ���� �ݾ� -> �ְ� ���� �ݾ����� �ٽ� �ϱ�
			}
		}
		System.out.println(count);
		/*
		for (int i=0; i<N; i++) {
			A[i] = scanner.nextInt(); // ���� ����(����) �Է� -> ������������ �ޱ� -> ������������ ���� �ʾ����� �ٽ� �Է��ϱ� -> ���� �Է��� ���� ���� �Է��� ������ ũ�� �ٽ� �ޱ�
			while (A[i]<A[i+1]) { // A[i+1]�� A[i]���� Ŭ ������ �ٽ� �Է�
				System.out.println("�ٽ� �Է��ϼ���");
				A[i] = scanner.nextInt();
			}
		}
		
		for (int i=0; i<A.length-1; i++) { // ���� ���� ���� �� �������� ���� -> ū �ź��� �ݾ� ���Ϸ��� �� -> ���� ������ �ּҷ� �ϱ� ���ؼ�
			for (int j=i+1; j<A.length; j++) {
				if (A[i]<A[j]) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
			System.out.print(A[i]);
			System.out.println(" ");
		}
		
		// ���� ������ �ȵǸ� ��� �ؾ� �ϴ����� ������ �� ��
		for (int i=0; i<A.length; i++) { // �ݾ� ���ϱ�
			if (A[i] <= K) { // �ش� �ݾ��� ���� �պ��� ���ų� ���� ���
				
				count++; // 10��¥�� 2�� ���� ī��Ʈ�� 1���� �ǰ� �� ��
			}
			else
				return;
		}
		*/
	}
}