package DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = scanner.nextInt();
		for (int i=1; i<=N; i++) {
			myQueue.add(i); // ť�� ī�� �����ϱ�
		}
		while (myQueue.size() > 1) { // ī�尡 1�� ���� ������
			myQueue.poll(); // �� ���� ī�带 ����
			myQueue.add(myQueue.poll()); // �� ���� ī�带 ���� �Ʒ��� ī�� ������ �̵� : poll() -> add()
		}
		System.out.println(myQueue.poll()); // poll -> queue�� ù��° ���� ��ȯ�ϰ� ����, ����ִٸ� null
	}
	
}
