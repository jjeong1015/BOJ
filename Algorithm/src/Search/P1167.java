package Search;
// Ʈ���� ����(Ʈ���� �����ϴ� ��� �� �� ��� ������ �Ÿ��� ���� �� ��)�� ���Ͻÿ�.
// 1��° �ٿ��� Ʈ���� ��� ���� V, 2��° �ٺ��� V���� �ٿ� ���� ������ ������ �־�����. ��� ��ȣ�� �־�����, ����� ������ ������ �ǹ��ϴ� ���� 2��(��� ��ȣ, �Ÿ�)�� �־�����.
// Ʈ���� ���� ���
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1167 {
	static boolean visited[]; // �湮 ��� ����
	static int[] distance; // �Ÿ� ����
	static ArrayList<Edge>[] A;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // ��� ����
		A = new ArrayList[N+1];
		for (int i=1; i<=N; i++) { // ���� ����Ʈ�� ArrayList �ʱ�ȭ
			A[i] = new ArrayList<Edge>();
		}
		for (int i=0; i<N; i++) { // ���� ����Ʈ�� �׷��� ������ ����
			int S = scanner.nextInt();
			while (true) {
				int E = scanner.nextInt();
				if (E == -1)
					break;
				int V = scanner.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N+1]; // distance �迭 �ʱ�ȭ
		visited = new boolean[N+1]; // visited �迭 �ʱ�ȭ
		BFS(1); // 1�� ���������� ����
		int Max = 1;
		for (int i=2; i<=N; i++) { // �迭���� ���� ū ���� ���ϰ� �ִ� ��带 ���������� ����
			if (distance[Max] < distance[i])
				Max = i;
		}
		distance = new int[N+1]; // distance �迭 �ʱ�ȭ
		visited = new boolean[N+1]; // visited �迭 �ʱ�ȭ
		BFS(Max); // ���ο� ���������� ����
		Arrays.sort(distance);
		System.out.println(distance[N]); // �迭���� ���� ū ���� �������� ���
	}
	private static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index); // ť �ڷᱸ���� ���� ��� ����
		visited[index] = true; // �迭�� ���� ��� �湮 ���
		while (!queue.isEmpty()) { // ť�� ������� ������
			int now_node = queue.poll(); // ť���� ��� ������ ��������
			for (Edge i : A[now_node]) { // ������ ��� ����ϱ�
				int e = i.e;
				int v = i.value;
				if (!visited[e]) { // ���� ����� ���� ��� �� �湮���� ���� ���
					visited[e] = true; // �湮 ���
					queue.add(e); // ť�� ������ ����
					distance[e] = distance[now_node]+v; // ���� ��� �Ÿ� + ���� ����ġ�� �湮���� ���� ��� �Ÿ� �迭 ������Ʈ
				}
			}
		}
	}
}
class Edge { // ���� Ŭ���� ���� ����
	int e; // ������ ���
	int value; // ���� ����ġ
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}
