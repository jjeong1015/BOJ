package Greedy;
import java.util.Arrays;
import java.util.PriorityQueue;
// N���� ���� ī�� ������ ������ ũ�Ⱑ �־��� ��, �ּ��� �� ���� �񱳰� �ʿ������� ���ϴ� ���α׷� �ۼ�(���� ������ ���� �� Ƚ���� �޶���) 
// 1��° �ٿ� N�� �־�����. �� ���� N���� �ٿ� ���� ī�� ������ ������ ũ�Ⱑ �־�����. ���� ī�� ������ ũ��� 1,000���� �۰ų� ���� ���� ������.
// 1��° �ٿ� �ּ� �� Ƚ�� ���
import java.util.Scanner;

public class P1715 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		PriorityQueue<Integer>pq = new PriorityQueue(); // Integer Ÿ������ �켱���� ť ���� -> (�⺻)���� ���� ������ �켱���� ����
		for (int i=0; i<N; i++) {
			int data = scanner.nextInt();
			pq.add(data); // �켱���� ť�� ������ ����(�߰�)
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while (pq.size() != 1) { // �켱���� ť ũ�Ⱑ 1�� �� ������
			data1 = pq.remove(); // 2�� ī�� ������ ť���� ���� (remove ����->����)
			data2 = pq.remove();
			sum += data1 + data2; // 2�� ī�� ������ ��ġ�� �� �ʿ��� �� Ƚ���� �ᱣ���� ����
			pq.add(data1 + data2); // 2�� ī�� ������ ���� �켱���� ť�� �ٽ� ���� (add ����->�߰�)
		}
		System.out.println(sum); // ������ ���� �� ����ϱ�
		/*
		int size[] = new int[N]; 
		for (int i=0; i<N; i++) {
			size[i] = scanner.nextInt();
		}
		
		for (int i=0; i<size.length-1; i++) { // �� ������ ����� ���� �߻� ?
			for (int j=i+1; j<size.length; j++) {
				if (size[i]<size[j]) { // �������� �����ؼ� ���� ������ ���� ���������� �ϱ�
					int temp = size[i];
					size[i] = size[j];
					size[j] = temp;
				}
			}
			System.out.print(size[i]);
		}
		*/
	}
}
