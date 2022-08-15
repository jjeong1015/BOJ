package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P11286 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs)
				return o1 > o2 ? 1 : -1; // ������ ������ ���� �켱 ����
			else
				return first_abs - second_abs; // ������ �������� ����
					
		});
		for (int i=0; i<N; i++) {
			int request = Integer.parseInt(br.readLine());
			if (request == 0) { // ��û�� 0�� ��� : ť�� ��� ������ 0, ��� ���� ������ ť�� front�� ���(poll())
				if (MyQueue.isEmpty())
					System.out.println("0");
				else
					System.out.println(MyQueue.poll());
			}
			else { // ��û�� 1�� ��� : ���ο� �����͸� �켱���� ť�� ���ϱ�(add())
				MyQueue.add(request);
			}
		}
	}
	
}