package DataStructure;

import java.util.Deque; // double-ended queue (ť�� �������� ��� ���԰� ���� ����)
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class P11003 {
	
	public static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ����� ���ۿ� �ְ� �� ���� ����ϱ� ���� ���
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>(); // �����͸� ���� �� �ڷᱸ��
		for (int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken()); // ���� ������ ��
			
			while (!mydeque.isEmpty() && mydeque.getLast().value > now) { // ���� ������ ��ġ�������� now���� ū ���� ������ ����
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now, i)); // ���� ������ ��ġ�� now �� ����
			
			if (mydeque.getFirst().index <= i-L) { // ���� 1��° ��ġ�������� L�� ������ ��� ��(now index-L <= index)�� ������ ����(�������� ��� ���� ������ ����)
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value + " "); // ���� 1��° ������ ���
		}
		bw.flush(); // ���� ���ۿ� ����Ǿ� �ִ� ������ Ŭ���̾�Ʈ�� �����ϰ� ���۸� ����
		bw.close(); // ��Ʈ�� ����(+flush �Լ� ȣ��)
	}
	
	static class Node { // ���� ������ ��� Ŭ����(�ڽ��� ��ġ, �ڽ��� �� ���) ���� ����
		public int value;
		public int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
