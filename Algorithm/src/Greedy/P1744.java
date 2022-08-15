package Greedy;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
// �־��� ������ �� ���� ������ ���� �� ���� �ִ�� ����� ���α׷��� �ۼ��Ͻÿ�.
// 1��° �ٿ� ������ ũ�� N�� �־�����. 2��° �ٺ��� N���� �ٿ� ������ �� ���� �־�����.
// ���� �ִ밡 ������ ���� ������ �� �� ���� ����Ѵ�. ������ �׻� 231���� �۴�.
import java.util.Scanner;

public class P1744 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); // ��� �켱���� ť -> ���� ���� ������ �켱���� ����
		PriorityQueue<Integer> minusPq = new PriorityQueue<>(); // ���� �켱���� ť
		int one = 0; // 1�� ���� ī��Ʈ
		int zero = 0; // 0�� ���� ī��Ʈ
		for (int i=0; i<N; i++) { // �����͸� 4���� �׷쿡 �и� �����ϱ�
			int data = scanner.nextInt();
			if (data > 1) {
				plusPq.add(data);
			}
			else if (data == 1) {
				one++;
			}
			else if (data == 0) {
				zero++;
			}
			else {
				minusPq.add(data);
			}
		}
		int sum = 0;
		while (plusPq.size() > 1) { // ��� �켱���� ť ũ�Ⱑ 2���� ���� ������
			int first = plusPq.remove(); // �� 2���� ť���� ����
			int second = plusPq.remove(); 
			sum = sum + first * second; // 2���� ���� ���� ���� �ᱣ���� ����
		}
		if (!plusPq.isEmpty()) {
			sum = sum + plusPq.remove(); // ��� �켱���� ť�� �����Ͱ� ���� ������ �� �����͸� �ᱣ���� ����
		}
		while (minusPq.size() > 1) { // ���� �켱���� ť ũ�Ⱑ 2���� ���� ������
			int first = minusPq.remove(); // �� 2���� ť���� ����
			int second = minusPq.remove();
			sum = sum + first * second; // 2���� ���� ���� ���� �ᱣ���� ����
		}
		if (!minusPq.isEmpty()) { // ���� �켱���� ť�� �����Ͱ� ���� �ְ�, ������ 0�� 1���� ������ �� �����͸� �ᱣ���� ����
			if (zero == 0) {
				sum = sum + minusPq.remove();
			}
		}
		sum = sum + one; // ���� 1�� ������ �ᱣ���� ����
		System.out.println(sum);
		
		/*
		int num[] = new int[N];
		for (int i=0; i<N; i++) {
			num[i] = scanner.nextInt();
		}
		Arrays.sort(num); // �������� ����
		for (int i:num) {
			System.out.print(i + " ");
		}
		// ������ -1�� ���ؼ� ��� �������� ����� ����� ������ ū �Ŵ�� �� ����
		// ū ������ ������ �������� ���� ������ ��� �׳� ���ϱ�
		
		
		for (int i=0; i<num.length-1; i++) { // index 9 out of bounds of length 9 ��� ���� �߻�
			for (int j=i+1; j<num.length; j++) {
				if (num[i]>num[j]) { // �������� �����ؼ� ���� ������ ���� ���������� �ϱ�
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
			System.out.print(num[i]);
		}
		*/
	}
}
