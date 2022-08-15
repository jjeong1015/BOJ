package Search;
// A-B-C-D-E ģ�� ���谡 �����ϴ��� ���θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
// 1��° �ٿ� ����� �� N�� ģ�� ������ �� M, 2��° �ٺ��� M���� �ٿ� ���� a�� b�� �־�����. a�� b�� ģ�� ������ ���̰� ���� ģ�� ���谡 2�� �̻� �־����� �ʴ´�.
// A-B-C-D-E ģ�� ���谡 �����ϸ� 1, �������� ������ 0 ���
import java.util.*;

public class P13023 {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	static boolean arrive;
	
	public static void main(String[] args) {
		arrive = false;
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // ��� ����
		int M = scanner.nextInt(); // ���� ����
		
		A = new ArrayList[N]; // �׷��� ������ ���� ���� ����Ʈ
		visited = new boolean[N]; // �湮 ��� ���� �迭
		
		for (int i=0; i<M; i++) {
			int S = scanner.nextInt();
			int E = scanner.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		
		for (int i=0; i<N; i++) {
			DFS(i,1); // depth 1���� ����
			if (arrive)
				break;
		}
		if (arrive)
			System.out.println("1");
		else
			System.out.println("0"); // 5�� ���̰� ���ٸ� 0 ���
	}
	public static void DFS(int now, int depth) { // DFS ����
		if (depth == 5 || arrive) { // depth 5�� �Ǹ� ���α׷� ����
			arrive = true;
			return; // �Լ� ����
		}
		visited[now] = true; // �湮 �迭�� ���� ��� �湮 ����ϱ�
		for (int i : A[now]) {
			if (!visited[i]) { // ���� ����� ���� ��� �� �湮���� ���� ���� DFS �����ϱ�
				DFS(i, depth + 1); // ��� ȣ�� �� ������ depth 1�� ����
			}
		}
		visited[now] = false;
	}
}
