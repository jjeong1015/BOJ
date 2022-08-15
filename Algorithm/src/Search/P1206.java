package Search;
// �׷����� DFS, BFS�� Ž���� ����� ����ϴ� ���α׷� �ۼ�
// 1��° �ٿ� ��� ���� N, ���� ���� M, Ž�� ���� ��� ��ȣ V�� �־�����. 2��° �ٿ��� ������ �����ϴ� �� ����� ��ȣ�� �־�����. �� ��� ���� ���� ���� ������ ���� �� ������ ������ ������̴�.
// 1��° �ٿ� DFS ���, 2��° �ٿ� BFS ���, V�κ��� �湮�� �� ������� ���
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1206 {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // ��� ����
		int M = scanner.nextInt(); // ���� ����
		int Start = scanner.nextInt(); // ������
		A = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>(); // ArrayList �ʱ�ȭ
		}
		for (int i=0; i<M; i++) {
			int S = scanner.nextInt(); // start
			int E = scanner.nextInt(); // end
		}
		for (int i=1; i<=N; i++) { // �湮�� ��尡 ���� ���϶�, ��ȣ ���� �� ���� �湮�ϱ� ���� ����
			Collections.sort(A[i]); // �� ���� ���õ� ���� ����
		}
		visited = new boolean[N+1]; // �湮 �迭 ����ȭ
		DFS(Start);
		System.out.println();
		visited = new boolean[N+1]; // �湮 �迭 �ʱ�ȭ
		BFS(Start);
		System.out.println();
	}
	
	public static void DFS(int Node) {
		System.out.print(Node + " "); // ���� ��� ���
		visited[Node] = true; // �迭�� ���� ��� �湮 ���
		for (int i: A[Node]) {
			if (!visited[i]) { // ���� ����� ���� ��� �� �湮���� ���� ���� DFS ���� (��� �Լ� ����)
				DFS(i);
			}
		}
	}
	
	public static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node); // ť �ڷᱸ���� ���� ��� �����ϱ�
		visited[Node] = true; // �迭�� ���� ��� �湮 ���
	
		while (!queue.isEmpty()) { // ť�� ��� ���� ������
			int now_Node = queue.poll(); // ť���� ��� ������ �������� (poll ����)
			System.out.print(now_Node + " "); // ������ ��� ����ϱ�
			for (int i : A[now_Node]) {
				if (!visited[i]) { // ���� ����� ���� ��� �� �̹湮 ��带 ť�� �����ϰ� �湮 �迭�� ����ϱ�
					visited[i] = true; 
					queue.add(i);
				}
			}
		}
	}
}
