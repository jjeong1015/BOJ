package DataStructure;

import java.util.Scanner;

public class P2018 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int sum = 1;
		int count = 1; // N�� 15�� �� ���� 15�� �̴� ����� ���� �̸� �ְ� �ʱ�ȭ
		int start = 1; // start index
		int end = 1; // end index
		while (end != N) { // �����Ͱ� �̵��� ������ ������ ���հ� N�� ���� ���� ������ count 1 ����
			if (sum == N) { // count ���� end ���� sum �� ����
				count++; // ����� �� 1 ����
				end++; // end�� ���������� �� ĭ �̵� -> ���ӵ� �ڿ����� ������ �� ĭ �� Ȯ��
				sum += end; // sum = sum + end
			}
			else if (sum > N) { // sum �� ����, start ����
				sum -= start; // sum = sum - start
				start++; // start�� ���������� �� ĭ �̵� -> ���ӵ� �ڿ������� ���� ���� ����
			}
			else { // end ����, sum �� ����
				end++; // end�� ���������� �� ĭ �̵� -> ���ӵ� �ڿ����� ������ �� ĭ �� Ȯ��
				sum += end; // sum = sum + end
			}
		}
		/*
		for (int i=0; i<N; i++) {
			num++;
			sum += num;
			System.out.println("if�� ���� �� sum�� " + sum);
			if (sum == N) {
				System.out.println("i�� " + i);
				System.out.println("sum�� " + sum);
				System.out.println("N�� " + N);
				++count;
			}
			//num++;
			System.out.println(num);
		}
		*/
		System.out.print(count);
	}
	
}
